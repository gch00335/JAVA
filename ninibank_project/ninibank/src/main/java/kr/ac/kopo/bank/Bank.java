package kr.ac.kopo.bank;

public class Bank {
	private String acc_num;
	private String id;
	private String bankcode;
	private String acpw;
	private String acmadedate;
	private String balance;
	private String ProductID;
	private String acName;
	

	

	public String getAcName() {
		return acName;
	}


	public void setAcName(String acName) {
		this.acName = acName;
	}


	public String getAcc_num() {
		return acc_num;
	}


	public void setAcc_num(String acc_num) {
		this.acc_num = acc_num;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getBankcode() {
		return bankcode;
	}


	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}


	public String getAcpw() {
		return acpw;
	}


	public void setAcpw(String acpw) {
		this.acpw = acpw;
	}


	public String getAcmadedate() {
		return acmadedate;
	}


	public void setAcmadedate(String acmadedate) {
		this.acmadedate = acmadedate;
	}


	public String getBalance() {
		return balance;
	}


	public void setBalance(String balance) {
		this.balance = balance;
	}


	public String getProductID() {
		return ProductID;
	}


	public void setProductID(String productID) {
		ProductID = productID;
	}


	public Bank(String acc_num, String id, String bankcode, String acpw, String acmadedate, String balance
	, String ProductID ,String acName) {
		super();
		this.acc_num = acc_num;
		this.id = id;
		this.bankcode = bankcode;
		this.acpw = acpw;
		this.acmadedate = acmadedate;
		this.ProductID = ProductID;
		this.balance = balance;
		this.acName = acName;
	}


	@Override
	public String toString() {
		return "Bank [acc_num=" + acc_num + ", id=" + id + ", bankcode=" + bankcode + ", acpw=" + acpw + ", acmadedate="
				+ acmadedate + ", balance=" + balance + ", ProductID=" + ProductID +", acName=" + acName +"]";
	}


	public Bank() {
		// TODO Auto-generated constructor stub
	}
	
}