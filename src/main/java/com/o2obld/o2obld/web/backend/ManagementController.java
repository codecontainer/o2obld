package com.o2obld.o2obld.web.backend;

import com.o2obld.o2obld.entity.Category;
import com.o2obld.o2obld.entity.CategoryLevel;
import com.o2obld.o2obld.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String  addCategory(){
        return "category/add";
    }
    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    @ResponseBody
    public List<CategoryLevel> getCategory(){
        List<CategoryLevel> cl=new ArrayList<CategoryLevel>();
        List<Category> categorylist=new ArrayList<Category>();
        categorylist=categoryService.getCategoryList();
        categoryService.recCategory(cl,categorylist,0,0);
        categoryService.setChar(cl);
        return cl;
    }


}
