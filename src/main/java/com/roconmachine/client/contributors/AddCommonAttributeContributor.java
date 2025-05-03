package com.roconmachine.client.contributors;

import com.roconmachine.client.controllers.LoginController;
import com.roconmachine.client.controllers.RegistrationController;
import com.roconmachine.client.core.BaseController;
import com.roconmachine.client.core.RequestContributor;
import com.roconmachine.client.core.TargetController;
import com.roconmachine.client.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
@TargetController(RegistrationController.class)
public class AddCommonAttributeContributor  implements RequestContributor {
    @Override
    public void contributeGet(Model model, HttpSession session) {
        model.addAttribute("get_RegistrationController", "something in get");
    }

    @Override
    public void contributePost(Model model, HttpSession session) {
        model.addAttribute("post_RegistrationController", "something in post");
    }
}
