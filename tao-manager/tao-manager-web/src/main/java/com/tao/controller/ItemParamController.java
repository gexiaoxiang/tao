package com.tao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tao.common.pojo.TaoResult;
import com.tao.pojo.TbItem;
import com.tao.service.ItemParamService;

@Controller
public class ItemParamController {

	@Autowired
	private ItemParamService itemParamService;

	@RequestMapping("/query/itemcatid{itemCatId}")
	@ResponseBody
	public TaoResult getItemParamByCid(@PathVariable Long itemCatId) {
		TaoResult result = itemParamService.getItemParamByCid(itemCatId);
		return result;

	}

}
