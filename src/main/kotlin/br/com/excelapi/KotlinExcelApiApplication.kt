package br.com.excelapi

import br.com.excelapi.service.FileStorageService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinExcelApiApplication(val fileStorageService: FileStorageService) : CommandLineRunner{
    override fun run(vararg args: String?) {
        fileStorageService.deleteAll()
        fileStorageService.init()
    }

}

fun main(args: Array<String>) {
    runApplication<KotlinExcelApiApplication>(*args)
}
