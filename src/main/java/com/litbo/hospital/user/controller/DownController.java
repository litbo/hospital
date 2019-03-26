package com.litbo.hospital.user.controller;


import com.litbo.hospital.common.utils.poi.DownloadFile;
import com.litbo.hospital.result.Result;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Controller
@RequestMapping("/download")
public class DownController {

    @RequestMapping("/file")
    public ResponseEntity<InputStreamResource> eqExcel(String url) throws IOException {
        String path = System.getProperty("user.dir");
        String filePath =path+url;
        FileSystemResource file = new FileSystemResource(filePath);
        HttpHeaders headers = DownloadFile.downloadFile(file);
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new InputStreamResource(file.getInputStream()));
    }

}
