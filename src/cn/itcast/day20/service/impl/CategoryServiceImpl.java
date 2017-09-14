package cn.itcast.day20.service.impl;

import java.sql.Connection;
import java.util.List;

import cn.itcast.day20.dao.CategoryDao;
import cn.itcast.day20.dao.impl.CategoryDaoImpl;
import cn.itcast.day20.domain.Category;
import cn.itcast.day20.service.CategoryService;
import cn.itcast.day20.utils.JdbcUtils;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao = new CategoryDaoImpl();
	
	@Override
	public List<Category> getAll() throws Exception {
		Connection conn = null;
		List<Category> list = null;
		
		try{
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			
			list = categoryDao.getAll();
			
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}finally{
			JdbcUtils.releaseResource(conn);
		}
		
		return list;
	}

}
