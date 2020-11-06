package com.nagginglong.vo;

import com.nagginglong.config.ResultType;
import lombok.Data;
import com.nagginglong.config.ResultType;

/**
 * description: 返回结果的类
 *
 * @author: nagginglong
 * @CreateTime: 2020/11/4   20:10
 */

@Data
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    public static <T>Result setResult(Integer code,String msg,T data){

        Result  result = new Result<>();
        result.code = code;
        result.msg = msg;
        result. data = data;

        return result;
    }

    public static Result ok(){

        return setResult(ResultType.RESULT_SUCCESS,"success",null);
    }


    public static <T>Result ok(T data){

        return setResult(ResultType.RESULT_SUCCESS,"success",data);
    }

    public static Result fail(){

        return setResult(ResultType.RESULT_Fail,"fail",null);
    }

    public static Result fail(String msg){

        return setResult(ResultType.RESULT_Fail,"fail",null);
    }

}
