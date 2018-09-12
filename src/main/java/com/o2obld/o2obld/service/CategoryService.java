package com.o2obld.o2obld.service;

import com.o2obld.o2obld.dto.CategoryResult;
import com.o2obld.o2obld.entity.Category;
import com.o2obld.o2obld.entity.CategoryLevel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 白色馒头
 * Date: 2018-09-06
 * Time: 23:32
 */
public interface CategoryService {
    List<Category> getCategoryList();
    CategoryResult insertCategroy(Category categroy);
    void recCategory(List<CategoryLevel> categoryLevelList,List<Category> categoryList,Integer id, Integer level);
    void setChar(List<CategoryLevel> cl);
}
