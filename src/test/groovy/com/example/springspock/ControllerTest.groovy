package com.example.springspock

import spock.lang.Specification

import java.time.LocalDateTime

class ControllerTest extends Specification {

    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }

    def "two plus two should equal four"() {
        given:
        int left = 2
        int right = 2

        when:
        int result = left + right

        then:
        result == 4
    }

    def "Should be able to remove from list"() {
        given:
        def list = [1, 2, 3, 4]

        when:
        list.remove(0)

        then:
        list == [2, 3, 4]
        list.size() == 3
    }

    def "Should get an index out of bounds when removing a non-existent item"() {
        given:
        def list = [1, 2, 3, 4]

        when:
        list.remove(20)

        then:
        thrown(IndexOutOfBoundsException)
        list.size() == 4
    }

    def "numbers to the power of two"(int a, int b, int c) {
        expect:
        Math.pow(a, b) == c

        where:
        a | b | c
        1 | 2 | 1
        2 | 2 | 4
        3 | 2 | 9
    }

//    void "made up test"() {
//        when:
//            def a = LocalDateTime.now()
//            Thread.sleep(1)
//            def b = LocalDateTime.now()
//        then:
//            a.toString() == b.toString()
//    }

    void "dummy"() {
        expect:
        verifyAll {
            1 == 1
            2 == 2
        }
    }

    void "test person"() {
        def person = Mock(Person)
        person.getFirstName() >> "Filipe"
        expect:
        person.getFirstName() == "Filipe"
    }
}
