package uuia.info.devbackend.spider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import uuia.info.devbackend.util.SHAUtils;
import java.io.IOException;


public class AppRequest {

    private CloseableHttpClient client;

    public static final String key = "b14c05f815d9d8f96afd66149b0b4117fd6afb3bb339f57c3324b855478943e2";


    public AppRequest(){
        client = HttpClientBuilder.create().build();
    }

    public JSONObject transmitPost(String url,JSONObject object) throws IOException {
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-type", "application/json");
        Long timestamp = System.currentTimeMillis();
        object.put("signature", SHAUtils.encodeData(key+timestamp));
        object.put("timestamp",String.valueOf(timestamp));
        System.out.println(object.toJSONString());
        post.setEntity(new StringEntity(object.toString()));
        CloseableHttpResponse response;
        try {
            response = client.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String responseContent = EntityUtils.toString(response.getEntity());
        response.close();
        post.releaseConnection();
        return JSON.parseObject(responseContent);
    }

    public void close() throws IOException {
        client.close();
    }
}
