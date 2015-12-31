package com.demo

import groovyx.net.http.RESTClient
import spock.lang.Specification
import spock.lang.Unroll

class ControllerFunctionalTest extends Specification {

    @Unroll
    def "Should return 200 & some json"() {
        setup:
        def client = new RESTClient("http://localhost:8080/")

        when:
        def resp = client.get(path: '/items')

        then:
        resp.data.size > 0
        resp.data[0].name == "a"
        resp.data[1].name == "b"
        resp.status == 200
        resp.contentType == "application/json"

    }

}