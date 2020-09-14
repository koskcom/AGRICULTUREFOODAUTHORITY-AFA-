package co.ke.bsl.pojo;


import java.util.ArrayList;

public class CountriesList extends ArrayList<Country> {
	private static final long serialVersionUID = 1L;

	public CountriesList() {
		super();
		//initialize();
	}

	/**
	 * Hidden constructor.
	 *//*
	@SuppressWarnings("unused")
	private CountriesList(Collection<? extends Country> collection) {
		throw new UnsupportedOperationException();
	}

	*//**
	 * Hidden constructor.
	 *//*
	@SuppressWarnings("unused")
	private CountriesList(int capacity) {
		throw new UnsupportedOperationException();
	}

	private void initialize() {
		for (Locale locale : Locale.getAvailableLocales()) {
			String name = locale.getDisplayCountry();
			String iso2 = locale.getCountry();

			Country country = new Country(name, iso2);

			if (!iso2.equals("") && !contains(country)) {
				add(country);
			}
		}

		Collections.sort(this, new CountryComparator());
	}

	private class CountryComparator implements Comparator<Country> {
		@Override
		public int compare(Country country1, Country country2) {
			return country1.getDisplayName().compareTo(
					country2.getDisplayName());
		}
	}*/
}
