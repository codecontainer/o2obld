package com.o2obld.o2obld.service.impl;

import com.o2obld.o2obld.dao.CategoryDao;
import com.o2obld.o2obld.dto.CategoryResult;
import com.o2obld.o2obld.entity.Category;
import com.o2obld.o2obld.enums.CategoryStateEnum;
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

    @Override
    public CategoryResult insertCategroy(Category categroy) {
        try {
            int result=categoryDao.insertCategory(categroy);
            if(result>0){
                return new CategoryResult(CategoryStateEnum.SUCCESS);
            }else{
                return new CategoryResult(CategoryStateEnum.INNER_ERROR);
            }
        }catch (Exception e){
            throw new RuntimeException("系统错误:"+e.getMessage());
        }

    }
}
