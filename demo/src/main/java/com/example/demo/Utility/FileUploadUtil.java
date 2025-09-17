package com.example.demo.Utility;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class FileUploadUtil {
    private static final String UPLOAD_DIR = System.getProperty("user.dir") + "/uplaods";

    public static String saveFile(MultipartFile file) throws IllegalArgumentException, IOException {
        if(file == null || file.isEmpty()){
            throw new IllegalArgumentException("file cannot be uplaoded");
        }

        File dir = new File(UPLOAD_DIR);
        if(!dir.exists()) dir.mkdirs();

        String uniquename = UUID.randomUUID() + "_" + file.getOriginalFilename();

        String filepath = UPLOAD_DIR + uniquename;
        file.transferTo(new File(filepath));

        return uniquename;
    }

}
