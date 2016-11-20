package patterns.utils;
import java.math.*;



public class Money {

		private static RoundingMode DEFAULT_ROUND = RoundingMode.HALF_EVEN;
		private static int DEFAULT_SCALE = 2;
		public static Money zeroDollar=new Money(0.00);
		
		private BigDecimal amount;
		
		public Money(){
			amount = new BigDecimal(0).setScale(DEFAULT_SCALE, DEFAULT_ROUND);
		}
		public Money(String s){
			amount = new BigDecimal(s).setScale(DEFAULT_SCALE, DEFAULT_ROUND);
		}
		
		public Money(int i){
			amount = new BigDecimal(i).setScale(DEFAULT_SCALE, DEFAULT_ROUND);
		}
		
		public Money(long l){
			amount = new BigDecimal(l).setScale(DEFAULT_SCALE, DEFAULT_ROUND);
		}
		
		public Money(float f){
			amount = new BigDecimal(f).setScale(DEFAULT_SCALE, DEFAULT_ROUND);
		}
		
		public Money(double d){
			amount = new BigDecimal(d).setScale(DEFAULT_SCALE, DEFAULT_ROUND);
		}
		
		public Money(BigDecimal bigD){
			amount = bigD.setScale(DEFAULT_SCALE, DEFAULT_ROUND);
		}
		
		public BigDecimal getAmount(){
			return amount;
		}
		
		public Money add(Money m){
			BigDecimal sum = this.getAmount().add(m.getAmount());
			return new Money(sum);
		}
		
		public Money subtract(Money m){
			BigDecimal diff = this.getAmount().subtract(m.getAmount());
			return new Money(diff);
		}
		
		public Money multiply(Money m){
			BigDecimal prod = this.getAmount().multiply(m.getAmount());
			return new Money(prod);
		}
		
		public Money divide(Money m) throws ArithmeticException{
			int precision = m.getAmount().precision()+ this.getAmount().precision();
			BigDecimal quo = this.getAmount().divide(m.getAmount(), new MathContext(precision,DEFAULT_ROUND));
			return new Money(quo);
		}
		
		public String toString(){
			return ("$"+this.amount.toString());
		}
		
		public boolean equals(Object another){
			if(another instanceof Money){
				return amount.equals(((Money)another).getAmount());
			}
			return false;
		}
		
		public int hashCode(){
			return (this.amount.hashCode());
		}
}
