package store.DTO;


/**
 * 상품
 * - 상품아이디
 * - 상품명
 * - 가격
 * - 재고
 * 
 *
 */
public class Product {
	
	private String productId;
	private String name;
	private int price;
	private int count;
	
	private String filePath;
	
	public Product() {
		
	}
	
	
	public Product(String productId, String name, int price, int count) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.count = count;
	}
	
	
	public Product(String productId, String name, int price, int count, String filePath) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.count = count;
		this.filePath= filePath;
	}



	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", count=" + count
				+ ", filePath=" + filePath + "]";
	}
	
	
	
	
}
