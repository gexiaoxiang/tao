package com.tao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tao.mapper.TbItemMapper;
import com.tao.pojo.TbItem;
import com.tao.pojo.TbItemExample;
import com.tao.pojo.TbItemExample.Criteria;
import com.tao.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService{
@Autowired
private TbItemMapper itemMapper;
	
	@Override
	public TbItem getItbItemById(long item) {
		TbItemExample example=new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(item);
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
