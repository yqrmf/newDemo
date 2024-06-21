package com.example.newdemo.demos.web.controll;

import com.example.newdemo.demos.web.service.WarnDTO;
import com.example.newdemo.demos.web.service.WarnService;
import com.example.newdemo.demos.web.service.WarnResultDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class WarnController {
    private static final Logger logger = LoggerFactory.getLogger(WarnController.class);

    @Autowired
    private WarnService warnService;

    @PostMapping("/warn")
    public ResponseEntity<WarnResultDTO> processWarn(@RequestBody List<WarnDTO> warnDTOs) {
        WarnResultDTO resultDTO = warnService.processWarn(warnDTOs);
        logger.info("Processed warn result: {}", resultDTO);
        return ResponseEntity.status(resultDTO.getStatus()).body(resultDTO);
    }
    /*public Map<String, Object> processWarn(@RequestBody List<WarnDTO> warnDTOs) {
        WarnResultDTO resultDTO = warnService.processWarn(warnDTOs);
        logger.info("Processed warn result: {}", resultDTO);

        // Construct response JSON object
        Map<String, Object> response = new HashMap<>();
        response.put("status", resultDTO.getStatus());
        response.put("msg", resultDTO.getMsg());
        response.put("data", resultDTO.getData());

        return response;
    }*/
}