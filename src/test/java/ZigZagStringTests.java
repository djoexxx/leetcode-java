import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class ZigZagStringTests extends ZigZagString {

  @Test(dataProvider = "zig zag data")
  public void ZigZagTest(String originalString, int rows, String zigZagString) {
    String convertedString = zigZag(originalString, rows);

    assertThat(convertedString)
            .as("IS NOT ZAGGED TO: " + zigZagString)
            .isEqualTo(zigZagString);
 }

  @DataProvider(name = "zig zag data")
  public Object[][] zigZagData() {
    return new Object[][] {
      {"PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"},
      {"PAYPALISHIRING", 4, "PINALSIGYAHRPI"},
      {"A", 1, "A"}
    };
  }
}
