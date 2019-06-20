package com.tao.portal.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tao.common.pojo.TaoResult;
import com.tao.common.utils.HttpClientUtil;
import com.tao.portal.pojo.SearchResult;
import com.tao.portal.service.SearchService;



@Service
public class SearchServiceImpl implements SearchService {

	@Value("${SEARCH_BASE_URL}")
	private String SEARCH_BASE_URL;

	@Override
	public SearchResult search(String queryString, int page) {
		// 调用tao-search的服务
		// 查询参数
		Map<String, String> param = new HashMap<>();
		param.put("q", queryString);
		param.put("page", page + "");
		try {
			// 调用服务
			String json = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
			// 把字符串转换成java对象
			TaoResult taoResult = TaoResult.formatToPojo(json,
					SearchResult.class);
			if (taoResult.getStatus() == 200) {
				SearchResult result = (SearchResult) taoResult.getData();
				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
