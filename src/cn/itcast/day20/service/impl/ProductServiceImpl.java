package cn.itcast.day20.service.impl;

import cn.itcast.day20.dao.ProductDao;
import cn.itcast.day20.dao.impl.ProductDaoImpl;
import cn.itcast.day20.domain.Product;
import cn.itcast.day20.service.ProductService;
import cn.itcast.day20.utils.JdbcUtils;

import java.sql.Connection;
import java.util.List;

public class ProductServiceImpl implements ProductService {

	//持有Dao的实现类的对象，使于调用
	private ProductDao productDao = new ProductDaoImpl();
	
	@Override
	public void add(Product product) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		try{
			conn.setAutoCommit(false);
			productDao.insert(product);
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			JdbcUtils.releaseResource(conn);
		}
	}

	@Override
	public void delete(String id) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		try{
			conn.setAutoCommit(false);
			productDao.delete(id);
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			JdbcUtils.releaseResource(conn);
		}
	}

	@Override
	public void modify(Product product) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		try{
			conn.setAutoCommit(false);
			productDao.update(product);
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			JdbcUtils.releaseResource(conn);
		}
	}

	@Override
	public Product get(String id) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		Product product = null;
		try{
			conn.setAutoCommit(false);
			product = productDao.get(id);
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			JdbcUtils.releaseResource(conn);
		}
		return product;
	}

	@Override
	public List<Product> getAll() throws Exception {
		List<Product> list = null;
		Connection conn = null;
		try{
			//用当前线程取得对应的Connection对象
			conn = JdbcUtils.getConnection();
			//开启事务
			conn.setAutoCommit(false);
			//调用Dao
			list = productDao.getAll();
			//提交
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			//回滚
			conn.rollback();
		}finally{
			//释放资源
			JdbcUtils.releaseResource(conn);
		}
		
		return list;
	}

}
