package kr.ac.kopo.product;

public class Product {
	private Integer productID ;// 상품ID
	private String	productName; //상품명
	private Integer interestRate; // 이자율
	private Integer minimumBalance; //최소금액


 public Integer getProductID() {
	return productID;
}
public void setProductID(Integer productID) {
	this.productID = productID;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public Integer getInterestRate() {
	return interestRate;
}
public void setInterestRate(Integer interestRate) {
	this.interestRate = interestRate;
}
public Integer getMinimumBalance() {
	return minimumBalance;
}
public void setMinimumBalance(Integer minimumBalance) {
	this.minimumBalance = minimumBalance;
} 

}


