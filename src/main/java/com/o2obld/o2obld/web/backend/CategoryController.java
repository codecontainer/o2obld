package com.o2obld.o2obld.web.backend;

import com.o2obld.o2obld.entity.Category;
import com.o2obld.o2obld.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 白色馒头
 * Date: 2018-09-07
 * Time: 0:00
 */
@Controller
@RequestMapping("/bldbackend")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "/listcategory",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> listCategory(){
        Map<String,Object> model =new HashMap<String,Object>();
        List<Category> categoryList=new ArrayList<Category>();
        try {
            categoryList=categoryService.getCategoryList();
            model.put("rows",categoryList);
            model.put("total",categoryList.size());
        }catch (Exception e){
            e.printStackTrace();
            model.put("SUCCESS",false);
            model.put("ErrMsg",e.getMessage());
        }
        return  model;


    }
}
