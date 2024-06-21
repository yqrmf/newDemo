package com.example.newdemo.demos.web.service;


import java.util.List;

public class WarnResultDTO {
    private Integer status;
    private String msg;
    private List<WarnDetailDTO> data;

    public void setStatus(int i) {
        this.status = i;
    }

    public void setMsg(String ok) {
        this.msg = ok;
    }

    public void setData(List<WarnDetailDTO> warnDetails) {
        this.data = warnDetails;
    }

    public Integer getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "{" + '\n' +
                "status：" + status + "," + '\n' +
                "msg：\"" + msg + '\"' + "," + '\n' +
                "data：" + data + '\n' +
                '}';
    }

    public Object getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }
}
