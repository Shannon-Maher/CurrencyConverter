package currencyConverter;

import java.text.DecimalFormat;
import java.util.Currency;

public class CurrencyConverter {
	public CurrencyLoader load = new CurrencyLoader();
	
	/*
	 * Constructor that checks to see if the ISO codes are valid
	 * @param srcCurrency the amount that requires to be converted
	 * @param srcCode the ISO of the source currency eg GBP for British Pounds
	 * @param targetCode the ISO of the target currency eg USD for Unitied States Dollars
	 */
	public CurrencyConverter(Double srcCurrency, String srcCode, String targetCode)
	{
		try
		{
			Currency trgCurrency = Currency.getInstance(targetCode);
			Currency srcCur = Currency.getInstance(srcCode);
		}
		catch(java.lang.IllegalArgumentException e)
		{
			//Catches exception if the ISO codes are not valid and then quites the program
			System.out.println("Invalid ISO country code, program will exit ");
			System.exit(0);
		}
		init(srcCode,targetCode,srcCurrency);
	}
	
	/*
	 * An  initiation method
	 * @param amount the amount that requires to be converted
	 * @param srcCode the ISO of the source currency eg GBP for British Pounds
	 * @param targetCode the ISO of the target currency eg USD for Unitied States Dollars
	 * 
	 */
	public void init(String srcCode,String targetCode,Double amount)
	{
		
		System.out.println(convert(srcCode,targetCode,amount));
	}
	
	/*
	 * A method that starts the conversion process
	 * @param amount the amount that requires to be converted
	 * @param srcCode the ISO of the source currency eg GBP for British Pounds
	 * @param targetCode the ISO of the target currency eg USD for Unitied States Dollars
	 * @return A string with the converted amount
	 */
	public String convert(String srcCode, String targetCode,Double amount)
	{
		currencyConverter.Currency aCurrency = null;
		try {
			aCurrency = findCurrency(targetCode);
		} catch (CurrencyNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		Double convertedAmount = amount * aCurrency.getValue();
		DecimalFormat formatCurrency = new DecimalFormat("##.00"); //formats the values to two decimal places
		return "Converted "+amount.toString() + " "+srcCode+" --> " +formatCurrency.format(convertedAmount.doubleValue())+ " ("+aCurrency.getCode()+")"+ " "+aCurrency.getName()+","+" "+aCurrency.getCountry();
	}
	
	/*Finds a currency in the text file
	 * @param code the target ISO currency code
	 * @return Currency An object that holds the information for the target currency 
	 */
	public currencyConverter.Currency findCurrency(String code) throws CurrencyNotFoundException
	{
		return load.findCurrencyByCode(code);
	}
	
	public static final void main(String[] args) {
		// TODO Auto-generated method stub
		Double srcCurrency = new Double(args[0]);

		CurrencyConverter currencyCnvrt = new CurrencyConverter(srcCurrency,args[1],args[2]);
	}

}
