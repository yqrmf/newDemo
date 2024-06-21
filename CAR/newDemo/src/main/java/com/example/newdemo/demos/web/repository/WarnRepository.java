package com.example.newdemo.demos.web.repository;

import com.example.newdemo.demos.web.bean.Warn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WarnRepository extends JpaRepository<Warn, Long> {
    List<Warn> findByBatteryTypeAndSignalMiLessThanEqualAndSignalMaGreaterThanAndRuleNumber(
            String batteryType, float signalMi, float signalMa, Integer ruleNumber);
    List<Warn> findByBatteryTypeAndSignalMiLessThanEqualAndSignalMaGreaterThan(
            String batteryType, float signalMi, float signalMa);
}