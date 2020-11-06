package com.nagginglong.service.impl;

import com.nagginglong.dao.CartDao;
import com.nagginglong.entity.Cart;
import com.nagginglong.service.intf.CartService;
import com.nagginglong.dto.CartAddDto;
import com.nagginglong.vo.Result;
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

        //1.判断传入参数是否安全 ?
        if (dto != null && dto.getSkuid() >0 && dto.getUid() > 0 &&dto.getSkuid()> 0 && dto.getJprice() >= 0 && dto.getScount() > 0) {

            //传入的参数安全
            //2,判断数据库中是否存在此SKUID和此UID对应的数据，
            List<Cart> carts = cartDao.selectBySkiuAndUid(dto);

            //进而判断是修改数量还是添加商品
            if (carts != null && carts.size() > 0) {

                //说明此商品和uid存在，就是修改数量
                if (cartDao.updateBySkuidAndUid(dto) > 0) {

                    return Result.ok();

                } else {

                    return Result.fail();
                }

            } else {

                //添加此商品
                if (cartDao.add(dto) > 0) {

                    return Result.ok();

                } else {

                    return Result.fail();

                }

            }

        }


        return Result.fail("传入的参数有误！");
    }
    
    /**
     * @Description: 修改数量
     * @Param: [dto]
     * @return: com.nagginglong.vo.Result 
     * @Author: nagginglong 
     * @Date: 2020/11/4 21:47 
     **/
    @Override
    public Result updateScountByaddOrDec(CartAddDto dto) {

        //判断所参数是否非法
        if (dto != null && dto.getSkuid() > 0 && dto.getUid() > 0 &&  dto.getJprice() >= 0 && (dto.getScount() == 1 || dto.getScount() == -1) ) {

            //参数合法
            if (cartDao.updateScountBySkuidAndUid(dto) > 0) {
                return Result.ok();

            } else {

                return Result.ok();
            }

        } else {

            return Result.fail("传入的参数非法！");

        }

    }

    @Override
    public Result updateByScount(CartAddDto dto) {

        //判断所参数是否非法
        if (dto != null && dto.getSkuid() > 0 && dto.getUid() > 0 &&  dto.getJprice() >= 0 && dto.getScount() > 0  ) {

            //参数合法
            if (cartDao.updateBySkuidAndUid(dto) > 0) {

                return Result.ok();

            } else {

                return Result.fail();
            }

        } else {

            return Result.fail("传入的参数非法！");

        }
    }

    @Override
    public Result delOne(Integer id) {

        //判断所参数是否非法
        if (id > 0) {

            //参数合法
            if (cartDao.delOne(id) > 0) {

                return Result.ok();

            } else {

                return Result.fail();
            }


        } else {

            return Result.fail("传入的参数非法！");

        }

    }

    @Override
    public Result All(Integer uid) {

        //检验参数是否非法
        if (uid > 0) {

            List<Cart> carts = cartDao.selectByUid(uid);

            return Result.ok(carts);

        } else {

            return Result.fail("传入的参数非法！");

        }

    }


    /*
     *V2版本，使用Redis、RabbitMQ进行功能实现
     */




}
