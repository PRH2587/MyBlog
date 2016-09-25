package com.bomb.model;

import java.util.HashMap;
import java.util.List;

public class ResultEntityHashMapImpl extends HashMap<String, Object> implements ResultEntity {

    private static final long serialVersionUID = -2609985704621734746L;

    protected static final String KW_KEY_STATUS = "status";
    protected static final String KW_KEY_MSG = "message";
    protected static final String KW_KEY_RESULT = "result";
    protected static final String KW_KEY_LIST = "list";
    protected static final String KW_KEY_TOKEN = "token";

    public ResultEntityHashMapImpl() {
        super();
    }

    public ResultEntityHashMapImpl(String status, String msg) {
        this.put(KW_KEY_STATUS, status);
        this.put(KW_KEY_MSG, msg);
    }

    public ResultEntityHashMapImpl(String status, String msg, Object entity) {
        this.put(KW_KEY_STATUS, status);
        this.put(KW_KEY_MSG, msg);
        if (entity != null) this.put((entity instanceof List) ? KW_KEY_LIST : KW_KEY_RESULT, entity);
    }

    public ResultEntityHashMapImpl(String status, String msg, Object entity, String token) {
        this.put(KW_KEY_STATUS, status);
        this.put(KW_KEY_MSG, msg);
        if (entity != null) this.put((entity instanceof List) ? KW_KEY_LIST : KW_KEY_RESULT, entity);
        this.put(KW_KEY_TOKEN, token);
    }

    @Override
    public void setStatus(String status) {
        this.put(KW_KEY_STATUS, status);
    }

    @Override
    public void setMsg(String msg) {
        this.put(KW_KEY_MSG, msg);
    }

    @Override
    public void setResult(Object result) {
        this.put(KW_KEY_RESULT, result);
    }

    @Override
    public void addObject(String key, Object value) {
        this.put(key, value);
    }

    @Override
    public void removeObject(String key) {
        this.remove(key);
    }

    @Override
    public Object getStatus() {
        return this.get(KW_KEY_STATUS);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"" + KW_KEY_STATUS + "\":\"" + getStatus() + "\",");
        sb.append("\"" + KW_KEY_MSG + "\":\"" + this.get(KW_KEY_MSG) + "\"");
        sb.append("}");
        // ---------------------------------------------------------------------------------------------------------------------------------------------------
        return sb.toString();
    }

}
