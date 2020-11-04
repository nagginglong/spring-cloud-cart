package com.nagginglong.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * description:
 *
 * @author: nagginglong
 * @CreateTime: 2020/11/4   20:23
 */
@Data
@NoArgsConstructor
public class Cart {

    private Integer id;
    private Integer skuid;
    private Integer uid;
    private Integer scount;
    private Integer jprice;
    private Date ctime;

    public Cart(Integer skuid, Integer uid, Integer scount, Integer jprice, Date ctime) {
        this.skuid = skuid;
        this.uid = uid;
        this.scount = scount;
        this.jprice = jprice;
        this.ctime = ctime;
    }
}
