package com.tao.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.aspectj.weaver.IUnwovenClassFile;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tao.common.utils.FtpUtil;
import com.tao.common.utils.IDUtils;

@Service
public class PicServiceImpl implements PicService {

	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_POSRT}")
	private Integer FTP_POSRT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_ERL}")
	private String IMAGE_BASE_ERL;

	@Override
	public Map uploadPicture(MultipartFile file)  {
		Map resultMap = new HashMap();
		String newName = "";
		String string="";
		try {
			String oldName = file.getOriginalFilename();
			newName = IDUtils.genImageName();
			newName = newName + oldName.substring(oldName.lastIndexOf("."));
			 string = new DateTime().toString("/yyyy/MM/dd");
			boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_POSRT,
					FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH,
					string, newName,
					file.getInputStream());
			if (!result) {
				resultMap.put("error", 1);
				resultMap.put("message", "文件上传失败");
				return resultMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultMap.put("error", 0);
		resultMap.put("url", IMAGE_BASE_ERL +string+"/"+ newName);
		return resultMap;
	}
}
