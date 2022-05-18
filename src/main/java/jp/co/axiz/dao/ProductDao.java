package jp.co.axiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.axiz.entity.Product;

/*
 * todoと書かれている場所に必要な処理を実装してください
 * また、エンティティ作成後、下記のimportのコメントを外してください
 */

//import jp.co.axiz.entity.Product;
import jp.co.axiz.util.ParamUtil;

/**
 * productsテーブル用DAO
 */
public class ProductDao {

    private static final String SELECT_ALL = "SELECT * FROM products";

    private static final String SELECT = "SELECT * FROM products WHERE ";

    private static final String ORDER_BY = " ORDER BY product_id";

    Connection con;

    public ProductDao(Connection con) {
        this.con = con;
    }

    /**
     * 全件取得
     */
    public List<Product> findAll() {

        List<Product> list = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(SELECT_ALL + ORDER_BY)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 条件を指定した検索
     */
    public List<Product> find(Product pd) {
        ArrayList<String> conditionList = new ArrayList<>();

        ArrayList<Object> paramList = new ArrayList<>();

        String productName = null;
        Integer price = null;

        if (pd != null) {
            productName = pd.getProductName();
            price = pd.getPrice();
        }

        if (ParamUtil.isNullOrEmpty(productName) && price == null) {
            return findAll();
        }

        if (!ParamUtil.isNullOrEmpty(productName)) {
            conditionList.add("product_name = ?");
            paramList.add(productName);
        }

        if (price != null) {
            conditionList.add("price = ?");
            paramList.add(price);
        }

        String whereString = String.join(" AND ", conditionList.toArray(new String[] {}));

        List<Product> list = new ArrayList<>();

        String sql = SELECT + whereString + ORDER_BY;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            for (int i = 0; i < paramList.size(); i++) {
                stmt.setObject(i + 1, paramList.get(i));
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Product product = new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
	            list.add(product);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}