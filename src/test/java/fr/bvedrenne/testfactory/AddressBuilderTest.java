package fr.bvedrenne.testfactory;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AddressBuilderTest {

	@Test
	public void buildTest() {
		AddressBuilder builder = AddressBuilder.getBuilder();
		Factory<String> build = builder.build();
		Assertions.assertThat(build.nextValue()).isEmpty();
		Assertions.assertThat(build.nextValue()).isEmpty();
		Assertions.assertThat(build.nextValue()).isEmpty();
	}

	@Test
	public void build2Test() {
		AddressBuilder builder = AddressBuilder.getBuilder().withCity();
		Factory<String> build = builder.build();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
	}

	@Test
	public void build3Test() {
		AddressBuilder builder = AddressBuilder.getBuilder().withCity().withStreetName();
		Factory<String> build = builder.build();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
	}

	@Test
	public void build4Test() {
		AddressBuilder builder = AddressBuilder.getBuilder().withCity().withStreetName().withAddressSuffix();
		Factory<String> build = builder.build();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
	}
}