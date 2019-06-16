package com.tao.service.impl;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface PicService {

	Map uploadPicture(MultipartFile file) ;
}
