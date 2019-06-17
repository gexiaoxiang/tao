package com.tao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tao.common.pojo.TaoResult;
import com.tao.mapper.TbItemParamMapper;
import com.tao.pojo.TbItemParam;
import com.tao.pojo.TbItemParamExample;
import com.tao.pojo.TbItemParamExample.Criteria;
import com.tao.service.ItemParamService;

@Service
public class ItemParamServiceImpl implements ItemParamService {
	@Autowired
	private TbItemParamMapper itemParamMapper;

	@Override
	public TaoResult getItemParamByCid(long id) {
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(id);
		List<TbItemParam> list = itemParamMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			return TaoResult.ok(list);
		}

		return TaoResult.ok();
	}

}
