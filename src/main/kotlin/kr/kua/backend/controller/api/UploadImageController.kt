package kr.kua.backend.controller.api

import kr.kua.backend.model.response.BaseResult
import kr.kua.backend.service.response.ResponseService
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
//@RequestMapping(value = ["/api/image/"], produces = ["application/json; charset=UTF-8"])
@RequestMapping(value = ["/api/image/"])
class UploadImageController {

    @Autowired
    lateinit var responseService: ResponseService

    @PostMapping("/upload")
    fun ImageUpload(@RequestBody image: String): BaseResult {

        return responseService.successResult
    }
}
// 웅상 20일에