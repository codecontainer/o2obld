package com.o2obld.o2obld.web.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 白色馒头
 * Date: 2018-09-08
 * Time: 16:15
 */
@Controller
@RequestMapping("/category")
public class ManagementController {
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String  addCategory(){
        return "category/add";
    }
}
