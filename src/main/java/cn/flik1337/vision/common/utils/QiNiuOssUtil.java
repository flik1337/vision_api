package cn.flik1337.vision.common.utils;


import cn.flik1337.vision.common.exception.Asserts;
import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;


import static cn.flik1337.vision.common.api.ResultCode.FILE_EMPTY;

@Component
@ConfigurationProperties(prefix = "qiniu")
public class QiNiuOssUtil {
    @Value("${qiniu.accessKey}")
    private String accessKey;
    @Value("${qiniu.secretKey}")
    private String secretKey;
    @Value("${qiniu.bucketName}")
    private String bucketName;

    byte[] getFileBytes(MultipartFile multipartFile) throws IOException {
        return multipartFile.getBytes();
    }

    public String generateRandomName(){

        return  IdUtil.simpleUUID();
    }

    public boolean fileUpload(MultipartFile multipartFile,String fileRandomName) {
        boolean isEmpty = multipartFile.isEmpty() || multipartFile.getSize() == 0;
        if (isEmpty){
            Asserts.fail(FILE_EMPTY);
            return false;
        }
        //构造一个带指定 Region 对象的配置类
        //region2为华南机房
        Configuration cfg = new Configuration(Region.region2());

        UploadManager uploadManager = new UploadManager(cfg);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = fileRandomName;
        try {
            byte[] uploadBytes = getFileBytes(multipartFile);
            ByteArrayInputStream byteInputStream=new ByteArrayInputStream(uploadBytes);

            Auth auth = Auth.create(accessKey, secretKey);
            String upToken = auth.uploadToken(bucketName);
            try {
                Response response = uploadManager.put(byteInputStream,key,upToken,null, null);
                //解析上传成功的结果
                ObjectMapper objectMapper = new ObjectMapper();

                DefaultPutRet putRet = objectMapper.readValue(response.bodyString(), DefaultPutRet.class);

                System.out.println(putRet.key);
                System.out.println(putRet.hash);
                return true;
            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                    //ignore
                }
            }
        } catch (IOException ex ) {
            //ignore
        }
        return false;
    }


}
