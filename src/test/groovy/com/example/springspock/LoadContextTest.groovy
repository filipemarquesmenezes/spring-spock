package com.example.springspock

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoadContextTest extends Specification {

    @Autowired(required = false)
    private SpringSpockApplication springSpockApplication;

    @Value('${local.server.port}')
    int port

    RestTemplate rest = new RestTemplate()

    def "when context is loaded then all expected beans are created"() {
        expect: "the WebController is created"
        springSpockApplication
    }

    void "should get a message when visiting"() {
        when:
        def response = rest.getForEntity("http://localhost:${port}/hello", String.class)
        then:
        response.getStatusCode() == HttpStatus.OK
        "hello world" == response.getBody()
    }
}