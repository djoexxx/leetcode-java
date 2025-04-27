/*
 7. Reverse Integer
   Medium

   Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside
   the signed 32-bit integer range [-231, 231 - 1], then return 0.

   Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

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


   Constraints:
       -231 <= x <= 231 - 1
*/

import java.math.BigInteger;

public class ReverseIntegerQuestion7 {
  /**
   * Brute force method that converts int x to a StringBuilder, then reverses the string.  After that the string is
   * converted to a long to check if the number exceeds 32bit before returning the final value.
   *
   * @param x - (int) the value to reverse
   * @return (int) the digits of x in reverse
   */
  public int reverse(int x) {
    String originalString;

    if (x >= 0) {
      originalString = new StringBuilder(Integer.toString(x)).reverse().toString();
    } else {
      String temp = Integer.toString(x);
      originalString =
          "-" + new StringBuilder(temp.substring(1, temp.length())).reverse().toString();
    }

    return stringToInt(originalString);
  }

  /**
   * Uses mod to get last digit (i.e. remainder), then uses multiplication to "shift" previously determined values and
   * then adds the latest remainder determined.
   *
   * @param x - (int) the value to reverse
   * @return (int) the digits of x in reverse
   */
  public int reverseV2(int x) {
    long reversed = 0;
    int remainder;

    while (x != 0) {
      remainder = x % 10;
      reversed = (reversed * 10) + remainder;
      x = x / 10;
    }

    if (reversed > Integer.MAX_VALUE) {
      return 0;
    } else if (reversed < Integer.MIN_VALUE) {
      return 0;
    } else {
      return (int) reversed;
    }
  }

  public int stringToInt(String value) {
    long bigInt = Long.valueOf(value);

    if (bigInt > 0) {
      if (bigInt > Long.valueOf(Integer.MAX_VALUE)) {
        return 0;
      } else {
        return Integer.parseInt(value);
      }
    } else if (bigInt < 0) {
      if (bigInt < Long.valueOf(Integer.MIN_VALUE)) {
        return 0;
      } else {
        return Integer.parseInt(value);
      }
    } else {
      return 0;
    }
  }
}
