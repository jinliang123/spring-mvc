package com.glf.controller;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * description
 *
 * @author jinliang 2019/05/08 15:19
 */
@RestController
@RequestMapping("/file")
public class FileController {
    Logger logger = LoggerFactory.getLogger(FileController.class);
    private String folder = "D:\\Users\\jinliang\\workspace-srm\\spring-mvc\\src\\main\\java\\com\\glf\\controller";

    @PostMapping
    public String upload(MultipartFile file) throws IOException {
        logger.info("name:"+file.getName());

        File localFile = new File(folder,new Date().getTime()+".txt");
        file.transferTo(localFile);
        return localFile.getAbsolutePath();
    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response){
       try (InputStream inputStream = new FileInputStream(new File(folder,id+".txt"));
            OutputStream outputStream = response.getOutputStream()){
           response.setContentType("application/x-download");
           response.addHeader("Content-Disposition","attachment;filename=test.txt");
           IOUtils.copy(inputStream,outputStream);
           outputStream.flush();
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

}
