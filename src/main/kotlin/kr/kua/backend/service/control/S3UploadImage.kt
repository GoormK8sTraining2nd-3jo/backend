package kr.kua.backend.service.control

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.PutObjectRequest
import kr.kua.backend.entity.Images
import kr.kua.backend.entity.domain.ImagesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.File
import java.io.FileOutputStream
import java.util.*
import javax.swing.filechooser.FileSystemView


@Component
class S3UploadImage {

    @Autowired
    lateinit var amazonS3Client: AmazonS3Client

    @Autowired
    lateinit var imagesRepository: ImagesRepository

    @Value("\${cloud.aws.s3.bucket}")
    lateinit var bucket: String

    fun upload(base64: String, extension: String) {
        val fileName = "test/${UUID.randomUUID()}.${extension}"

        val file = File("${FileSystemView.getFileSystemView().homeDirectory}/${fileName}")
        val decoder = Base64.getDecoder()
        val decodedBytes: ByteArray = decoder.decode(base64.encodeToByteArray())
        val fileOutputStream = FileOutputStream(file)
        fileOutputStream.write(decodedBytes)
        fileOutputStream.close()

        amazonS3Client.putObject(
            PutObjectRequest(
                bucket,
                fileName,
                file
            ).withCannedAcl(CannedAccessControlList.PublicRead)
        )

        val image = Images(fileName, file.path)
        imagesRepository.save(image)
    }
}