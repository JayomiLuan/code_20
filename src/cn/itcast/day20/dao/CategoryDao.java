package cn.itcast.day20.dao;

import java.util.List;

import cn.itcast.day20.domain.Category;

public interface CategoryDao {
	List<Category> getAll() throws Exception;
}
