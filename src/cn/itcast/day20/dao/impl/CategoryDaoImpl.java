package cn.itcast.day20.dao.impl;

import cn.itcast.day20.dao.CategoryDao;
import cn.itcast.day20.domain.Category;
import cn.itcast.day20.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

	private QueryRunner queryRunner = new QueryRunner();
	
	@Override
	public List<Category> getAll() throws Exception {
		List<Category> list ;
		Connection conn = JdbcUtils.getConnection();
		String sql = "select id,name from tb_category";
		list = queryRunner.query(conn,sql, new BeanListHandler<>(Category.class) );
		
		return list;
	}

}
