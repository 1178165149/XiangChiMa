package com.zpark.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("file")
public class FileController {

    //localhost:8080/legou/file/download/servlet
    @GetMapping("download/servlet")
    public void downloadByServlet(HttpServletResponse response) throws Exception {

        //要下载的文件地址
        File file = new File("C:\\Users\\david\\Pictures\\Saved Pictures\\-1d5447a99f415f65.jpg");

        String name = file.getName();
        String encode = URLEncoder.encode(name, "UTF-8");

        // 设置响应头支持的类型 应用支持的类型为字节流
        response.setContentType("application/octet-stream");
        // 设置响应头以下载方式打开 以附件形式处理内容
        response.addHeader("Content-Disposition", "attachment; filename=" + encode);

        try {
            ServletOutputStream out = response.getOutputStream();
            byte[] bytes = Files.readAllBytes(file.toPath());
            out.write(bytes);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //localhost:8080/legou/file/download/springmvc
    @GetMapping("download/springmvc")
    public ResponseEntity<byte[]> downloadBySpringMvc() throws IOException {

        File file = new File("C:\\Users\\david\\Pictures\\Saved Pictures\\-1d5447a99f415f65.jpg");

        byte[] body = Files.readAllBytes(file.toPath());

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);

        httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + URLEncoder.encode(file.getName(), "UTF-8"));

        ResponseEntity<byte[]> entity = new ResponseEntity<>(body, httpHeaders, HttpStatus.OK);

        return entity;

    }


    //localhost:8080/legou/file/upload/servlet
    @GetMapping("upload/servlet")
    public Map<Boolean, String> uploadByServlet(HttpServletRequest request)
            throws ServletException, IOException {

        //获取文件，参数为前台的name
        Part part = request.getPart("file");

        //获取文件名，获取到的文件名格式如 a.png
        String fileName = part.getSubmittedFileName();
        System.out.println("fileName = " + fileName);

        InputStream in = part.getInputStream();
        //available()可以在读写操作前先得知数据流里有多少个字节可以读取
        byte[] bytes = new byte[in.available()];
        in.read(bytes);

        Files.write(Paths.get("d:\\" + UUID.randomUUID() + ".png"), bytes);

        return Collections.singletonMap(Boolean.TRUE, "上传成功...");

    }

}