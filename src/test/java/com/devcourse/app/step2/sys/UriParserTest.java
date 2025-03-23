package com.devcourse.app.step2.sys;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UriParserTest {

    @Test
    @DisplayName("그냥 테스트")
    void test1() throws Exception{

        String uri = "/controller/target?id=1";

        UriParser uriParser = new UriParser(uri);
        uriParser.parse(uri);

        Map<String,Object> params  = uriParser.getParameterMap();

        String findId = (String)params.get("id");
        String controllerCode = uriParser.getControllerCode();
        String methodCode = uriParser.getMethodCode();

        System.out.println("findId = " + findId);
        System.out.println("controllerCode = " + controllerCode);
        System.out.println("methodCode = " + methodCode);
    }

    @Test
    @DisplayName("요청 테스트")
    void request_test() throws Exception{
        String command = "/controller/target?id=1";
        int expectedId = 1;

        Request request = new Request(command);

        boolean isValid = request.isValid();
        System.out.println("isValid = " + isValid);

        Integer paramValue = request.getValue("id",Integer.class);
        System.out.println("paramValue = " + (paramValue == expectedId));
    }

}