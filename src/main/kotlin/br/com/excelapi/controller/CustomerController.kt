package br.com.excelapi.controller

import br.com.excelapi.dto.CustomerDTO
import br.com.excelapi.model.Customer
import br.com.excelapi.service.CustomerService
import br.com.excelapi.service.FileStorageService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/customers")
class CustomerController
    (val customerService: CustomerService,
     val fileStorageService: FileStorageService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAll(): List<Customer> = customerService.findAll()


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customerDTO: CustomerDTO){
        customerService.createCustomer(customerDTO.dtoToCustomer())
    }

    @PostMapping("/{filename}")
    @ResponseStatus(HttpStatus.CREATED)
    fun createFromExcel(@PathVariable filename: String){
        customerService.excelToCustomer(filename)
    }

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    fun uploadFile(@RequestParam file: MultipartFile){
        try{
            fileStorageService.save(file)
        } catch (e: Exception){
            throw RuntimeException("Could not upload the file. Error: ${e.message}")
        }
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateById(@PathVariable id: Long, @RequestBody customerDTO: CustomerDTO){
        customerService.updateById(id, customerDTO)
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteById(@PathVariable id: Long){
        customerService.deleteById(id)
    }

}
