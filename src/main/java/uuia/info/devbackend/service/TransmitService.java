package uuia.info.devbackend.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import uuia.info.devbackend.entity.App;
import uuia.info.devbackend.entity.RelationUserApp;
import uuia.info.devbackend.entity.User;
import uuia.info.devbackend.repository.AppRepository;
import uuia.info.devbackend.repository.RelationUserAppRepository;
import uuia.info.devbackend.repository.UserRepository;
import uuia.info.devbackend.spider.AppRequest;
import uuia.info.devbackend.util.CommonResult;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class TransmitService {
    @Resource
    AppRepository appRepository;

    @Resource
    RelationUserAppRepository relationUserAppRepository;



    public static final String subNodeUrl = "https://uuia-center.cheelem.com:8891/open-platform/sub-node";
    public static final String statisticUrl = "https://uuia-center.cheelem.com:8891/open-platform/statistics";
    public static final String logsUrl = "https://uuia-center.cheelem.com:8891/open-platform/logs";


    public CommonResult<Object> statistic(String uuiaAppId, Integer userId) {
        if(!checkUserAuthority(uuiaAppId,userId)){
            return CommonResult.fail();
        }
        JSONObject object = new JSONObject();
        object.put("uuiaAppId",uuiaAppId);
        object.put("appId",uuiaAppId);
        JSONObject result = null;
        try {
            result = new AppRequest().transmitPost(statisticUrl,object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(result!=null){
            return CommonResult.success(result);
        }else {
            return CommonResult.fail();
        }
    }

    public CommonResult<Object> logs(String uuiaAppId,Integer pageSize, Integer pageNum, Integer userId){
        if(!checkUserAuthority(uuiaAppId,userId)){
            return CommonResult.fail();
        }
        JSONObject object = new JSONObject();
        object.put("uuiaAppId",uuiaAppId);
        object.put("appId",uuiaAppId);
        object.put("pageSize",pageSize);
        object.put("pageNum",pageNum);
        JSONObject result = null;
        try {
            result = new AppRequest().transmitPost(logsUrl,object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(result!=null){
            return CommonResult.success(result);
        }else {
            return CommonResult.fail();
        }
    }

    public CommonResult<Object> subNode(App app){
        JSONObject object = JSONObject.parseObject(JSONObject.toJSONString(app));
        JSONObject result = null;
        try {
            result = new AppRequest().transmitPost(subNodeUrl, object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(result!=null){
            return CommonResult.success(result);
        }else {
            return CommonResult.fail();
        }
    }


    public boolean checkUserAuthority(String uuiaAppId,Integer userId){
        App app = appRepository.findByUuiaAppId(uuiaAppId);
        if(app == null){
            return false;
        }
        if(app.getOwnerId()== userId){
            return true;
        }
        return relationUserAppRepository.findByUserIdAndAppId(userId,app.getId())==null;
    }

}
