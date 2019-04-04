package com.example.demo

import com.example.demo.util.BinarySearch
import com.example.demo.util.JWTDemo
import spock.lang.Specification
import spock.lang.Unroll;

class SpockBookRepositorySpecification extends Specification {

    def jwt = new JWTDemo();


    def "获取一个token"(){
        expect:
        jwt.createToken().length() > 20
    }


    def "验证token的解析是否正确"(){

    }

    @Unroll //测试用例都写在where子句里有时，里面的某个测试用例失败了，却难以查到是哪个失败了。这时候，可以使用Unroll注解，该注解会将where子句的每个测试用例转化为一个 @Test 独立测试方法来执行，这样就很容易找到错误的用例。
    def "testSearch(#key in #arr index=#result)"() {
        expect:
        BinarySearch.search(arr as int[], key) == result

        where:
        arr       | key | result
        []        | 1   | -1
        [1, 2, 9] | 9   | 2
        [1, 2, 9] | 3   | 0
    }

}