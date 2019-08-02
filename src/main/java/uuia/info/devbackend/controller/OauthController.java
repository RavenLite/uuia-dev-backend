package uuia.info.devbackend.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uuia.info.devbackend.util.CommonResult;

/**
 * @Author: Raven
 * @Date: 2019/8/2 10:43 AM
 */
public class OauthController {

    @ApiOperation(value ="登录", notes = "登录", httpMethod = "POST")
    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public CommonResult signIn(@ApiParam(name="传入对象", value="传入json格式", required=true) @RequestBody DemoDto input){
        return null;
    }

    private class DemoDto {
    }
}
