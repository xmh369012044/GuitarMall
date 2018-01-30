package cn.tarena.gm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/8/11.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "forward:/index.jsp";
    }
}
