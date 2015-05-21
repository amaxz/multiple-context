package org.saneium.core.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mbollemeijer on 17/05/15.
 */

@Controller("/core")
public class CoreController {

    @RequestMapping("/")
    public String coreHome() {
        return "coreHome";
    }
}
