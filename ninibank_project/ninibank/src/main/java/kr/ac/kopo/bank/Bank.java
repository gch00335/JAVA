package kr.ac.kopo.bank;

public class Bank {
	private String acc_num;
	private String id;
	private String bankcode;
	private String acpw;
	private String acmadedate;
	private String acmadedate2;
	private String balance;
	private String memberName;
	private String accountName;
	
	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public String getAcmadedate2() {
		return acmadedate2;
	}


	public void setAcmadedate2(String acmadedate2) {
		this.acmadedate2 = acmadedate2;
	}


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


	public Bank(String acc_num, String id, String bankcode, String acpw, String acmadedate, String acmadedate2, String balance
	, String ProductID ,String acName , String memberName, String accountName ) {
		super();
		this.acc_num = acc_num;
		this.id = id;
		this.bankcode = bankcode;
		this.acpw = acpw;
		this.acmadedate = acmadedate;
		this.acmadedate2 = acmadedate2;
		this.ProductID = ProductID;
		this.balance = balance;
		this.acName = acName;
		this.memberName = memberName;
		this.accountName = accountName;
	}
	


	@Override
	public String toString() {
		return "Bank [acc_num=" + acc_num + ", id=" + id + ", bankcode=" + bankcode + ", acpw=" + acpw + ", acmadedate="
				+ acmadedate + ",acmadedate2="+ acmadedate2+ ", balance=" + balance + ", ProductID=" + ProductID +",accountName= " + accountName +",  memberName =" + memberName +", acName=" + acName +"]";
	}


	public Bank() {
		// TODO Auto-generated constructor stub
	}
	
}