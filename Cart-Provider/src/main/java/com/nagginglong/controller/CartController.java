package com.nagginglong.controller;

import com.nagginglong.service.intf.CartService;
import nagginglong.dto.CartAddDto;
import nagginglong.vo.Result;
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
@RequestMapping("/api/cartprovider/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public Result add(CartAddDto dto){

        return cartService.add(dto);
    }


}
