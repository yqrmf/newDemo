package com.example.newdemo.demos.web.service;

import com.example.newdemo.demos.web.bean.Car;
import com.example.newdemo.demos.web.bean.Warn;
import com.example.newdemo.demos.web.repository.CarRepository;
import com.example.newdemo.demos.web.repository.WarnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class WarnService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private WarnRepository warnRepository;

    public WarnResultDTO processWarn(List<WarnDTO> warnDTOs) {
        WarnResultDTO resultDTO = new WarnResultDTO();
        List<WarnDetailDTO> warnDetails = new ArrayList<>();

        for (WarnDTO warnDTO : warnDTOs) {
            Integer carId = warnDTO.getCarId();
            Car car = carRepository.findByCarId(carId);

            if (car == null) {
                // 车辆不存在，返回错误信息
                resultDTO.setStatus(400);
                resultDTO.setMsg("车辆编号为 " + carId + " 的车辆不存在");
                return resultDTO;
            }

            String batteryType = car.getBatteryType();
            String signal = warnDTO.getSignal();    // 获取从 warnDTO 中获取的 signal 字段

            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(signal);     // 解析 JSON 字符串
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            float mx = (float) jsonObject.optDouble("Mx", Double.NaN);
            float mi = (float) jsonObject.optDouble("Mi", Double.NaN);
            float ix = (float) jsonObject.optDouble("Ix", Double.NaN);
            float ii = (float) jsonObject.optDouble("Ii", Double.NaN);

            float differ = 0f;
            //分别计算电流差和电压差
            if(!Double.isNaN(mx) && !Double.isNaN(mi)) {
                warnDTO.setWarnId(1);
                // 解析信号并从中获取 Mx, Mi 的值
                differ = mx - mi;
            } else if (!Double.isNaN(ix) && !Double.isNaN(ii)) {
                warnDTO.setWarnId(1);
                differ = ix - ii;
            }
            
            // 查询符合条件的预警规则
            List<Warn> warns = warnRepository.findByBatteryTypeAndSignalMiLessThanEqualAndSignalMaGreaterThanEqual(
                    batteryType, differ, differ);

            for (Warn warn : warns) {
                WarnDetailDTO detailDTO = new WarnDetailDTO();
                detailDTO.setCarId(carId);
                detailDTO.setBatteryType(batteryType);
                detailDTO.setWarnName(warn.getRuleName());
                detailDTO.setWarnLevel(warn.getAlarmLevel());
                warnDetails.add(detailDTO);
            }
        }

        resultDTO.setStatus(200);
        resultDTO.setMsg("ok");
        resultDTO.setData(warnDetails);
        return resultDTO;
    }
}