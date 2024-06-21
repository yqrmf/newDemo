package com.example.newdemo.demos.web.bean;

import javax.persistence.*;

@Entity
@Table(name = "rules")
public class Warn {

    @Id
    @Column(name = "id")  // 指定主键映射到数据库的列名
    private Integer id;

    @Column(name = "rule_number")
    private Integer ruleNumber;

    @Column(name = "rule_name")
    private String ruleName;


    @Column(name = "battery_type")
    private String batteryType;

    @Column(name = "signal_mi")
    private Float signalMi;

    @Column(name = "signal_ma")
    private Float signalMa;

    @Column(name = "alarm_level")
    private Integer alarmLevel;

    // Getters and setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRuleNumber() {
        return ruleNumber;
    }
    public void setRuleNumber(Integer ruleNumber) {
        this.ruleNumber =ruleNumber;
    }

    public String getRuleName() {
        return ruleName;
    }
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public Float getSignalMi() {
        return signalMi;
    }
    public void setSignalMi(Float signalMi) {
        this.signalMi = signalMi;
    }

    public Float getSignalMa() {
        return signalMa;
    }
    public void setSignalMa(Float signalMa) {
        this.signalMa = signalMa;
    }

    public Integer getAlarmLevel() {
        return alarmLevel;
    }
    public void setAlarmLevel(Integer alarmLevel) {
        this.alarmLevel = alarmLevel;
    }
}
