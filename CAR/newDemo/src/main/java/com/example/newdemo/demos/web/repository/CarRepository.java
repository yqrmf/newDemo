package com.example.newdemo.demos.web.repository;


import com.example.newdemo.demos.web.bean.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByCarId(Integer carId);
}
