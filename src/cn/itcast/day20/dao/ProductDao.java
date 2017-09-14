package cn.itcast.day20.dao;

import java.util.List;

import cn.itcast.day20.domain.Product;

public interface ProductDao {
	void insert( Product product ) throws Exception;
	void delete(String id) throws Exception;
	void update( Product product ) throws Exception;
	Product get(String id) throws Exception;
	List<Product> getAll()  throws Exception;
}
