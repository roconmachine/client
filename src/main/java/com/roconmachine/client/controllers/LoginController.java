package com.roconmachine.client.controllers;

import com.roconmachine.client.core.BaseController;

import com.roconmachine.client.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(path = "/user/{id}")
public class LoginController extends BaseController<User>{


    @Override
    protected Class<LoginController> identifyYourself() {
        return LoginController.class;
    }

    @Override
    protected String handlePost(User user, HttpSession session, Model model) {
        return "";
    }

    @Override
    protected User handleGet(HttpSession session, Map<String, String> queryParams, Map<String, String> pathVars) {
        super.targetView = "index";
        User user = new User();
        user.setRole("2");
        return user;
    }

    @Override
    protected HashMap<String, Object> attach() {
        return null;
    }

}
