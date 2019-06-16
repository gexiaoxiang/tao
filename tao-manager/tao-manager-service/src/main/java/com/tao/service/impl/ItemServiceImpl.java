package com.tao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tao.common.pojo.EUDataGridResult;
import com.tao.common.pojo.TaoResult;
import com.tao.common.utils.IDUtils;
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

	@Override
	public EUDataGridResult getItemList(int page, int rows) {

		TbItemExample example=new TbItemExample();
		
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		
		EUDataGridResult result=new EUDataGridResult();
		
		result.setRows(list);
		PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(list);
		result.setTotal(pageInfo.getTotal());
		
		return result;
	}

	@Override
	public TaoResult createItem(TbItem item) {
		long itemId = IDUtils.genItemId();
		item.setId(itemId);
		item.setStatus((byte)1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		itemMapper.insert(item);
		
		return TaoResult.ok();
	}

}
