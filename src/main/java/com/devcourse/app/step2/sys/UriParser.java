package com.devcourse.app.step2.sys;

import java.util.Map;

public class UriParser {

    private String URI;
    private boolean isValid = true;
    private String controllerCode ;
    private String methodCode;
    private Map<String,Object> parameterMap;


    public UriParser(String URI) {
        this.URI = parse(URI);
        //parse를 객체 생성하면서 실행시키기위해
        //void 대신 String 으로 return type 지정한듯 ;
    }

    protected String parse(String uri){
        if (!uri.startsWith("/")){
            isValid = false;
            return uri;
        }

        String [] uriSplit = uri.split("//?",2);

        if (uriSplit.length == 2){
            setParameterMap(uriSplit[1]);
        }

        String [] uriFront = uri.split("/");
        if (uriFront.length == 3){
            isValid = false;
            return uri;
        }
        controllerCode = uriFront[1];
        methodCode = uriFront[2];

        return uri;
    }

    protected boolean isValid(){
        return isValid;
    }

    protected void setParameterMap (String param){
        try {
            if (param.contains("&")){//파라미터가 여러개일 경우
                String [] split = param.split("&");
                for (String s : split) {
                    String [] keyValue = s.split("=");

                    if (keyValue[1].equals("")){
                        throw new IllegalArgumentException("잘못된 파라미터 값이 입력 되었습니다.");
                    }
                    parameterMap.put(keyValue[0],keyValue[1]);
                }
            }else{// 파라미터가 하나일 경우
                String [] keyValue = param.split("=");

                if (keyValue[1].equals("")){
                    throw new IllegalArgumentException("잘못된 파라미터 값이 입력 되었습니다.");
                }
                parameterMap.put(keyValue[0],keyValue[1]);
            }
        } catch (ArrayIndexOutOfBoundsException|IllegalArgumentException e) {
           this.isValid = false;
        }
    }

    protected Map<String,Object> getParameterMap(){
        return parameterMap;
    }


    protected String getURI() {
        return URI;
    }

    protected String getControllerCode() {
        return controllerCode;
    }

    protected String getMethodCode() {
        return methodCode;
    }
}
