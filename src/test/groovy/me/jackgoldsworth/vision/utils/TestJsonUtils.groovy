package me.jackgoldsworth.vision.utils

import spock.lang.Specification

class TestJsonUtils extends Specification {

    def "testLoadCredentials"() {
        setup:
        String fileName = "secret.json"

        when:
        Map<String, String> map = JsonUtils.loadCredentials(fileName)

        then:
        map.get("client") == "this"
        map.get("secret") == "is a"
        map.get("redirect") == "test"
    }
}
