package fr.bvedrenne.testfactory;

import org.fluttercode.datafactory.impl.DataFactory;

public class NameBuilder implements Builder {
	private boolean name;
	private boolean firstname;

	private NameBuilder() {
	}

	public static final NameBuilder getBuilder() {
		return new NameBuilder();
	}

	public NameBuilder withName() {
		name = true;
		return this;
	}

	public NameBuilder withFirstName() {
		firstname = true;
		return this;
	}

	@Override
	public Factory<String> build() {
		return new NameFactory(firstname, name);
	}

	private class NameFactory implements Factory<String> {
		private boolean name;
		private boolean firstname;
		private DataFactory dataFactory;

		public NameFactory(boolean firstname, boolean name) {
			this.firstname = firstname;
			this.name = name;

			dataFactory = DataFactory.createWithOriginalRandom();
		}

		@Override
		public String nextValue() {
			StringBuilder sb = new StringBuilder();
			if (firstname) {
				sb.append(dataFactory.getFirstName());
				if (name) {
					sb.append(" ");
					sb.append(dataFactory.getLastName());
				}
			}
			if (name) {
				sb.append(dataFactory.getLastName());
			}
			return sb.toString();
		}
	}

}
