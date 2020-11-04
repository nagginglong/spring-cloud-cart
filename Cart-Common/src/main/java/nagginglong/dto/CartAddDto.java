package nagginglong.dto;

import lombok.Data;

/**
 * description: 将商品添加到购物车的Dto
 *
 * @author: nagginglong
 * @CreateTime: 2020/11/4   20:22
 */

@Data
public class CartAddDto {

    private int skuid;
    private int uid;
    private int jprice;
    private int count;

}
