package patterns.utils;


public class LoanObject {

	private Money loanAmount;
	private Collateral loanCollateral;
	
	public LoanObject(){
		setLoanCollateral(new Collateral(this));
	}
	public LoanObject(Money amount, String state){
		this();
		loanAmount = amount;
		setLoanState(state);
	}
	
	
	public String getLoanState(){
		return getLoanCollateral().getState();
	}
	
	public void setLoanState(String state){
		getLoanCollateral().setState(state);
	}
	public Money getLoanAmount(){
		return loanAmount;
	}
	
	public void setLoanAmount(Money anAmount){
		loanAmount = anAmount;
	}


	public Collateral getLoanCollateral() {
		return loanCollateral;
	}


	public void setLoanCollateral(Collateral loanCollateral) {
		this.loanCollateral = loanCollateral;
	}
}
