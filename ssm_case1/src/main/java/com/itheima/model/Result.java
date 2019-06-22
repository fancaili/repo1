package com.itheima.model;

import java.io.Serializable;

/**
 * Created by tanshuai on 2019/6/16.
 * 通用的响应结果实体
 */
public class Result implements Serializable {
    
    private boolean success;//响应标识
    
    private String message;//响应消息
    
    private Object data;//后端响应给前端数据

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result() {
    }

    public Result(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.data = null;
    }
}
