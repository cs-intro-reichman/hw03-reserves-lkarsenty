public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter = 1;    // Monitors the efficiency of the calculation
	

	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
		

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
    	double payment = loan / n + epsilon ;
		iterationCounter = 0;
		while (endBalance(loan, rate , n , payment) > 0) {
			iterationCounter ++;
			payment = payment + 0.01;
		}

    	return payment;

    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
    	iterationCounter = 0;

		double l = loan / n;
		double h = loan * 1.5;
		double payment = (l + h)/2;

      	while (h - l > epsilon) {
         if (endBalance(loan, rate, n, payment) * endBalance(loan, rate, n, l) > 0)
            l = payment;
         else
            h = payment;
         payment = (l + h) / 2;
         iterationCounter ++;
      	}

    	return payment;
    }
	
	//the function
	private static double endBalance(double loan, double rate, int n, double payment) {
		double balance = loan;
		for (int i = 0; i < n ; i++) {

  			balance = (balance - payment) * (1 + (0.01 * rate));

		}
    	return balance;
	}
}
