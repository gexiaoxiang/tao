package com.tao.service;

import com.tao.common.pojo.EUDataGridResult;
import com.tao.common.pojo.TaoResult;
import com.tao.pojo.TbItem;

public interface ItemService {

	TbItem getItbItemById(long item);

	EUDataGridResult getItemList(int page, int rows);

	TaoResult createItem(TbItem item);
}
