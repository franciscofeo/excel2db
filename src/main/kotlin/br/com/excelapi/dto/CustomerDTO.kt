package br.com.excelapi.dto

import br.com.excelapi.model.Customer

data class CustomerDTO (
    var name: String,
    var email: String,
    var salary: Double
) {

    fun dtoToCustomer() : Customer{
        return Customer(name = this.name, email = this.email, salary = this.salary)
    }
}
