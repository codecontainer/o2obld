package com.o2obld.o2obld.dao;

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
 * Time: 22:48
 */
public class CategoryDaoTest extends BaseTest {
    @Autowired
    private CategoryDao categoryDao;
    @Test
    public void  queryCategoryTest(){
        List<Category>  categoryList=categoryDao.queryCategory();
        assertEquals(1,categoryList.size());
    }
    @Test
    public void insertCategoryTest(){
        Category category=new Category();
        category.setCategoryName("测试二");
        category.setDescription("测试信息");
        category.setParentId(0);
        category.setSort(1);
        int result=categoryDao.insertCategory(category);
        assertEquals(1,result);

    }

}
