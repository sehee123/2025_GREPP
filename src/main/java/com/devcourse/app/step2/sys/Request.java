package com.devcourse.app.step2.sys;

import java.util.Map;

public class Request {

    private UriParser uriParser;
    private Map<String , Object> paramterMap;

    public Request(String url) {
        this.uriParser = new UriParser(url);
        this.paramterMap = this.uriParser.getParameterMap();
    }

    public boolean isValid() {
        return this.uriParser.isValid();
    }

    public <T> T getValue(String key , Class<T> cls){
        Object value = this.paramterMap.get(key);

        if(cls == Integer.class){
            return cls.cast(Integer.parseInt(value.toString()));
        }else if (cls == Long.class){
            return cls.cast(Long.parseLong(value.toString()));
        }else if (cls == Boolean.class){
            return cls.cast(Boolean.parseBoolean(value.toString()));
        }

        return cls.cast(value);
    }

    public String getMethodCode(){
        return this.uriParser.getMethodCode();
    }

    public String getControllerCode(){
        return this.uriParser.getControllerCode();
    }
}
