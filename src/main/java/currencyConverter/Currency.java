package currencyConverter;

public class Currency {

	private String country = "";
	private String name = "";
	private String code = "";
	private Double value = null;

	
	public Currency()
	{
		
	}

	/*
	 * gets a country name
	 * @return a country
	 */
	public String getCountry()
	{
		return country;
	}

	/*Sets a country name
	 * @param name country name
	 */
	public void setCountry(String country)
	{
		this.country = country;
	}
	/*
	 * gets a currency Name
	 * @return get currency name
	 */
	public String getName() {
		return name;
	}

	/*
	 * sets a currency Name
	 * @param name a currency name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*gets a currency name
	 * @return a currency name
	 */
	public String getCode() {
		return code;
	}

	/*ISO currency code
	 * @param code a currency code
	 * 
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/*the value of the currency
	 * @return the value of the currency
	 */
	public Double getValue() {
		return value;
	}

	/*
	 * sets the value of the currency
	 * @param value currency value
	 */
	public void setValue(Double value) {
		this.value = value;
	}

	
	
}
