package co.ke.bsl.pojo;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;


@JsonIgnoreProperties({ "valid" })
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	private String street;
	private String zipCode;
	private String city;
	private Country country = new Country();

	public Address(String street, String zipCode, String city, Country country) {
		super();
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
		this.country = country;
	}

	public Address() {
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	/*@JsonIgnore
	public boolean isValid() {
		if (StringUtils.isNullOrEmpty(street) || StringUtils.isNullOrEmpty(zipCode)
				|| StringUtils.isNullOrEmpty(city) || !country.isValid()) {
			return false;
		} else {
			return true;
		}
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}
}
