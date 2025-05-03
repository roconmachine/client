package com.roconmachine.client.controllers;


import com.roconmachine.client.core.BaseController;
import com.roconmachine.client.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/register")
public class RegistrationController extends BaseController<User>{
    @Override
    protected Class<?> identifyYourself() {
        return RegistrationController.class;
    }


    @Override
    public String handlePost(User domain, HttpSession session, Model model) {
        return "";
    }

    @Override
    protected User handleGet(HttpSession session, Map<String, String> queryParams, Map<String, String> pathVars) {
        super.targetView = "register";
        return null;
    }

    @Override
    public HashMap<String, Object> attach() {
        return null;
    }


}
