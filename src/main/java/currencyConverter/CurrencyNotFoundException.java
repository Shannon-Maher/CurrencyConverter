package currencyConverter;

public class CurrencyNotFoundException extends Exception{

	public CurrencyNotFoundException()
	{
		super("Currency Code not found on file");
	}
}
