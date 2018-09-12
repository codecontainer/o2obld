package com.o2obld.o2obld.dao;

import com.o2obld.o2obld.entity.Category;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 白色馒头
 * Date: 2018-09-06
 * Time: 22:20
 */
public interface CategoryDao {
    /**
     * 查询所有的分类的
     * @return
     */
    List<Category> queryCategory();
    int insertCategory(Category category);
    int updateCategory(Category category);
    int deleteCategory(Long categoryId);
}
