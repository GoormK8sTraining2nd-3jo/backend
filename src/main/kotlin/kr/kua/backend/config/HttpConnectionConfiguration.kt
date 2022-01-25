package kr.kua.backend.config

import org.apache.http.impl.client.HttpClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

@Configuration
class HttpConnectionConfiguration {

    @Bean
    fun getCustomRestTemplate(): RestTemplate {
        val httpRequestFactory = HttpComponentsClientHttpRequestFactory()
        httpRequestFactory.setConnectTimeout(3000)
        httpRequestFactory.setReadTimeout(3000)
        httpRequestFactory.httpClient = HttpClientBuilder.create()
            .setMaxConnTotal(500)
            .setMaxConnPerRoute(30)
            .build()
        return RestTemplate(httpRequestFactory)
    }
}