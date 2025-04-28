import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LongestPalindromicSubstringQuestion5Tests
    extends LongestPalindromicSubstringQuestion5 {

  @Test(dataProvider = "palindrome test strings", description = "Brute force Test")
  public void longestPalindromV1(String source, String expected) {
    String longest = longestPalindrome(source);

    assertThat(longest).as("Found: " + longest + " but expected: " + expected).isEqualTo(expected);
  }

  @Test(dataProvider = "palindrome test strings", description = "Second version Test")
  public void longestPalindromV2(String source, String expected) {
    String longest = longestPalindromeV2(source);

    assertThat(longest).as("Found: " + longest + " but expected: " + expected).isEqualTo(expected);
  }

  @DataProvider(name = "palindrome test strings")
  public Object[][] palindromeTestStrings() {
    return new Object[][] {
      {"babad", "bab"},
      {"cbbd", "bb"},
      {"aacabdkacaa", "aca"},
      {
        "jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwpr"
            + "sgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavlj"
            + "pimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmp"
            + "qjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimb"
            + "xvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel",
        "sknks"
      }
    };
  }
}
