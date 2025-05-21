import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringToIntegerAtoiQuestion8Tests extends StringToIntegerAtoiQuestion8 {

  @Test(dataProvider = "string to int atoi")
  public void myAtoiTest(String s, int expected) {
    int converted = myAtoi(s);

    assertThat(converted)
        .as("Converted: " + converted + "    Expected: " + expected)
        .isEqualTo(expected);
  }

  @DataProvider(name = "string to int atoi")
  public Object[][] stringToAtoi() {
    return new Object[][] {
      {"123456", 123456},
      {"99999999999", Integer.MAX_VALUE},
      {"-123456", -123456},
      {"-99999999999999", Integer.MIN_VALUE},
      {"1234cdfa1324", 1234},
      {"00000001234", 1234},
      {"1234.432q5435345354343543", 1234},
      {"-042", -42},
      {"+", 0},
      {" ", 0},
      {"9223372036854775808", 2147483647}
    };
  }
}
