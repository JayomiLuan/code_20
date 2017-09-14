package cn.itcast.day20.dao.impl;

import cn.itcast.day20.dao.ProductDao;
import cn.itcast.day20.domain.Product;
import cn.itcast.day20.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
	
	//使用无参构造创建DBUtils的核心对象，用于执行SQL语句
	private QueryRunner queryRunner = new QueryRunner();
	
	@Override
	public void insert(Product product) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		String sql = "insert into tb_product(id,name,price,img_path,description) values(?,?,?,?,?)";
		queryRunner.update(conn, sql,
				product.getId(),
				product.getName(),
				product.getPrice(),
				product.getImg_path(),
				product.getDescription() );
		
	}

	@Override
	public void delete(String id) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		String sql = "delete from tb_product where id=?";
		queryRunner.update(conn, sql , id);
	}

	@Override
	public void update(Product product) throws Exception {
		Connection conn = JdbcUtils.getConnection();
		String sql = "update tb_product set name=?,price=?,img_path=?,description=? where id=?";
		queryRunner.update(conn, sql,
				product.getName(),
				product.getPrice(),
				product.getImg_path(),
				product.getDescription(), 
				product.getId() );
	}

	//按ID取得单个商品对象
	@Override
	public Product get(String id) throws Exception {
		
		Connection conn = JdbcUtils.getConnection();
		String sql = "select id,name,price,img_path,description,category_id from tb_product where id=?";
		Product product = (Product) queryRunner.query(conn, sql ,id , new BeanHandler(Product.class));
		
		return product;
	}

	@Override
	public List<Product> getAll() throws Exception {
		List<Product> list = null;
		//用当前线程取得对应的连接对象
		Connection conn = JdbcUtils.getConnection();
		String sql = "select id,name,price,img_path,description,category_id from tb_product";
		list = (List<Product>) queryRunner.query(conn, sql, new BeanListHandler(Product.class) );

		return list;
	}

}
