package com.roconmachine.client.contributors;

import com.roconmachine.client.core.RequestContributor;
import com.roconmachine.client.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class Localization implements RequestContributor {

    @Override
    public void contributeGet(Model model, HttpSession session) {
        model.addAttribute("get_Localization", "something in get Localization");
    }

    @Override
    public void contributePost(Model model, HttpSession session) {
        model.addAttribute("post_Localization", "something in post Localization");
    }
}
