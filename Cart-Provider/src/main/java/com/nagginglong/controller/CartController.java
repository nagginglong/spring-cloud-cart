package com.nagginglong.controller;

import com.nagginglong.service.intf.CartService;
import com.nagginglong.dto.CartAddDto;
import com.nagginglong.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:
 *
 * @author: nagginglong
 * @CreateTime: 2020/11/4   20:27
 */

@RestController
@RequestMapping("/api/provider/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add.do")
    public Result add(CartAddDto dto){

        return cartService.add(dto);
    }

    @PostMapping("/all.do")
    public Result all(Integer uid){

        return cartService.All(uid);
    }

    @PostMapping("/delOne.do")
    public Result delOne(Integer id){

        return cartService.delOne(id);
    }

    @PostMapping("/updateSount2.do")
    public Result updateByScount(CartAddDto dto){

        return cartService.updateByScount(dto);
    }

    @PostMapping("/updateSount1.do")
    public Result updateScountByaddOrDec(CartAddDto dto){

        return cartService.updateScountByaddOrDec(dto);
    }


}
