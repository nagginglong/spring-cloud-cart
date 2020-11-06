package com.nagginglong.service.intf;

import com.nagginglong.dto.CartAddDto;
import com.nagginglong.vo.Result;

/**
 * description:
 *
 * @author:像大山一样
 * @time:2020/11/4CartService
 */


public interface CartService {

    //添加购物车信息
    Result add(CartAddDto dto);

    //根据加减修改购物车数量
    Result updateScountByaddOrDec(CartAddDto dto);

    //根据输入的数量修改购物车的数量
    Result updateByScount(CartAddDto dto);

    //删除购物车
    Result delOne(Integer id);

    //查询购物车信息
    Result All(Integer uid);


}
