package org.saneium.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mbollemeijer on 02/06/15.
 */

@Controller
public class DashboardController {

    @RequestMapping("/")
    public String dashBoardHome() {
        return "dashboard";
    }
}
