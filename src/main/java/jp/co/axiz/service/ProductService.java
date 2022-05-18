package jp.co.axiz.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import jp.co.axiz.dao.ProductDao;
import jp.co.axiz.entity.Product;
import jp.co.axiz.util.DbUtil;

public class ProductService{
	public ProductService() {
		
	}
	
	public List<Product> authentication(Product product) {
		try (Connection connection = DbUtil.getConnection()) {
			ProductDao productDao = new ProductDao(connection);
			List<Product> list = new ArrayList<>();
			
			list = productDao.find(product);
			
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}
}