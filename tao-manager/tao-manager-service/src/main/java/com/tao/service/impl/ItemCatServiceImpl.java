package com.tao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tao.common.pojo.EUTreeNode;
import com.tao.mapper.TbItemCatMapper;
import com.tao.pojo.TbItemCat;
import com.tao.pojo.TbItemCatExample;
import com.tao.pojo.TbItemCatExample.Criteria;
import com.tao.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatMapper ItemCatService;

	@Override
	public List<EUTreeNode> getCatList(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();

		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = ItemCatService.selectByExample(example);
		List<EUTreeNode> reTreeNodes = new ArrayList<EUTreeNode>();

		for (TbItemCat tbItemCat : list) {
			EUTreeNode euTreeNode = new EUTreeNode();
			euTreeNode.setId(tbItemCat.getId());
			euTreeNode.setText(tbItemCat.getName());
			euTreeNode.setState(tbItemCat.getIsParent() ? "closed" : "open");
			reTreeNodes.add(euTreeNode);
		}
		return reTreeNodes;
	}

	
}
