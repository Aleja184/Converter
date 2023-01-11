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
        	boolean isNumeric = (amount != null && amount.matches("[0-9]+"));
        	if(!isNumeric) {
        		JOptionPane.showMessageDialog(null,"Invalid value.Only numbers");
        		continue;
        	}
        	double response = Request.response(currencyTo,currencyFrom,amount);
        	JOptionPane.showMessageDialog(null, response);
        	int confirm = JOptionPane.showConfirmDialog(null, "Do you want to continue?","Converter",JOptionPane.YES_NO_OPTION);
        	if(JOptionPane.NO_OPTION == confirm) {
        		confirmFrom = null;
        		break;
        	}
    	}
        	
    }
    
}
