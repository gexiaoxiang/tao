package com.tao.service;

import java.util.List;

import com.tao.common.pojo.EUTreeNode;

public interface ItemCatService {

	List<EUTreeNode> getCatList(long parentId);
}
