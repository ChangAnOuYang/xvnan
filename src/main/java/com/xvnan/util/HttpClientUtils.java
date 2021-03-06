package com.xvnan.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

public class HttpClientUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);
    public static final int DEFAULT_CONNECT_TIMEOUT = 20000;
    public static final int DEFAULT_SOCKET_TIMEOUT = 20000;

    public static String doPost(String url, String body) {
        return doPost(url, body, null, null);
    }

    public static String doPost(String url, String body, String contentLength, String authorization) {
        StringBuffer stringBuffer = new StringBuffer();
        HttpEntity entity = null;
        BufferedReader in = null;
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = null;
        try {
            httpClient = getHttpClient();
            HttpPost httppost = new HttpPost(url);
            httppost.setHeader("Content-Type", "application/json");
            if (null != contentLength) {
                httppost.setHeader("Content-Length", contentLength);
            }
            if (null != authorization) {
                httppost.setHeader("Authorization", authorization);
            }
            httppost.setEntity(new ByteArrayEntity(body.getBytes("UTF-8")));
            response = httpClient.execute(httppost);
            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }
            entity = response.getEntity();
            in = new BufferedReader(new InputStreamReader(entity.getContent()));
            String ln;
            while ((ln = in.readLine()) != null) {
                stringBuffer.append(ln);
                stringBuffer.append("\r\n");
            }
            EntityUtils.consume(entity);
            response.close();
        } catch (ClientProtocolException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (IllegalStateException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {

            try {
                if (in != null) {
                    in.close();
                    in = null;
                }

                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException ex) {
                LOGGER.error(ex.getMessage(), ex);
            }
        }
        return stringBuffer.toString();
    }

    @SuppressWarnings("deprecation")
	public static CloseableHttpClient getHttpClient() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext ctx = SSLContext.getInstance("TLS");
        X509TrustManager tm = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[]{};
            }
        };
        ctx.init(null, new TrustManager[]{tm}, new java.security.SecureRandom());
        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(ctx,
                SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        RequestConfig config = RequestConfig.custom().setConnectTimeout(DEFAULT_CONNECT_TIMEOUT).setSocketTimeout(DEFAULT_SOCKET_TIMEOUT).build();
        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).setSslcontext(ctx)
                .setSSLSocketFactory(sslSocketFactory).build();
        return httpClient;
    }

    /**
     * @param url    待访问的url含urlparam
     * @param header 需要设置的header参数，默认使用content-type='applicaton/json'
     * @return
     */
    public static String doGet(String url, Map<String, String> header) {
        StringBuilder stringBuffer = new StringBuilder();
        HttpEntity entity = null;
        BufferedReader in = null;
        CloseableHttpResponse response = null;
        try (CloseableHttpClient httpClient = getHttpClient()) {
            HttpGet httpget = new HttpGet(url);
            RequestConfig config = RequestConfig.custom().setSocketTimeout(DEFAULT_SOCKET_TIMEOUT).setConnectTimeout(DEFAULT_CONNECT_TIMEOUT).build();
            httpget.setConfig(config);
            httpget.setHeader("Content-Type", "application/json");
            if (header != null) {
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    httpget.setHeader(entry.getKey(), entry.getValue());
                }
            }
            response = httpClient.execute(httpget);
            if (response.getStatusLine().getStatusCode() != 200) {
                LOGGER.error("Send http request failed.HTTP error code : {}" , response.getStatusLine().getStatusCode());
            }
            entity = response.getEntity();
            in = new BufferedReader(new InputStreamReader(entity.getContent()));
            String ln;
            while ((ln = in.readLine()) != null) {
                stringBuffer.append(ln);
                stringBuffer.append("\r\n");
            }
            EntityUtils.consume(entity);
            response.close();
        } catch (ClientProtocolException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e1) {
            LOGGER.error(e1.getMessage());
        } catch (IllegalStateException e2) {
            LOGGER.error(e2.getMessage());
        } catch (Exception e3) {
            LOGGER.error(e3.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                    in = null;
                }
            } catch (IOException ex) {
                LOGGER.error(ex.getMessage(), ex);
            }
        }
        return stringBuffer.toString();
    }
    
    /** 
     * 根据地址获得数据的字节流 
     * @param strUrl 网络连接地址 
     * @return 
     */  
    public static byte[] getImageFromByUrl(String strUrl){  
        try {  
            URL url = new URL(strUrl);  
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
            conn.setRequestMethod("GET");  
            conn.setConnectTimeout(5 * 1000);  
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据  
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据  
            return btImg;  
        } catch (Exception ex) {  
        	LOGGER.error(ex.getMessage(), ex);
        }  
        return null;  
    }  
    /** 
     * 从输入流中获取数据 
     * @param inStream 输入流 
     * @return 
     * @throws Exception 
     */  
    public static byte[] readInputStream(InputStream inStream) throws Exception{  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        while( (len=inStream.read(buffer)) != -1 ){  
            outStream.write(buffer, 0, len);  
        }  
        inStream.close();  
        return outStream.toByteArray();  
    }

}