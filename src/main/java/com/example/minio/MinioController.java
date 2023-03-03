package com.example.minio;

/**
 * @Author: liuwenpeng
 * @Date : 2023/3/3
 */
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

@RestController
@Slf4j
public class MinioController {
    @Autowired
    private MinioUtils minioUtils;
    @Value("${minio.endpoint}")
    private String address;
    @Value("${minio.bucketName}")
    private String bucketName;

    @PostMapping("/upload")
    public Object upload(MultipartFile file) {

        List<String> upload = minioUtils.upload(new MultipartFile[]{file});

        return address + "/" + bucketName + "/" + upload.get(0);
    }

    @GetMapping("/download/{file_name}")
    public void download(@PathVariable("file_name") String fileName)  {
        minioUtils.download(fileName);
    }

    @GetMapping("/download")
    public void download(@RequestParam("file_name") String fileName, HttpServletResponse response) {
        try {
            InputStream fileInputStream = minioUtils.getObject(bucketName, fileName);
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/force-download");
            response.setCharacterEncoding("UTF-8");
            IOUtils.copy(fileInputStream, response.getOutputStream());
        } catch (Exception e) {
            log.error("下载失败");
        }
    }


}

