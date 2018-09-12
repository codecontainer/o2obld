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
    @Test
    public void deleteCategoryTest(){
        int num=categoryDao.deleteCategory(4L);
        assertEquals(1,num);

    }
    @Test
    public void updateCategoryTest(){
        Category category=new Category();
        category.setId(1);
        category.setCategoryName("测试修改");
        category.setSort(10);
        category.setParentId(1);
        category.setDescription("测试修改信息");
        int num=categoryDao.updateCategory(category);
        assertEquals(1,num);
    }



}
