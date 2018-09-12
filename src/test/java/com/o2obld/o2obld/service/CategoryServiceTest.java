package com.o2obld.o2obld.service;

import com.o2obld.o2obld.BaseTest;
import com.o2obld.o2obld.entity.Category;
import com.o2obld.o2obld.entity.CategoryLevel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 白色馒头
 * Date: 2018-09-06
 * Time: 23:46
 */
public class CategoryServiceTest extends BaseTest {
 @Autowired
    private CategoryService categoryService;
    @Test
    public void getCategoryList(){
        List<Category> categoryList=categoryService.getCategoryList();
        System.out.print(categoryList.get(0).getId());

    }
    @Test
    public void recList(){
        List<CategoryLevel> cl=new ArrayList<CategoryLevel>();
        List<Category> categorylist=new ArrayList<Category>();
        categorylist=categoryService.getCategoryList();;
        categoryService.recCategory(cl,categorylist,0,0);
        System.out.println(cl);
        categoryService.setChar(cl);
        System.out.println(cl);

    }



}
