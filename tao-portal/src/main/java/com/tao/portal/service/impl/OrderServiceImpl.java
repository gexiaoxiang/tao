package com.tao.portal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.tao.common.pojo.TaoResult;
import com.tao.common.utils.HttpClientUtil;
import com.tao.common.utils.JsonUtils;
import com.tao.portal.pojo.Order;
import com.tao.portal.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {
	
	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;
	

	@Override
	public String createOrder(Order order) {
		//调用创建订单服务之前补全用户信息。
		//从cookie中后取TT_TOKEN的内容，根据token调用sso系统的服务根据token换取用户信息。
		
		//调用tao-order的服务提交订单。
		String json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, JsonUtils.objectToJson(order));
		//把json转换成TaoResult
		TaoResult taoResult = TaoResult.format(json);
		if (taoResult.getStatus() == 200) {
			Object orderId = taoResult.getData();
			return orderId.toString();
		}
		return "";
	}

}