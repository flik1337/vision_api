package cn.flik1337.vision.service;

import cn.flik1337.vision.common.api.CommonResult;
import org.springframework.web.multipart.MultipartFile;


public interface OssService {

    public CommonResult uploadSingleFile(MultipartFile file);
}
