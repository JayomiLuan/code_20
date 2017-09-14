package cn.itcast.day20.service;

import java.util.List;

import cn.itcast.day20.domain.Product;

public interface ProductService {
	void add( Product product ) throws Exception;
	void delete( String id ) throws Exception;
	void modify( Product product ) throws Exception;
	Product get( String id ) throws Exception;
	List<Product> getAll() throws Exception;
}
