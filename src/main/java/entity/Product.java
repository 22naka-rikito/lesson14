package entity;

public class Product{
	private Integer productId;
	private String productName;
	private Integer price;
	
	public Product(Integer productId,String productName, Integer price) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	
	public Product(String productName, Integer price) {
		this.productName = productName;
		this.price = price;
	}
	
	public Integer getProductId() {
		return this.productId;
	}
	
	public void setProductId(Integer puroductId) {
		this.productId = puroductId;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Integer getprice() {
		return this.price;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
}