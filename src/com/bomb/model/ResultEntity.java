package com.bomb.model;

public interface ResultEntity {

    public static final String KW_STATUS_SUCCESS = "S";
    public static final String KW_STATUS_FAIL = "F";

    public abstract void setStatus(String status);
    
    public abstract Object getStatus();

    public abstract void setMsg(String msg);

    public abstract void setResult(Object result);

    public abstract void addObject(String key, Object value);

    public abstract void removeObject(String key);
}