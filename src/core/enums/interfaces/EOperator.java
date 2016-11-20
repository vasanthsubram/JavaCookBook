package core.enums.interfaces;

public enum EOperator implements Operator {

	SUM {
		@Override
		public int calculate(int firstOperand, int secondOperand) {
			return firstOperand + secondOperand;
		}
	},
	SUBTRACT {
		@Override
		public int calculate(int firstOperand, int secondOperand) {
			return firstOperand - secondOperand;
		}
	};
}