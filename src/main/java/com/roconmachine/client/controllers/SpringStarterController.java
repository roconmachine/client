package com.roconmachine.client.controllers;

import com.roconmachine.client.core.BaseController;
import com.roconmachine.client.models.ApplicationRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class SpringStarterController extends BaseController<ApplicationRequest> {
    @Override
    protected Class<?> identifyYourself() {
        return null;
    }

    @Override
    protected String handlePost(ApplicationRequest domain, HttpSession session, Model model) {

        return "";
    }

    @Override
    protected ApplicationRequest handleGet(HttpSession session, Map<String, String> queryParams, Map<String, String> pathVars) {
        super.targetView = "spring-starter";
//        super.targetView = "index";
        return new ApplicationRequest();
    }

    @Override
    protected HashMap<String, Object> attach() {
        return null;
    }
}
