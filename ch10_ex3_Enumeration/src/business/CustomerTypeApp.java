package business;

import static business.CustomerType.*;

public class CustomerTypeApp {

    public static void main(String[] args) {
        // display a welcome message
        System.out.println("Welcome to the Customer Type Test application\n");

        // get and display the discount percent for a customer type
        CustomerType newCust = CustomerType.RETAIL;
        
        // display the value of the toString method of a customer type
        System.out.println("disc % = "+getDiscountPct(newCust));
        System.out.println("toString() = "+newCust);
    }

    // a method that accepts a CustomerType enumeration
    private static double getDiscountPct(CustomerType ct) {
    	double disc = 0.0;
    	if (ct==RETAIL) {
    		disc = .1;
    	}
    	else if (ct==TRADE) {
    		disc = .3;
    	}
    	else if (ct==COLLEGE) {
    		disc = .2;
    	}
    	return disc;
    }
}
