package fr.bvedrenne.testfactory;

import org.junit.Test;

public class AddressBuilderTest {

	@Test
	public void buildTest() {
		AddressBuilder builder = AddressBuilder.getBuilder();
		Factory<String> build = builder.build();
		System.out.println(build.nextValue());
		System.out.println(build.nextValue());
		System.out.println(build.nextValue());
	}

	@Test
	public void build2Test() {
		AddressBuilder builder = AddressBuilder.getBuilder().withCity();
		Factory<String> build = builder.build();
		System.out.println(build.nextValue());
		System.out.println(build.nextValue());
		System.out.println(build.nextValue());
	}

	@Test
	public void build3Test() {
		AddressBuilder builder = AddressBuilder.getBuilder().withCity().withStreetName();
		Factory<String> build = builder.build();
		System.out.println(build.nextValue());
		System.out.println(build.nextValue());
		System.out.println(build.nextValue());
	}

	@Test
	public void build4Test() {
		AddressBuilder builder = AddressBuilder.getBuilder().withCity().withStreetName().withAddressSuffix();
		Factory<String> build = builder.build();
		System.out.println(build.nextValue());
		System.out.println(build.nextValue());
		System.out.println(build.nextValue());
	}
}