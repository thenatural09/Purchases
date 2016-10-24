package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Troy on 10/24/16.
 */
@Controller
public class PurchasesController {
    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String home(Model model) {
        return null;
    }
}
