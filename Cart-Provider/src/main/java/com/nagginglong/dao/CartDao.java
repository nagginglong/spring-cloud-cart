package com.nagginglong.dao;

import com.nagginglong.entity.Cart;
import nagginglong.dto.CartAddDto;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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
    List<Cart> selectBySkiuAndUid (CartAddDto dto);

    //根据SKUID和UID修改商品数量
    @Update("update t_cart set scount = #{scount} where skuid = #{skuid} and uid = #{uid} ")
    Integer updateBySkuidAndUid(CartAddDto dto);

}
