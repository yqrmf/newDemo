package com.example.newdemo.demos.web.service;


public class WarnDTO {
    private Integer carId;
    private Integer warnId;
    private String signal;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public void setWarnId(int warnId) {
        this.warnId = warnId;
    }

    public int getWarnId() {
        return warnId;
    }

    public String getSignal() {
        return signal;
    }

    public void setSignal(String signal) {
        this.signal = signal;
    }
}
