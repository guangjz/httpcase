package com.qa.Case.EC_Console;

import com.qa.Case.Public.HostAddress;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

/**
 * Created by guangjiazheng on 2019/5/6.
 */
public class GetAnswerList {

    public static final java.lang.String url = "/ec-console/wechat/answer/getAnswerList";

    @Test
    public static void getAnswerList_qa() throws Exception{

        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpPost post = new HttpPost(HostAddress.QA_ECconsole_ip+GetAnswerList.url);
        post.addHeader("Content-Type:","application/json");
        post.addHeader("token",HostAddress.QA_ECconsole_token);

        java.lang.String pageNo = "pageNo=1";
        java.lang.String pageSize = "pageSize=20";
        java.lang.String status = "status=6";
        java.lang.String date = pageNo+"&"+pageSize+"&"+status;

        StringEntity entity = new StringEntity(date, "utf-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("X-WWW-FORM-URLENCODED");
        post.setEntity(entity);

        // 执行请求
        HttpResponse response = httpClient.execute(post);
        String json2 = EntityUtils.toString(response.getEntity(), "utf-8");
        JSONObject jsonObject = JSONObject.fromObject(json2);

        // 打印执行结果
        System.out.println(jsonObject);
    }

}
