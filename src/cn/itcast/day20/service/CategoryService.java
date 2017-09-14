package cn.itcast.day20.service;

import java.util.List;

import cn.itcast.day20.domain.Category;

public interface CategoryService {
	//取得所有分类信息的方法
	List<Category> getAll() throws Exception;
}
