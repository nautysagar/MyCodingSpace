package string;


import org.testng.annotations.Test;



@Test
public class DeskillerTest {

	public void shouldCreateRandomText() {
	    //given
		NumberfiyTest faker = new NumberfiyTest();

	    //when
	    String result = faker.letterify("???");

	    //then
	 //   Assert.assertThat(result).matches("[a-z][a-z][a-z]");
	}
	
	public void shouldCreateRandomNumber() {
        //given
		NumberfiyTest faker = new NumberfiyTest();

        //when
        String result = faker.numerify("###");

        //then
      //  assertThat(result).matches("[0-9][0-9][0-9]");
    }

    public void shouldEmbedRandomNumberInText() {
        //given
    	NumberfiyTest faker = new NumberfiyTest();

        //when
        String result = faker.numerify("Test#");

        //then
       // assertThat(result).matches("Test[0-9]");
    }

    public void shouldEmbedRandomElementsInText() {
        //given
    	NumberfiyTest faker = new NumberfiyTest();

        //when
        String result = faker.bothify("Test?#");

        //then
        //assertThat(result).matches("Test[a-z][0-9]");
    }

}
