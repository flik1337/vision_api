package cn.flik1337.vision.service.impl;

import cn.flik1337.vision.common.api.CommonResult;
import cn.flik1337.vision.common.utils.QiNiuOssUtil;
import cn.flik1337.vision.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import static cn.flik1337.vision.common.api.ResultCode.OSS_WRONG;

@Service
@Transactional
public class OssServiceImpl implements OssService {
    private static String SPLIT = "@";
    @Autowired
    private QiNiuOssUtil ossUtil;

    @Override
    public String uploadSingleFile(MultipartFile file) {
        String fileName = ossUtil.generateRandomName();
        boolean uploaded = ossUtil.fileUpload(file,fileName);
        if (uploaded){
            // 上传成功，返回文件名
            return fileName;
        }
        return null;
    }
    @Override
    public String uploadMultiFile(MultipartFile[] files) {
        String allFileNames = "";

        for (MultipartFile file : files){
            String fileName = ossUtil.generateRandomName();
            boolean uploaded = ossUtil.fileUpload(file,fileName);
            if (uploaded){
                // 上传成功，返回文件名
                allFileNames = allFileNames + fileName + SPLIT;
                continue;
            }
            return null;
        }
        if (allFileNames.indexOf(SPLIT) != -1){
            allFileNames = allFileNames.substring(0,allFileNames.length()-1);
        }
        return allFileNames;

    }
}
