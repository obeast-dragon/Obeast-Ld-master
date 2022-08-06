package com.obeast.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author wxl
 * @date 2022/8/6 13:45
 * @description: 分页response
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageObjects<T> implements Serializable {

    /**
     * 查询总数
     * */
    private Long total;

    /**
     * 列表数据
     * */
    private List<T> items;

}
