package com.roconmachine.client.controllers;

import com.roconmachine.client.core.BaseController;
import com.roconmachine.client.models.ApplicationRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Controller
@RequestMapping(path = {"/", "/service"})
public class SpringStarterController extends BaseController<ApplicationRequest> {
    @Override
    protected Class<?> identifyYourself() {
        return null;
    }

    @Override
    protected String handlePost(ApplicationRequest domain, HttpSession session, Model model) {

        List<MultipartFile> files = getMultipart("files");

            if (files != null && !files.isEmpty()) {
                files.forEach(multipartFile -> {
                    byte[] content = new byte[0];
                    try {
                        content = multipartFile.getBytes();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    String text = new String(content, StandardCharsets.UTF_8);

                    System.out.println("File name: " + multipartFile.getOriginalFilename());
                    System.out.println("Text content: " + text);
                });

            }


        return "";
    }

    @Override
    protected ApplicationRequest handleGet(HttpSession session, Map<String, String> queryParams, Map<String, String> pathVars) {
        super.targetView = "spring-starter";
        ApplicationRequest model = new ApplicationRequest();
        model.setVersion("3.3");
        model.setPackaging("Jar");
        return model;
    }

    @Override
    protected HashMap<String, Object> attach() {
        List<String> versions = Arrays.asList("3.3", "3.9", "3.7");
        HashMap<String, Object> params = new HashMap<>(0);
        params.put("versions", versions);

        return params;
    }
}
