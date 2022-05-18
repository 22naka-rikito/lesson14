package service;

import java.sql.Connection;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class ProductService{
	public ProductService() {
		
	}
	
	public Product authentication(Integer id) {
		try (Connection connection = DbUtil.getConnection()) {
			ProductDao productDao = new ProductDao(connection);
			Product product = productDao.fintdByProductId(id);

            return product;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
}