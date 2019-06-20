package com.tao.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tao.common.pojo.TaoResult;
import com.tao.portal.pojo.CartItem;

public interface CartService {

	TaoResult addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response);
	List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);
	TaoResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}
