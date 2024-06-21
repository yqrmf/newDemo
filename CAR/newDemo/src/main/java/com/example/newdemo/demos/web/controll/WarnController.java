package com.example.newdemo.demos.web.controll;

import com.example.newdemo.demos.web.service.WarnDTO;
import com.example.newdemo.demos.web.service.WarnDetailDTO;
import com.example.newdemo.demos.web.service.WarnService;
import com.example.newdemo.demos.web.service.WarnResultDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class WarnController {
    private static final Logger logger = LoggerFactory.getLogger(WarnController.class);

    @Autowired
    private WarnService warnService;

    @PostMapping("/warn")
    /*public ResponseEntity<WarnResultDTO> processWarn(@RequestBody List<WarnDTO> warnDTOs) {
        WarnResultDTO resultDTO = warnService.processWarn(warnDTOs);
        logger.info("Processed warn result: {}", resultDTO);
        return ResponseEntity.status(resultDTO.getStatus()).body(resultDTO);
    }*/
    public ResponseEntity<Map<String, Object>> processWarn(@RequestBody List<WarnDTO> warnDTOs) {
        WarnResultDTO resultDTO = warnService.processWarn(warnDTOs);
        logger.info("Processed warn result: {}", resultDTO);

        // Process data to replace warnName with "不报警" if warnLevel == 6
        List<WarnDetailDTO> processedData = new ArrayList<>();
        List<WarnDetailDTO> data = (List<WarnDetailDTO>) resultDTO.getData();
        for (WarnDetailDTO detail : data) {
            WarnDetailDTO processedDetail = new WarnDetailDTO();
            processedDetail.setCarId(detail.getCarId());
            processedDetail.setBatteryType(detail.getBatteryType());

            if (detail.getWarnLevel() != null && detail.getWarnLevel() == 6) {
                processedDetail.setWarnName("不报警");
            } else {
                processedDetail.setWarnName(detail.getWarnName());
                processedDetail.setWarnLevel(detail.getWarnLevel());
            }
            processedData.add(processedDetail);
        }
        resultDTO.setData(processedData);

        // Construct response JSON object
        Map<String, Object> response = new LinkedHashMap<>(); // Using LinkedHashMap to maintain insertion order

        response.put("status", resultDTO.getStatus());
        response.put("msg", resultDTO.getMsg());
        response.put("data", resultDTO.getData());

        return ResponseEntity.status(resultDTO.getStatus()).body(response);
    }
}