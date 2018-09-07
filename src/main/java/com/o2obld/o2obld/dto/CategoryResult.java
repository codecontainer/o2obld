package com.o2obld.o2obld.dto;

import com.o2obld.o2obld.enums.CategoryStateEnum;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 白色馒头
 * Date: 2018-09-07
 * Time: 23:00
 */
public class CategoryResult extends BaseResult {

    public CategoryResult(CategoryStateEnum stateenum){
        this.setState(stateenum.getState());
        this.setStateinfo(stateenum.getStateinfo());
    }

}
