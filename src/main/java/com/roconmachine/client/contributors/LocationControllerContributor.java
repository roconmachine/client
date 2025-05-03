package com.roconmachine.client.contributors;


import com.roconmachine.client.controllers.LoginController;
import com.roconmachine.client.core.RequestContributor;
import com.roconmachine.client.core.TargetController;
import com.roconmachine.client.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
@TargetController(LoginController.class)
public class LocationControllerContributor implements RequestContributor {

    @Override
    public void contributeGet(Model model, HttpSession session) {
        model.addAttribute("get_LocationControllerContributor", "something in get LoginController");
    }

    @Override
    public void contributePost(Model model, HttpSession session) {
        model.addAttribute("post_LocationControllerContributor", "something in post LoginController");
    }
}
