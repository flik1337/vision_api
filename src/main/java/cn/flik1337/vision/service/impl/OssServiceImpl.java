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

    @Autowired
    private QiNiuOssUtil ossUtil;

    @Override
    public CommonResult uploadSingleFile(MultipartFile file) {
        boolean uploaded = ossUtil.fileUpload(file,ossUtil.generateRandomName());
        if (uploaded){
            return CommonResult.success();
        }
        return CommonResult.failed(OSS_WRONG);
    }
}
