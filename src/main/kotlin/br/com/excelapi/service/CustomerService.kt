package br.com.excelapi.service

import br.com.excelapi.dto.CustomerDTO
import br.com.excelapi.model.Customer
import br.com.excelapi.repository.CustomerRepository
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.springframework.stereotype.Service
import java.io.FileInputStream

@Service
class CustomerService (val customerRepository: CustomerRepository) {


    fun findAll(): List<Customer>{
        return customerRepository.findAll()
    }

    fun createCustomer(customer : Customer){
        customerRepository.save(customer)
    }

    fun excelToCustomer(filename: String) {

        val inputStream = FileInputStream("./$filename")
        val excelFile = WorkbookFactory.create(inputStream)
        val excelSheet = excelFile.getSheetAt(0)

        var rowNumb = 1

        while(rowNumb < excelSheet.physicalNumberOfRows){

            val it = excelSheet.getRow(rowNumb)
            val name: String = it.getCell(1).stringCellValue
            val email: String = it.getCell(2).stringCellValue
            println("name: $name | email: $email")
            rowNumb += 1
            createCustomer(CustomerDTO(name, email).dtoToCustomer())
        }

    }

    fun updateById(id: Long, customerDTO: CustomerDTO){
        if(!customerRepository.existsById(id)){
            throw RuntimeException("Customer not exists!")
        }
        val customer: Customer = Customer(id, customerDTO.name, customerDTO.email)
        customerRepository.save(customer)

    }

    fun deleteById(id: Long){
        if(!customerRepository.existsById(id)){
            throw RuntimeException("Customer not found!")
        }
        customerRepository.deleteById(id)
    }


}