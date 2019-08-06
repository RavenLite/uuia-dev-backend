package uuia.info.devbackend.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import uuia.info.devbackend.entity.App;
import uuia.info.devbackend.spider.AppRequest;
import uuia.info.devbackend.util.CommonResult;

import java.io.IOException;

@Service
public class TransmitService {

    public static final String statisticUrl = "https://uuia-center.cheelem.com:8891/open-platform/statistics";
    public static final String logsUrl = "https://uuia-center.cheelem.com:8891/open-platform/logs";


    public CommonResult<Object> statistic(String uuiaAppId) {
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

    public CommonResult<Object> logs(String uuiaAppId,Integer pageSize, Integer pageNum){
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


}
