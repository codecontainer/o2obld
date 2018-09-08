package com.o2obld.o2obld.service;

import com.o2obld.o2obld.BaseTest;
import com.o2obld.o2obld.entity.Category;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

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
        assertEquals("测试1",categoryList.get(0).getCategoryName());
    }



}
