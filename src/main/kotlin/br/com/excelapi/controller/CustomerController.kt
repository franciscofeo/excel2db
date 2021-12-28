package br.com.excelapi.controller

import br.com.excelapi.dto.CustomerDTO
import br.com.excelapi.model.Customer
import br.com.excelapi.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController (val customerService: CustomerService) {

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