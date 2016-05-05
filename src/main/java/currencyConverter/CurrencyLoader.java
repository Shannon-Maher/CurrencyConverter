package currencyConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CurrencyLoader {

	public CurrencyLoader()
	{
		
	
	}
	
	/*
	 * a method that finds by currency code
	 * @param code the pattern to match
	 * @return an object of currency that holds required info for the target currency
	 * @throws CurrencyNotFoundException
	 */
	public Currency findCurrencyByCode(String code) throws CurrencyNotFoundException
	{
		return loadCurrency("[\\w\\s]*,[ ]*[\\w\\s]*,[ ]*"+code+",[ ]*\\d.[\\d]*");
	}
	
	
	/*
	 * looks for a currency on file
	 * @param pattern looks for a regex pattern in the file
	 * @return an object of currency that holds required info for the target currency
	 * @throws CurrencyNotFoundException
	 */
	private Currency loadCurrency(String pattern) throws CurrencyNotFoundException
	{
		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("currency.txt").getFile());
		Currency aCurrency = new Currency();
		String[] foundCurrency = null;
		try {
			Scanner currencyScanner = new Scanner(file);
			Pattern currenyPattern = Pattern.compile(pattern);
			currencyScanner.useDelimiter(",");
			do
			{
			
				String found = ""+currencyScanner.findInLine(pattern);
				if(!found.equals("null"))
				{
					foundCurrency= found.split(",");
					aCurrency.setName(foundCurrency[0]);
					
					// Looks for the delimited info in file 
					for (int i=0; i<=foundCurrency.length;i++)
					{
						switch(i)
						{
						case 0:
							aCurrency.setCountry(foundCurrency[i]);
							break;
						case 1:
							aCurrency.setName(foundCurrency[i]);
							break;
						case 2:	
							aCurrency.setCode(foundCurrency[i].replaceAll(" ", ""));
							break;
						case 3:
							aCurrency.setValue(new Double(foundCurrency[i]));
							break;
						}
					}
						
				}
				
				if(currencyScanner.hasNextLine())
					currencyScanner.nextLine();
			}while(currencyScanner.hasNextLine());
			
			currencyScanner.close();
			if(null == foundCurrency)
				throw new CurrencyNotFoundException();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aCurrency;
	}
}
