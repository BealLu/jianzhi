package com.mydemo.common;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import lombok.Data;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@ToString
@Data
public class OSSTemplate {
    private String endpoint;
    private String bucketDomain;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String yuName=".oss-cn-beijing.aliyuncs.com";
    public String upload(InputStream inputStream,String fileName){
        ObjectMetadata objectMetadata=new ObjectMetadata();
        objectMetadata.setContentType("image/jpg");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String folderName = simpleDateFormat.format(new Date());
        fileName=UUID.randomUUID().toString().replace("-","")+fileName;
        //创建OSS实例
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        //上传
        ossClient.putObject(bucketName, "pic/"+folderName+"/"+fileName, inputStream,objectMetadata);
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ossClient.shutdown();
        System.out.println("上传成功");
        String url="http://"+bucketName+yuName+"/pic/"+folderName+"/"+fileName;
        return url;
    }
}
