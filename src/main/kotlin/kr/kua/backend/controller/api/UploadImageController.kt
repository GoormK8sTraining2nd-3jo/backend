package kr.kua.backend.controller.api

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
//@RequestMapping(value = ["/api/image/"], produces = ["application/json; charset=UTF-8"])
@RequestMapping(value = ["/api/image/"])
class UploadImageController {

    @PostMapping("/upload")
    fun ImageUpload(@RequestBody image: String): {

    }
}
// 웅상 20일에