package Converter.Money;
import javax.swing.JOptionPane;

public class Currency {
	static String[] currencies = {
			"Dollar",
			"Euro",
			"Colombian Peso",
			"Japanese Yen",
			"British Pound Sterling",
			"South Korean Won"
	};
	
	public static String ChooseCurrency(String title) {
		String resp = (String) JOptionPane.showInputDialog(null,title,"Currency",JOptionPane.DEFAULT_OPTION,null,currencies,currencies[0]);
		return resp;
	}
	
	public static String Symbols(String currency) {
		switch (currency) {
		case "Dollar":
			return "USD";
		case "Euro":
			return "EUR";
		case "Colombian Peso":
			return "COP";
		case "Japanese Yen":
			return "JPY";
		case "British Pound Sterling":
			return "GBP";
		case "South Korean Won":
			return "KRW";
		default:
			return null;
		}
	}

}
