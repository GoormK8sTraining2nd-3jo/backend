package kr.kua.backend.service.control

import com.amazonaws.services.s3.AmazonS3Client
import kr.kua.backend.entity.domain.ImagesQueryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


@Component
class GetImages {

    @Autowired
    lateinit var amazonS3Client: AmazonS3Client

    @Autowired
    lateinit var imagesQueryRepository: ImagesQueryRepository

    @Value("\${cloud.aws.s3.bucket}")
    lateinit var bucket: String

    fun get(): Map<String, String> {
        val map = mutableMapOf<String, String>()
        imagesQueryRepository.findImages().forEach {
            map[it.imageId.toString()] = "https://k8s-traning-s3.s3.ap-northeast-2.amazonaws.com/" + it.fileName
        }

        return map
    }
}