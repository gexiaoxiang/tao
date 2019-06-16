package com.tao.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.druid.support.json.JSONParser;
import com.alibaba.druid.support.json.JSONUtils;
import com.tao.common.pojo.EUTreeNode;
import com.tao.service.impl.PicService;

@Controller
public class PicController {

	@Autowired
	private PicService picService;

	@RequestMapping("/pic/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile) {
		Map uploadPicture = picService.uploadPicture(uploadFile);
		System.out.println("上传成功");
		return JSONUtils.toJSONString(uploadPicture);

	}
}
