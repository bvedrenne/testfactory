package fr.bvedrenne.testfactory;

import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.fluttercode.datafactory.impl.DataFactory;

public class AddressBuilder implements Builder {
	private boolean city = false;
	private boolean addressSuffix = false;
	private boolean streetNames = false;
	private Entry<Integer, Integer> streetNumber = null;

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

	public AddressBuilder withStreetNumber() {
		streetNumber = new Entry<Integer, Integer>() {
			@Override
			public Integer getKey() {
				return null;
			}

			@Override
			public Integer getValue() {
				return null;
			}

			@Override
			public Integer setValue(Integer value) {
				return null;
			}
		};
		return this;
	}

	public AddressBuilder withStreetNumber(int min, int max) {
		streetNumber = new Entry<Integer, Integer>() {
			@Override
			public Integer getKey() {
				return Math.min(min, max);
			}

			@Override
			public Integer getValue() {
				return Math.max(min, max);
			}

			@Override
			public Integer setValue(Integer value) {
				return Math.max(min, max);
			}
		};
		return this;
	}

	@Override
	public Factory<String> build() {
		return new AddressFactory(streetNumber, streetNames, city, addressSuffix);
	}

	private class AddressFactory implements Factory<String> {
		private boolean city = false;
		private boolean addressSuffix = false;
		private boolean streetNames = false;
		private Entry<Integer, Integer> streetNumber = null;
		private DataFactory dataFactory;

		public AddressFactory(Entry<Integer, Integer> streetNumber, boolean streetNames, boolean city,
				boolean addressSuffix) {
			this.streetNames = streetNames;
			this.city = city;
			this.addressSuffix = addressSuffix;
			this.streetNumber = streetNumber;

			dataFactory = DataFactory.createWithOriginalRandom();
		}

		@Override
		public String nextValue() {
			StringBuilder sb = new StringBuilder();
			if (streetNames) {
				Optional.ofNullable(streetNumber).ifPresent(bound -> {
					sb.append(ThreadLocalRandom.current().nextInt(bound.getKey(), bound.getValue() + 1));
					sb.append(" ");
				});
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
