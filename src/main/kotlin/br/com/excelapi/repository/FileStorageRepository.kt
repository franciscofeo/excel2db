package br.com.excelapi.repository

import org.springframework.core.io.Resource
import org.springframework.stereotype.Repository
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Path
import java.util.stream.Stream

@Repository
interface FileStorageRepository {

    fun init()

    fun save(file: MultipartFile)

    fun deleteAll()



}