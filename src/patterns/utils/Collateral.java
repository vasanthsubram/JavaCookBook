package patterns.utils;

public class Collateral {

	private String state;
	private Money collateralValue;
	private LoanObject loan;
	
	public Collateral(){
	}
	
	public Collateral(LoanObject loan){
		this.loan=loan;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Money getCollateralValue() {
		return collateralValue;
	}
	public void setCollateralValue(Money collateralValue) {
		this.collateralValue = collateralValue;
	}
	public LoanObject getLoan() {
		return loan;
	}
	public void setLoan(LoanObject loan) {
		this.loan = loan;
	} 
}
