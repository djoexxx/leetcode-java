/*
 5. Longest Palindromic Substring
 Medium

 Given a string s, return the longest in s.

 Example 1:

 Input: s = "babad"
 Output: "bab"
 Explanation: "aba" is also a valid answer.

 Example 2:

 Input: s = "cbbd"
 Output: "bb"

 Constraints:

     1 <= s.length <= 1000
     s consist of only digits and English letters.
*/
public class LongestPalindromicSubstringQuestion5 {
  public String longestPalindrome(String s) {
    String longest = "";

    if (s.length() == 1) {
      return s;
    }

    for (int i = 0; i <= s.length() - 2; ++i) {
      char current = s.charAt(i);

      int headIndex = i;
      int endIndex = s.lastIndexOf(current);
      boolean notPalendrome = true;
      while (endIndex > headIndex && notPalendrome) {
        int subStringSize = (endIndex - headIndex) + 1;
        int pivotIndex = subStringSize / 2;
        String subString = s.substring(headIndex, endIndex + 1);
        boolean isOdd = (subStringSize % 2 == 0) ? false : true;

        if (isOdd) {
          for (int j = 0; j <= pivotIndex; ++j) {
            char headChar = subString.charAt(j);
            char tailChar = subString.charAt(subStringSize - j - 1);

            if (headChar != tailChar) {
              break;
            } else if (j >= pivotIndex) {
              notPalendrome = false;
              break;
            }
          }

          if (subString.length() > longest.length() && !notPalendrome) {
            longest = subString;
          }
        } else {
          for (int j = 0; j <= pivotIndex; ++j) {
            char headChar = subString.charAt(j);
            char tailChar = subString.charAt(subStringSize - j - 1);

            if (headChar != tailChar) {
              break;
            } else if (j >= pivotIndex) {
              notPalendrome = false;
            }
          }

          if (subString.length() > longest.length() && !notPalendrome) {
            longest = subString;
          }
        }

        --endIndex;
      }
    }

    if (longest.equals("")) {
      longest = s.substring(0, 1);
    }

    return longest;
  }

  public String longestPalindromeV2(String s) {
    String longest = Character.toString(s.charAt(0));
    int longestLength = longest.length();
    int length = s.length();

    if (length == 1) {
      return s;
    }

    if (length == 2) {
      if (s.charAt(0) == s.charAt(1)) {
        return s;
      } else {
        return Character.toString(s.charAt(0));
      }
    }

    int pivot = 0;
    int next = s.lastIndexOf(s.charAt(pivot), s.length() - 1);
    String tempString = s.substring(pivot, next+1);
    boolean isPalindrome = false;
    do {
      if (pivot == next) {
        ++pivot;
        next = s.lastIndexOf(s.charAt(pivot), s.length() - 1);
        tempString = s.substring(pivot, next+1);

        continue;
      }

      while (!isPalindrome && next != -1) {
        isPalindrome = isPalindrome(tempString);

        if (isPalindrome) {
          if (tempString.length() > longestLength) {
            longest = tempString;
            longestLength = longest.length();
          }
        } else {
          next = s.lastIndexOf(s.charAt(pivot), next - 1);
          tempString = s.substring(pivot, next+1);

          if (tempString.length() < longestLength) {
            next = -1;
          }
        }
      }

      isPalindrome = false;
      ++pivot;
      next = s.lastIndexOf(s.charAt(pivot), s.length() - 1);
      tempString = s.substring(pivot, next+1);

    } while (pivot < length-1 && pivot < length-longestLength);

    return longest;
  }

  public boolean isPalindrome(String s) {

    boolean continueLoop = true;
    int leftPointer = 0;
    int rightPointer = s.length() - 1;
    while (leftPointer < rightPointer) {
      if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
        return false;
      }

      ++leftPointer;
      --rightPointer;
    }

    return true;
  }
}
