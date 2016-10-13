package org.saneium.core.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class description
 * @author mbollemeijer
 * Created on 2016-10-13.
 */

@Controller
public class CoreController {

    @RequestMapping("/")
    public String coreHome() {
        return "core/home";
    }
}
