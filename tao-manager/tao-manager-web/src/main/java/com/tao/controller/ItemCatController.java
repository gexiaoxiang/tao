package com.tao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tao.common.pojo.EUTreeNode;
import com.tao.pojo.TbItem;
import com.tao.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getCatList(
			@RequestParam(value = "id", defaultValue = "0") Long parentId) {
		List<EUTreeNode> catList = itemCatService.getCatList(parentId);
		return catList;

	}
}
