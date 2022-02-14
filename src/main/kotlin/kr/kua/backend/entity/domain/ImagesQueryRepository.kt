package kr.kua.backend.entity.domain

import com.querydsl.jpa.impl.JPAQueryFactory
import kr.kua.backend.entity.Images
import kr.kua.backend.entity.QImages.images
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@RequiredArgsConstructor
@Repository
class ImagesQueryRepository {

    @Autowired
    lateinit var queryFactory: JPAQueryFactory

    fun findImages(): List<Images> {
        return queryFactory
            .selectFrom(images)
            .fetch()
    }
}