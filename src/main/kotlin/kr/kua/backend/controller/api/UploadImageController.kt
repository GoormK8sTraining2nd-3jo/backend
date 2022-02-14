package kr.kua.backend.controller.api

import com.google.gson.Gson
import kr.kua.backend.dto.control.S3UploadImageRequest
import kr.kua.backend.model.response.BaseResult
import kr.kua.backend.service.control.S3UploadImage
import kr.kua.backend.service.response.ResponseService
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequiredArgsConstructor
@RequestMapping(value = ["/api/image/"])
class UploadImageController {

    @Autowired
    lateinit var responseService: ResponseService

    @Autowired
    lateinit var s3UploadImage: S3UploadImage

    @PostMapping("/upload")
    fun imageUpload(@RequestBody @Valid s3UploadImageRequest: S3UploadImageRequest): BaseResult {
        s3UploadImage.upload(s3UploadImageRequest.base64, s3UploadImageRequest.extension)
        return responseService.successResult
    }
}