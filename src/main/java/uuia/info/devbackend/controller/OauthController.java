package uuia.info.devbackend.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import uuia.info.devbackend.entity.App;
import uuia.info.devbackend.entity.User;
import uuia.info.devbackend.service.TestService;
import uuia.info.devbackend.util.CommonResult;

import javax.annotation.Resource;

/**
 * @Author: Raven
 * @Date: 2019/8/2 10:43 AM
 */
@RestController
@CrossOrigin
public class OauthController {
    @Resource
    TestService testService;

    @ApiOperation(value ="注册", notes = "注册", httpMethod = "POST")
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public CommonResult signUp(@ApiParam(name="传入对象", value="传入json格式", required=true) @RequestBody User user){
        return testService.register(user);
    }

    @ApiOperation(value ="激活", notes = "激活", httpMethod = "GET")
    @RequestMapping(value = "/activation", method = RequestMethod.GET)
    public CommonResult activation(@ApiParam(name="传入对象", value="传入json格式", required=true) @RequestParam String code){
        return testService.activation(code);
    }

    @ApiOperation(value ="登录", notes = "登录", httpMethod = "POST")
    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public CommonResult signIn(@ApiParam(name="传入对象", value="传入json格式", required=true) @RequestBody User user){
        return CommonResult.success(testService.login(user));
    }

    @ApiOperation(value ="获取用户基本信息", notes = "获取用户基本信息", httpMethod = "GET")
    @RequestMapping(value = "/{user-id}", method = RequestMethod.GET)
        public CommonResult getUserInfo(@ApiParam(name="传入对象", value="传入json格式", required=true) @PathVariable(value = "user-id") int id){
        return CommonResult.success(testService.getUserInfo(id));
    }

    @ApiOperation(value ="获取用户所有的APP子节点信息", notes = "获取我所有的APP子节点信息", httpMethod = "GET")
    @RequestMapping(value = "/{user-id}/my-sub-nodes", method = RequestMethod.GET)
    public CommonResult getUserAllApps(@ApiParam(name="传入对象", value="传入json格式", required=true) @PathVariable(value = "user-id") int id){
        return CommonResult.success(testService.getUserAllApps(id));
    }

    @ApiOperation(value ="新建子节点", notes = "新建子节点", httpMethod = "POST")
    @RequestMapping(value = "/sub-node/{app-id}/create", method = RequestMethod.POST)
    public CommonResult getUserInfo(@ApiParam(name="传入对象", value="传入json格式", required=true) @RequestBody App app, @PathVariable(value = "app-id") String uuiaAppId){
        app.setUuiaAppId(uuiaAppId);
        return CommonResult.success(testService.createApp(app));
    }

    @ApiOperation(value ="修改子节点信息", notes = "修改子节点信息", httpMethod = "POST")
    @RequestMapping(value = "/sub-node/{app-id}/update", method = RequestMethod.POST)
    public CommonResult updateApp(@ApiParam(name="传入对象", value="传入json格式", required=true) @RequestBody App app, @PathVariable(value = "app-id") String uuiaAppId){
        app.setUuiaAppId(uuiaAppId);
        return CommonResult.success(testService.updateApp(app));
    }

    @ApiOperation(value ="查看子节点详情", notes = "查看子节点详情", httpMethod = "GET")
    @RequestMapping(value = "/sub-node/{app-id}", method = RequestMethod.GET)
    public CommonResult getAppDetail(@ApiParam(name="传入对象", value="传入json格式", required=true) @PathVariable(value = "app-id") String uuiaAppId){
        return CommonResult.success(testService.getAppDetail(uuiaAppId));
    }

}
