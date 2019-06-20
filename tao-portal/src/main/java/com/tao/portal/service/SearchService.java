package com.tao.portal.service;

import com.tao.portal.pojo.SearchResult;

public interface SearchService {

	SearchResult search(String queryString, int page);
}
