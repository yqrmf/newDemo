package com.example.newdemo.demos.web.service;

public class WarnDetailDTO {
    private Integer carId;
    private String batteryType;
    private String warnName;
    private Integer warnLevel;

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getBatteryType() {
        return batteryType;
    }


    public void setWarnName(String warnName) {
        this.warnName = warnName;
    }

    public String getWarnName() {
        return warnName;
    }

    public void setWarnLevel(Integer warnLevel) {
        this.warnLevel = warnLevel;
    }

    public Integer getWarnLevel() {
        return warnLevel;
    }
}
