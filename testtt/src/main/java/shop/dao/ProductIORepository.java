package shop.dao;

import java.sql.SQLException;

import shop.dto.Product;

public class ProductIORepository extends JDBConnection {

	/**
	 * 상품 입출고 등록
	 * @param product
	 * @param type
	 * @return
	 */
	public int insert(Product product, String type) {
        String sql = "INSERT INTO product_io (product_id, type) VALUES (?, ?)";
        int result = 0;

        try {
            psmt = con.prepareStatement(sql);
            
            psmt = con.prepareStatement(sql);
            psmt.setString(1, product.getProductId());
            psmt.setString(2, type);

            result = psmt.executeUpdate();
            
            if(result > 0) {
	            return result;
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("상품 등록 오류");
		}
			return result;
    }
}
	