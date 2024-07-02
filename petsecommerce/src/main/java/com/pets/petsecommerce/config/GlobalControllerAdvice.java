package com.pets.petsecommerce.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void getAuthStatus(Model model, Authentication authentication) {

        boolean auth = false;
        if (authentication != null && authentication.isAuthenticated()) {
            auth = true;
        }
        model.addAttribute("isAuth", auth);
        model.addAttribute("profileUsername", SecurityContextHolder.getContext().getAuthentication().getName());
    }

}
