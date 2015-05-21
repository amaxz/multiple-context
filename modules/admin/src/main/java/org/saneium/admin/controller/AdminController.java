package org.saneium.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mbollemeijer on 21/05/15.
 */
@Controller("/home")
public class AdminController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
