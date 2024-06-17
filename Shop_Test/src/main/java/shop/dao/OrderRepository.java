package shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.dto.Order;
import shop.dto.Product;

public class OrderRepository extends JDBConnection {
	
	/**
	 * 주문 등록
	 * @param user
	 * @return
	 */
	public int insert(Order order) {
		int result = 0;
		try {
            String sql = "INSERT INTO orders (cartId, shipName, zipCode, country, address, date, userId, totalPrice, phone, orderPw) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, order.getCartId());
            psmt.setString(2, order.getShipName());
            psmt.setString(3, order.getZipCode());
            psmt.setString(4, order.getCountry());
            psmt.setString(5, order.getAddress());
            psmt.setString(6, order.getDate());
            psmt.setString(7, order.getUserId());
            psmt.setInt(8, order.getTotalPrice());
            psmt.setString(9, order.getPhone());
            psmt.setString(10, order.getOrderPw());
            result = psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
	}

	/**
	 * 최근 등록한 orderNo 
	 * @return
	 */
	public int lastOrderNo() {
		int lastOrderNo = 0;
        try {
            String sql = "SELECT MAX(orderNo) AS lastOrderNo FROM orders";
            psmt = con.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                lastOrderNo = rs.getInt("lastOrderNo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lastOrderNo;
	}

	
	/**
	 * 주문 내역 조회 - 회원
	 * @param userId
	 * @return
	 */
	public List<Product> list(String userId) {
		List<Product> productList = new ArrayList<>();
        try {
            String sql = "SELECT p.* FROM orders o JOIN products p ON o.productId = p.productId WHERE o.userId = ?";
            psmt = con.prepareStatement(sql);
            psmt.setString(1, userId);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getString("productId"));
                product.setName(rs.getString("name"));
                product.setUnitPrice(rs.getInt("unitPrice"));
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
	}
	
	/**
	 * 주문 내역 조회 - 비회원
	 * @param phone
	 * @param orderPw
	 * @return
	 */
	public List<Product> list(String phone, String orderPw) {
		List<Product> productList = new ArrayList<>();
	    try {
	        String sql = "SELECT p.* FROM orders o JOIN products p ON o.productId = p.productId WHERE o.phone = ? AND o.orderPw = ?";
	        psmt = con.prepareStatement(sql);
	        psmt.setString(1, phone);
	        psmt.setString(2, orderPw);
	        ResultSet rs = psmt.executeQuery();
	        while (rs.next()) {
	            Product product = new Product();
	            product.setProductId(rs.getString("productId"));
	            product.setName(rs.getString("name"));
	            product.setUnitPrice(rs.getInt("Unitprice"));
	            productList.add(product);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return productList;
		
	}
}





























