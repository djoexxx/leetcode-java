import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseIntegerQuestion7Tests extends ReverseIntegerQuestion7 {
  /*
    Example 1:
    Input: x = 123
    Output: 321

  Example 2:
    Input: x = -123
    Output: -321

  Example 3:
    Input: x = 120
    Output: 21

  Example 4:
    Input:  x = 1534236469
    Output:  9646324351
  */

  @Test(dataProvider = "reverse integer values")
  public void reverseIntegerTest(int original, int expected) {
    int reversed = reverse(original);

    assertThat(reversed)
            .as("ERROR: expected " + expected + ", not " + expected)
            .isEqualTo(expected);
  }

  @Test(dataProvider = "reverse integer values")
  public void reverseIntegerV2Test(int original, int expected) {
    int reversed = reverseV2(original);

    assertThat(reversed).as("ERROR: expected " + expected + ", not " + reversed).isEqualTo(expected);
  }

  @DataProvider(name = "reverse integer values")
  public Object[][] reverseIntegerValues() {
    return new Object[][] {
      {123, 321},
      {-123, -321},
      {120, 21},
      {1534236469, 0}
    };
  }
}
