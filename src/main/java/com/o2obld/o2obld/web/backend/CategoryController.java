package com.o2obld.o2obld.web.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.o2obld.o2obld.dto.CategoryResult;
import com.o2obld.o2obld.entity.Category;
import com.o2obld.o2obld.enums.CategoryStateEnum;
import com.o2obld.o2obld.service.CategoryService;
import com.o2obld.o2obld.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/category")
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
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addCategory(HttpServletRequest request){
        String categoryStr= HttpServletRequestUtil.getString(request,"categoryData");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        ObjectMapper mapper=new ObjectMapper();
        Category category=new Category();
        try {
           category= mapper.readValue(categoryStr,Category.class);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
            return modelMap;
        }

        if (category != null) {
            try {
                CategoryResult cr = categoryService.insertCategroy(category);
                if (cr.getState() == CategoryStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", true);
                } else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", cr.getStateinfo());
                }
            } catch (RuntimeException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }

        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "无数据");
        }
        return modelMap;


    }
}
