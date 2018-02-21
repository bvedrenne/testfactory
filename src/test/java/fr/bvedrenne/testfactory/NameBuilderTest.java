package fr.bvedrenne.testfactory;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class NameBuilderTest {
	@Test
	public void buildTest() {
		NameBuilder builder = NameBuilder.getBuilder();
		Factory<String> build = builder.build();
		Assertions.assertThat(build.nextValue()).isEmpty();
		Assertions.assertThat(build.nextValue()).isEmpty();
		Assertions.assertThat(build.nextValue()).isEmpty();
	}

	@Test
	public void build2Test() {
		NameBuilder builder = NameBuilder.getBuilder().withFirstName();
		Factory<String> build = builder.build();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
	}

	@Test
	public void build3Test() {
		NameBuilder builder = NameBuilder.getBuilder().withFirstName().withName();
		Factory<String> build = builder.build();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
	}

	@Test
	public void build4Test() {
		NameBuilder builder = NameBuilder.getBuilder().withName();
		Factory<String> build = builder.build();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
		Assertions.assertThat(build.nextValue()).isNotEmpty();
	}
}
