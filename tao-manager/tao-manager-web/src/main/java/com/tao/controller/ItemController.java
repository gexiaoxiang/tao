package com.tao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tao.common.pojo.EUDataGridResult;
import com.tao.pojo.TbItem;
import com.tao.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long  itemId){
		TbItem tbItem=itemService.getItbItemById(itemId);
		return tbItem;
		
	}
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemById(Integer page ,Integer rows){
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
		
	}
}
