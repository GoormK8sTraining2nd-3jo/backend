package kr.kua.backend.entity.domain;

import kr.kua.backend.entity.Images
import org.springframework.data.jpa.repository.JpaRepository

interface ImagesRepository : JpaRepository<Images, Long> {
}