package cn.xrz.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author XRZ
 * @date 2019-04-22
 * @Description :
 */
@RestController
@Api("Swagger测试服务接口类") //接口类描述
@RequestMapping("/swagger")
public class SwaggerController {



    @GetMapping("/get")
    @ApiOperation(value = "这是get方法") //接口吗描述
    public String get(){
        return "this is getMapping";
    }

    @PostMapping("/post")
    @ApiOperation(value = "这是post方法")
    public String post(){
        return "this is posttMapping";
    }

    @GetMapping("/getParm")
    @ApiImplicitParam(name = "name",value = "姓名",required = true,dataType = "String")
    @ApiOperation(value = "这是有参数的方法")
    public String getParm(@RequestParam("name") String name){
        return "参数方法,值："+name;
    }
}
