package com.example.newdemo.demos.web.bean;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
public class Car {
    @Id
    @Column(name = "vid")  // 指定主键映射到数据库的列名
    private String vid;

    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "battery_type")
    private String batteryType;

    @Column(name = "total_mileage")
    private Float totalMileage;

    @Column(name = "battery_health")
    private Float batteryHealth;


    // Getters and setters
    public String getId() {
        return vid;
    }

    public void setId(String vid) {
        this.vid = vid;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public Float getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(Float totalMileage) {
        this.totalMileage = totalMileage;
    }

    public Float getBatteryHealth() {
        return batteryHealth;
    }

    public void setBatteryHealth(Float batteryHealth) {
        this.batteryHealth = batteryHealth;
    }
}
