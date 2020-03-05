package com.xvnan.util;

import com.xvnan.model.*;
import com.xvnan.jpbc.api.Element;
import com.xvnan.jpbc.api.Pairing;
import com.xvnan.jpbc.api.PairingParameters;
import com.xvnan.jpbc.plaf.pairing.PairingFactory;
import com.xvnan.jpbc.plaf.pairing.a1.TypeA1CurveGenerator;
import com.xvnan.jpbc.plaf.util.ElementUtils;
import com.xvnan.jpbc.plaf.util.io.Base64;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author nan_xu
 * @date 2020/1/6
 *
 * ！！！！后端只需要init()、initMSK()、initParams()、search()方法，常量和search后面的工具方法 取所需即可！！！！
 *
 */
public class JPBCUtil {

    //@Value("${file_local}")
    private static  String file_local="/data/file_local";
    private static Pairing pairing;
    private static Params params;
    private static PairingParameters parameters;
    private static final int NUM_PRIMES = 4;
    private static final int NUM_BITS = 32;
    private static MSK msk;
    private static final int h = 5;

    /*public static void main(String[] args) {
        init();
        test();
    }*/



    /**
     * 初始化，生成PairingParameters parameters，永久保存，之后不再修改
     */
    public static void init() {
        try{
            TypeA1CurveGenerator pg = new TypeA1CurveGenerator(NUM_PRIMES, NUM_BITS);
            parameters = pg.generate();
            System.out.println("initJPBC: parameters="+parameters.toString());
            initMSK();
            initParams();
            File file=new File(file_local+"/Pairing");
            if(!file.exists()){
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(parameters);
        }catch (Exception ex){

        }

    }

    /**
     * 通过parameters生成私钥
     */
    private static void initMSK() throws IOException{
        msk = new MSK();
        msk.x = getStringFromElement(getGpRandomElement(0));
        msk.y = getStringFromElement(getGpRandomElement(0));
        msk.w = getStringFromElement(getGpRandomElement(0));
        msk.uList = new String[h];
        for (int i = 0; i < h; i++) {
            msk.uList[i] = getStringFromElement(getGpRandomElement(0));
        }
        File file=new File(file_local+"/MSK");
        if(!file.exists()){
            file.createNewFile();
        }
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(msk);
    }

    /**
     * 通过parameters生成公钥
     */
    private static void initParams() throws IOException{
        params = new Params();
        params.n = parameters.getBigInteger("n");
        params.X = getStringFromElement(getG_or_GpFromString(msk.x).mul(getGpRandomElement(3)));
        params.Y = getStringFromElement(getG_or_GpFromString(msk.y).mul(getGpRandomElement(3)));

        params.UList = new String[h];
        for (int i = 0; i < h; i++) {
            params.UList[i] = getStringFromElement(getG_or_GpFromString(msk.uList[i]).mul(getGpRandomElement(3)));
        }

        params.R3 = getStringFromElement(getGpRandomElement(2));
        params.R4 = getStringFromElement(getGpRandomElement(3));
        params.E = getStringFromElement(getPairing().pairing(getG_or_GpFromString(msk.x), getG_or_GpFromString(msk.w)).getImmutable());
        File file=new File(file_local+"/Params");
        if(!file.exists()){
            file.createNewFile();
        }
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(params);
    }


    /*
     * 生成用于搜索关键字的陷门
     * @param keyword 要搜索的关键字
     * @return 陷门
    public static String[] trapDoorGen(Keyword keyword) {
        Element[] Iv = new Element[h]; //解析w
        for (int j = 0; j < h; j++) {
            Iv[j] = getZrNum(keyword.getKeyIndex()[j]);
        }

        System.out.println("trapDoorGen Iv="+ Arrays.toString(Iv));

        String[] Td = new String[2];
        Element r1 = getZrRandomElement();
        Td[0] = getStringFromElement(getG_or_GpFromString(msk.x).duplicate().powZn(r1.duplicate()).mul(getGpRandomElement(2)));
        Element uMul = getG_or_GpFromString(msk.uList[0]).powZn(Iv[0]);
        for (int i = 1; i < h; i++) {
            uMul = uMul.mul(getG_or_GpFromString(msk.uList[i]).powZn(Iv[i]));
        }
        uMul = getG_or_GpFromString(msk.y).mul(uMul).powZn(r1);
        Td[1] = getStringFromElement(getG_or_GpFromString(msk.w).mul(uMul).mul(getGpRandomElement(2)));
        return Td;
    }

    /**
     * 后台search接口
     * @param encryptDataList 数据库中保存的所有加密数据
     * @param Td 前端调用search接口传入的参数
     */
    public static List<FeedbackData> search(EncryptData[] encryptDataList, String[] Td) {
        List<FeedbackData> feedbackDataList = new ArrayList<>();
        for (EncryptData encryptData : encryptDataList) {
            for (Index c : encryptData.getIndex()) {
                Element Mv_ = getGtFromString(c.C0).mul((getPairing().pairing(getG_or_GpFromString(Td[0]),
                        getG_or_GpFromString(c.C1)).duplicate()).div(getPairing().pairing(getG_or_GpFromString(Td[1]),
                        getG_or_GpFromString(c.C2)).duplicate()));
                if (Mv_.equals(getGtFromString(c.Mv))) {
                    feedbackDataList.add(encryptData.getFeedbackData());
                    break;
                }
            }
        }
        return feedbackDataList;
    }

    private static String getStringFromElement(Element element) {
        return Base64.encodeBytes(element.toBytes());
    }

    private static byte[] getByteFromString(String str) {
        try {
            return Base64.decode(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Pairing getPairing() {
        if (pairing == null) {
            pairing = PairingFactory.getPairing("static/a1.properties");
        }
        return pairing;
    }

    private static Element getGtFromString(String str) {
        Element element = getPairing().getGT().newRandomElement();
        element.setFromBytes(getByteFromString(str));
        return element.getImmutable();
    }

    private static Element getG_or_GpFromString(String str) {
        Element element = getPairing().getG1().newRandomElement();
        element.setFromBytes(getByteFromString(str));
        return element.getImmutable();
    }

    private static Element getZrRandomElement() {
        return getPairing().getZr().newRandomElement().getImmutable();
    }

    private static Element getZrNum(int num) {
        return getPairing().getZr().newRandomElement().set(num);
    }

    private static Element getGtRandomElement() {
        return getPairing().getGT().newRandomElement().getImmutable();
    }

    private static Element getGRandomElement() {
        return getPairing().getG1().newRandomElement().getImmutable();
    }

    private static Element getGpRandomElement(int subgroupIndex) {
        return ElementUtils.getGenerator(getPairing(), getGRandomElement(), parameters, subgroupIndex, NUM_PRIMES).getImmutable();
    }
}
