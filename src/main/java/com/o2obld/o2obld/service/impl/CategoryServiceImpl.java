package com.o2obld.o2obld.service.impl;

import com.o2obld.o2obld.dao.CategoryDao;
import com.o2obld.o2obld.entity.Category;
import com.o2obld.o2obld.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 白色馒头
 * Date: 2018-09-06
 * Time: 23:35
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Override
    public List<Category> getCategoryList() {

        return categoryDao.queryCategory();
    }
}
