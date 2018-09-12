package com.o2obld.o2obld.entity;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 白色馒头
 * Date: 2018-09-11
 * Time: 21:32
 */
public class CategoryLevel extends Category {
    private Integer level;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void convertTo(Category category){
        this.setSort(category.getSort());
        this.setId(category.getId());
        this.setCategoryName(category.getCategoryName());
        this.setParentId(category.getParentId());

    }

}
