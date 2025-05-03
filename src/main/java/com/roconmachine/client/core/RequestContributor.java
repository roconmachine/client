package com.roconmachine.client.core;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;

public interface RequestContributor {
    void contributeGet(Model model, HttpSession session);
    void contributePost(Model model, HttpSession session);
}
