package uuia.info.devbackend.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import uuia.info.devbackend.entity.App;
import uuia.info.devbackend.entity.User;
import uuia.info.devbackend.service.DevOpenPlatformService;
import uuia.info.devbackend.service.TransmitService;
import uuia.info.devbackend.util.CommonResult;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Raven
 * @Date: 2019/8/2 10:43 AM
 */
@RestController
@CrossOrigin
public class OauthController {
    @Resource
    DevOpenPlatformService devOpenPlatformService;

    @Resource
    TransmitService transmitService;

    @ApiOperation(value ="注册", notes = "注册", httpMethod = "POST")
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public CommonResult signUp(@ApiParam(name="传入对象", value="传入json格式", required=true) @RequestBody User user){
        return devOpenPlatformService.register(user);
    }

    @ApiOperation(value ="激活", notes = "激活", httpMethod = "GET")
    @RequestMapping(value = "/activation", method = RequestMethod.GET)
    public CommonResult activation(@ApiParam(name="传入对象", value="传入json格式", required=true) @RequestParam String code){
        return devOpenPlatformService.activation(code);
    }

    @ApiOperation(value ="登录", notes = "登录", httpMethod = "POST")
    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public CommonResult signIn(@ApiParam(name="传入对象", value="传入json格式", required=true) @RequestBody User user){
        return devOpenPlatformService.login(user);
    }

    @ApiOperation(value ="获取用户基本信息", notes = "获取用户基本信息", httpMethod = "GET")
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public CommonResult getUserInfo(@ApiParam(name="传入对象", value="传入json格式", required=true) HttpServletRequest request){
        return devOpenPlatformService.getUserInfo(Integer.valueOf((String) request.getAttribute("userId")));
    }

    @ApiOperation(value ="获取用户所有的APP子节点信息", notes = "获取我所有的APP子节点信息", httpMethod = "GET")
    @RequestMapping(value = "/me/my-sub-nodes", method = RequestMethod.GET)
    public CommonResult getUserAllApps(@ApiParam(name="传入对象", value="传入json格式", required=true) HttpServletRequest request){
        return devOpenPlatformService.getUserAllApps(Integer.valueOf((String) request.getAttribute("userId")));
    }

    @ApiOperation(value ="新建子节点", notes = "新建子节点", httpMethod = "POST")
    @RequestMapping(value = "/sub-node/create", method = RequestMethod.POST)
    public CommonResult getUserInfo(@ApiParam(name="传入对象", value="传入json格式", required=true) @RequestBody App app, HttpServletRequest request){
        return devOpenPlatformService.createApp(app, Integer.valueOf((String) request.getAttribute("userId")));
    }

    @ApiOperation(value ="修改子节点信息", notes = "修改子节点信息", httpMethod = "POST")
    @RequestMapping(value = "/sub-node/update", method = RequestMethod.POST)
    public CommonResult updateApp(@ApiParam(name="传入对象", value="传入json格式", required=true) @RequestBody App app){
        return devOpenPlatformService.updateApp(app);
    }

    @ApiOperation(value ="查看子节点详情", notes = "查看子节点详情", httpMethod = "GET")
    @RequestMapping(value = "/sub-node/{app-id}", method = RequestMethod.GET)
    public CommonResult getAppDetail(@ApiParam(name="传入对象", value="传入json格式", required=true) @PathVariable(value = "app-id") int appId){
        return devOpenPlatformService.getAppDetail(appId);
    }

    @ApiOperation(value ="查看统计详情", notes = "查看统计详情", httpMethod = "POST")
    @RequestMapping(value = "/sub-node/statistics", method = RequestMethod.POST)
    public CommonResult getAppStatistics(@ApiParam(name="传入对象", value="传入json格式", required=true) @RequestBody JSONObject requestJson, HttpServletRequest request){
        return transmitService.statistics(requestJson.getString("uuiaAppId"), requestJson.getDate("startTime"), requestJson.getDate("endTime"), Integer.valueOf((String) request.getAttribute("userId")));
    }

    @ApiOperation(value ="查看日志详情", notes = "查看日志详情", httpMethod = "POST")
    @RequestMapping(value = "/sub-node/logs", method = RequestMethod.POST)
    public CommonResult getAppLogs(@ApiParam(name="传入对象", value="传入json格式", required=true) @RequestBody JSONObject requestJson, HttpServletRequest request){
        return transmitService.logs(requestJson.getString("uuiaAppId"), requestJson.getInteger("pageSize"), requestJson.getInteger("pageNum"), Integer.valueOf((String) request.getAttribute("userId")));
    }

    @ApiOperation(value ="测试子节点连通性", notes = "查看日志详情", httpMethod = "POST")
    @RequestMapping(value = "/sub-node/ping", method = RequestMethod.POST)
    public CommonResult getAppPing(@ApiParam(name="传入对象", value="传入json格式", required=true) @RequestBody JSONObject requestJson, HttpServletRequest request){
        return transmitService.ping(requestJson.getString("uuiaAppId"), Integer.valueOf((String) request.getAttribute("userId")));
    }

}
