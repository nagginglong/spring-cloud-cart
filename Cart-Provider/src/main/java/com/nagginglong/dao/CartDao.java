package com.nagginglong.dao;

import com.nagginglong.entity.Cart;
import com.nagginglong.dto.CartAddDto;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description:
 *
 * @author:像大山一样
 * @time:2020/11/4CartDao
 */

@Repository
public interface CartDao {

    //根据SKUID和UID查询对应的数据
    @Select("select * from t_cart where skuid = #{skuid} and uid = #{uid}")
    @ResultType(com.nagginglong.entity.Cart.class)
    List<Cart> selectBySkiuAndUid (CartAddDto dto);

    //根据SKUID和UID修改商品数量
    @Update("update t_cart set scount = #{scount} where skuid = #{skuid} and uid = #{uid}")
    Integer updateBySkuidAndUid(CartAddDto dto);

    //添加商品
    @Insert("insert into t_cart (skuid, uid, scount, jprice, ctime) values (#{skuid}, #{uid},#{scount},#{jprice},now())")
    Integer add(CartAddDto dto);


    //修改数量，每次加或减一
    @Update("update t_cart set scount = scount + #{scount} where skuid = #{skuid} and uid = #{uid}")
    Integer updateScountBySkuidAndUid(CartAddDto dto);


    //删除对应的商品
    @Delete("delete from t_cart where id = #{id}")
    Integer delOne(Integer id);


    //根据SKUID和UID查询对应的数据
    @Select("select * from t_cart where  uid = #{uid}")
    @ResultType(com.nagginglong.entity.Cart.class)
    List<Cart> selectByUid(Integer uid);
}
