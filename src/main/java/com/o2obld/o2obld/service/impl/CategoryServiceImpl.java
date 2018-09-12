package com.o2obld.o2obld.service.impl;

import com.o2obld.o2obld.dao.CategoryDao;
import com.o2obld.o2obld.dto.CategoryResult;
import com.o2obld.o2obld.entity.Category;
import com.o2obld.o2obld.entity.CategoryLevel;
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

    @Override
    public void recCategory(List<CategoryLevel> categoryLevelList, List<Category> categoryList, Integer id, Integer level) {
        for (Category category:categoryList){
            System.out.println("id:"+category.getId());
            if(category.getParentId()==id){
                CategoryLevel cl=new CategoryLevel();
                cl.convertTo(category);
                System.out.println("clid:"+cl.getParentId());
                cl.setLevel(level);
                categoryLevelList.add(cl);
                recCategory(categoryLevelList,categoryList,category.getId(),level+1);

            }
        }

    }

    @Override
    public void setChar(List<CategoryLevel> cl) {

        for (CategoryLevel categoryLevel:cl) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i <categoryLevel.getLevel(); i++) {
                sb.append("==");
            }
            categoryLevel.setCategoryName(sb+categoryLevel.getCategoryName());
        }
    }
}
