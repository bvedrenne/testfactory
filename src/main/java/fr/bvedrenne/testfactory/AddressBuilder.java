package fr.bvedrenne.testfactory;

import org.fluttercode.datafactory.impl.DataFactory;

public class AddressBuilder {
	private boolean city = false;
	private boolean addressSuffix = false;
	private boolean streetNames = false;

	private AddressBuilder() {
	}

	public static AddressBuilder getBuilder() {
		return new AddressBuilder();
	}

	public AddressBuilder withCity() {
		city = true;
		return this;
	}

	public AddressBuilder withAddressSuffix() {
		addressSuffix = true;
		return this;
	}

	public AddressBuilder withStreetName() {
		streetNames = true;
		return this;
	}

	public Factory<String> build() {
		return new AddressFactory(streetNames, city, addressSuffix);
	}

	private class AddressFactory implements Factory<String> {
		private boolean city = false;
		private boolean addressSuffix = false;
		private boolean streetNames = false;
		private DataFactory dataFactory;

		public AddressFactory(boolean streetNames, boolean city, boolean addressSuffix) {
			this.streetNames = streetNames;
			this.city = city;
			this.addressSuffix = addressSuffix;

			dataFactory = DataFactory.createWithOriginalRandom();
		}

		@Override
		public String nextValue() {
			System.out.println(dataFactory.getAddress());
			StringBuilder sb = new StringBuilder();
			if (streetNames) {
				sb.append(4);
				sb.append(" ");
				sb.append(dataFactory.getStreetName());
				if (addressSuffix) {
					sb.append(" ");
					sb.append(dataFactory.getStreetSuffix());
				}
				sb.append("\n");
			}
			if (city) {
				sb.append(dataFactory.getCity());
				sb.append("\n");
			}
			return sb.toString();
		}

	}
}
