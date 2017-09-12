package org.springInAction.spittr.web;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ALEX on 13.03.2016.
 */
@Controller
public class HomeController {
    Logger logger= LoggerFactory.getLogger(HomeController.class);
    @RequestMapping(value="/", method=GET)
    public String home() {
        boolean b=true;

        return "home";
    }

    @RequestMapping(value = "/msg")
    public String msg(@RequestParam("id") Long id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("m", "mmmmmmmmmm");
        logger.debug("pass in view id={} m={}", id, "mmmmmmmmmm");
        return "home";
    }

}
