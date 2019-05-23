package com.qa.Case.Public;

import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

/**
 * Created by guangjiazheng on 2019/5/23.
 */
public class newWorkSheet {

    public static final java.lang.String url = "/geec-order//api/v1/bomc/call/newWorkSheet";

    @Test
    public static void getSignList_qa() throws Exception{

        DefaultHttpClient httpClient = new DefaultHttpClient();

        org.apache.http.client.methods.HttpPost post = new org.apache.http.client.methods.HttpPost(HostAddress.QA_geecorder_ip+newWorkSheet.url);
        post.addHeader("Content-Type:","application/json;charset=UTF-8");
        post.addHeader("token",HostAddress.QA_geecorder_token);

        JSONObject jsonParam = new JSONObject();
        jsonParam.put("serialNo","20190402ZQKF0221566");
        jsonParam.put("attachRef","");

        System.out.println(jsonParam);


        StringEntity entity = new StringEntity(jsonParam.toString(), "UTF-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        post.setEntity(entity);

        // 执行请求
        HttpResponse response = httpClient.execute(post);
        String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject jsonObject = JSONObject.fromObject(json2);

        // 打印执行结果
        System.out.println(jsonObject);
    }

}
