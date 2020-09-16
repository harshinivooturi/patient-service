package com.mt.patientservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class DataPointService {
    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

    public void uploadFile(InputStream file) {
        try
        {
            Path copyLocation = Paths
                    .get(uploadDir+ File.separator+ StringUtils.cleanPath("myFile.xml"));

            Files.copy(file,copyLocation, StandardCopyOption.REPLACE_EXISTING);

        }
        catch(Exception e)
        {
            throw new RuntimeException("Could not store file"
                    //+ file.getOriginalFilename()
                    +".Please try again");
        }
    }

    public void uploadFile(MultipartFile file) {
        try {
            Path copyLocation = Paths
                    .get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException("Could not store file " + file.getOriginalFilename()
                    + ". Please try again!");
        }
    }
}
