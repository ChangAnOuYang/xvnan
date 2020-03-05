/*

package com.xvnan;

import com.alibaba.fastjson.JSONObject;
import com.xvnan.model.FeedbackData;
import com.xvnan.util.HttpClientUtils;
import com.xvnan.jpbc.api.Element;
import com.xvnan.jpbc.api.Pairing;
import com.xvnan.jpbc.api.PairingParameters;
import com.xvnan.jpbc.plaf.pairing.PairingFactory;
import com.xvnan.jpbc.plaf.pairing.a1.TypeA1CurveGenerator;
import com.xvnan.util.JPBCUtil;
import org.junit.Test;

public class LoginTest {
    @Test
    public void testLogin(){
        JSONObject json=new JSONObject();
        json.put("userName","test");
        json.put("password","test");

        System.out.println(HttpClientUtils.doPost("http://212.64.70.133:8080/user/login",json.toJSONString()));
    }

    @Test
    public void testDemo(){
            TypeA1CurveGenerator pg = new TypeA1CurveGenerator(4, 32);
            PairingParameters parameters = pg.generate();
            Pairing pairing = PairingFactory.getPairing(parameters);
            Element Z_N = pairing.getZr().newRandomElement().getImmutable();
            System.out.println(parameters);
    }

    @Test
    public void testSerial(){
        FeedbackData feedbackData=new FeedbackData();
        feedbackData.cipherMessage="test";
        feedbackData.time=System.currentTimeMillis();

    };

    @Test
    public void testSearch(){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("indexArray","BVPs1pYOncKhR+ig4z2WaAgC14lE0fxda1p81PsxkKiY2g==");
        jsonObject.put("indexString","Balhtl19mEb0EF4D8cyK2CkEb/SYxAqmhh0zUrej040OvQ==");
        System.out.println(HttpClientUtils.doPost("http://localhost:8081/main/searchData",jsonObject.toJSONString()));
    }

    @Test
    public void testUpload() {
        //JPBCUtil.getPairing();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("indexArray", "BVPs1pYOncKhR+ig4z2WaAgC14lE0fxda1p81PsxkKiY2g==");
        jsonObject.put("indexString", "Balhtl19mEb0EF4D8cyK2CkEb/SYxAqmhh0zUrej040OvQ==");
        System.out.println(HttpClientUtils.doPost("http://localhost:8081/main/uploadData", jsonObject.toJSONString()));
    }
}


*/
