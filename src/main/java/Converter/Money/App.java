package Converter.Money;
import javax.swing.JOptionPane;


public class App 
{
    public static void main( String[] args )
    {
    	String confirmFrom = "";
    	while(confirmFrom != null) {
    		String currencyFrom = Currency.ChooseCurrency("From");
        	try {
        		currencyFrom = Currency.Symbols(currencyFrom);	
			} catch (Exception e) {
				confirmFrom = null;
				break;
			}
        	String currencyTo = Currency.ChooseCurrency("To");
        	if(currencyTo == null) {
        		continue;
        	}
        	currencyTo = Currency.Symbols(currencyTo);
        	String amount = JOptionPane.showInputDialog("Amount");
        	if(amount == null) {
        		continue;
        	}
        	double response = Request.response(currencyTo,currencyFrom,amount);
        	JOptionPane.showMessageDialog(null, response);
    	}
    	
    	
    	
    }
    
}
