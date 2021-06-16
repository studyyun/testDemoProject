package com.example.demo.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-02-22  20:41
 */
@Slf4j
@Component
public class FileTest {

    private static Logger logger = LoggerFactory.getLogger(FileTest.class);

    //    @Value("${local.file.temp.dir}")
    private String savePath = "/usr/ums/umc-mail-spgate/download/";

    //    @Value("${http.file.base.url}")
    private String httpFileBaseUrl = "http://192.169.1.26:8888/";

    private String relativeUrl = "file/corpemailtxt/sendemailtxt/2021\\2\\22\\1_2_20210222182100329_101148_10001_1001.txt";

    @PostConstruct
    public void init(){
//        new FileTest().downFile2Local(relativeUrl);
    }

    public String downFile2Local(String relateFileUrl){
        String[] baseUrls = httpFileBaseUrl.split(",");
        if (baseUrls == null || baseUrls.length == 0)
            return null;
        String[] urls = new String[baseUrls.length];
        for (int i = 0; i < baseUrls.length; i++)
            //http://192.169.0.220:8080/emp/ + file/corpemailtxt/sendemailtxt/2021/2/22/1_2_20210222094333727_100670_10010_1001.txt
            urls[i] = baseUrls[i] + relateFileUrl;
        return getFileByHttpFormUrlBatch(urls);
    }

    private String getFileByHttpFormUrlBatch(String[] netUrls){
        if (null != netUrls && netUrls.length > 0 && null != savePath && !"".equals(savePath)) {
            for (String str : netUrls) {
                str=getNetAddress(str);
                String localFilePath = testA(str);
                if (null != localFilePath && !"".equals(localFilePath)) {
                    return localFilePath;
                }
            }
        }
        return null;
    }

    private static String getNetAddress(String str){
        if(str==null){
            return str;
        }
        return str.replace("\\","/");
    }

    public String testA(String netUrl){


        String fileName = netUrl.substring(netUrl.lastIndexOf('/') + 1);
//        String savePath = "/usr/ums/umc-mail-spgate/download/";
        File saveDir = new File(savePath);
        if (!saveDir.exists()){
            saveDir.mkdirs();//注意这里不能写saveDir.mkdir()，区别在于mkdirs会迭代创建，mkdir只会创建当前当父不存在时会失败
            logger.error("创建文件目录");
        }
        String localFilePath = savePath.endsWith("/") ? savePath + fileName : savePath + File.separator + fileName;

        try (InputStream inputStream = HttpClients.createDefault().execute(new HttpGet(netUrl)).getEntity().getContent();
             FileOutputStream fos = new FileOutputStream(new File(localFilePath))) {
            //2、把输入流文件转换成文件
            int cache = 1024;//一次读1KB
            byte[] buffer = new byte[cache];
            int ch = 0;
            while ((ch = inputStream.read(buffer)) != -1) {
                fos.write(buffer, 0, ch);
            }
            fos.flush();
            logger.error("下载文件成功");
        } catch (Exception e) {
            log.error("下载文件失败：{}" + e.getMessage());
            localFilePath = null;
        }
        return localFilePath;
    }

    public static void main(String[] args) {

    }

}
