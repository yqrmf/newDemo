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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WarnController {
    @Autowired
    private WarnService warnService;

    @PostMapping("/warn")
    public ResponseEntity<WarnResultDTO> processWarn(@RequestBody List<WarnDTO> warnDTOs) {
        WarnResultDTO resultDTO = warnService.processWarn(warnDTOs);
        return ResponseEntity.status(resultDTO.getStatus()).body(resultDTO);
    }
}