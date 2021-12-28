package br.com.excelapi.service

import br.com.excelapi.repository.FileStorageRepository
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import org.springframework.util.FileSystemUtils
import org.springframework.web.multipart.MultipartFile
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.util.stream.Stream

@Service
class FileStorageService : FileStorageRepository {

    val root: Path = Paths.get("uploads")

    override fun init() {
        try{
            Files.createDirectory(root)
        } catch (e: IOException){
            throw IOException("Could not initialize folder for upload.")
        }
    }

    override fun save(file: MultipartFile) {
        try {
            Files.copy(file.inputStream, root.resolve(file.originalFilename!!))
        } catch (e: Exception){
            throw Exception("Could not store the file. Error: ${e.message}")
        }
    }

    override fun deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile())
    }



}