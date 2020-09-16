package com.mt.patientservice.controller;

import com.mt.patientservice.service.DataPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class DataPointController {

    @Autowired
    DataPointService dataPointService;


    @PostMapping("/multipartDataPoint")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws Exception {
        dataPointService.uploadFile(file);
        redirectAttributes.addFlashAttribute("message","You Have successfully uploaded"+ file.getOriginalFilename());
        return  "redirect:/";
    }

    @PostMapping("/datapoint")
    public String uploadFileBinary(HttpServletRequest request) throws IOException {
        InputStream inputStream = request.getInputStream();
        dataPointService.uploadFile(inputStream);
        return  "redirect:/";
    }

}
