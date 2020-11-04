package com.nagginglong.service.impl;

import com.nagginglong.dao.CartDao;
import com.nagginglong.entity.Cart;
import com.nagginglong.service.intf.CartService;
import nagginglong.dto.CartAddDto;
import nagginglong.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 *
 * @author: nagginglong
 * @CreateTime: 2020/11/4   20:32
 */

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    /*
     *V1版本，功能实现
     */

    @Override
    public Result add(CartAddDto dto) {

        //1.判断传入参数是否安全
        if (dto != null && dto.getSkuid() >0 && dto.getUid() > 0 &&dto.getSkuid()> 0 && dto.getJprice() > 0) {

            //传入的参数安全
            //2,判断数据库中是否存在此SKUID和此UID对应的数据，
            List<Cart> carts = cartDao.selectBySkiuAndUid(dto);

            //进而判断是修改数量还是添加商品
            if (carts != null && carts.size() > 0) {

                //说明此商品和uid存在，就是修改数量
                cartDao.updateBySkuidAndUid(dto);

            } else {

                //添加此商品

            }

        }


        return Result.fail("传入的参数有误！");
    }

    @Override
    public Result updateScountByaddDec(CartAddDto dto) {
        return null;
    }

    @Override
    public Result updateByScount(CartAddDto dto) {
        return null;
    }

    @Override
    public Result delScount(Integer id) {
        return null;
    }

    @Override
    public Result All(Integer uid) {
        return null;
    }
}
