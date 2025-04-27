  /*
     The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of numRows like this: (you may want to
     display this pattern in a fixed font for better legibility)

     P   A   H   N
     A P L S I I G
     Y   I   R

     And then read line by line: "PAHNAPLSIIGYIR"

     Write the code that will take a string and make this conversion given a number of numRows:

     string convert(string s, int numRows);



     Example 1:

     Input: s = "PAYPALISHIRING", numRows = 3
     Output: "PAHNAPLSIIGYIR"

     Example 2:

     Input: s = "PAYPALISHIRING", numRows = 4
     Output: "PINALSIGYAHRPI"
     Explanation:
     P     I    N
     A   L S  I G
     Y A   H R
     P     I

     Example 3:

     Input: s = "A", numRows = 1
     Output: "A"



     Constraints:

         1 <= s.length <= 1000
         s consists of English letters (lower-case and upper-case), ',' and '.'.
         1 <= numRows <= 1000


  */
  public class ZigZagString {

    public String zigZag(String s, int numRows) {

    if (s.length() <= numRows || numRows == 1) {
      return s;
    }

    int x1x2Delta = numRows + (numRows - 2);
    StringBuilder newString = new StringBuilder();

    // Add row1
    for (int i = 0; i < s.length(); i = i + x1x2Delta) {
      newString.append(s.charAt(i));
    }

    // Add middle numRows
    for (int j = 1; j < numRows; ++j) {
      int charPointer = j;
      int numCols = (int) Math.ceil(x1x2Delta / s.length());

      while (charPointer < s.length()) {
        // Add value in column if exists
        newString.append(s.charAt(charPointer));

        // Add diagnol value if exists
        int diagnolIndex = charPointer + x1x2Delta - (2*j);
        if (diagnolIndex < s.length() && j != numRows-1) {
          newString.append(s.charAt(diagnolIndex));
        }

        charPointer += x1x2Delta;
      }
    }

    return newString.toString();
  }
}

/*
paypalishiring
pinalsigyahrpi
p  i  n
a ls ig
ya hr
p  i

1 7 13 2 6 8 12 14 3 5 9 11 4 10
1 2 3  4 5 6 7  8 9 10 11 12 13 14
    noCol: (length / rows) -> 14/4 = 3.5 -> 3 columns

    row * (noCol)
    innerCol = rows - 1 - row

abcdefghijklmnopqrstu
aipbnjprcgkosdflntemu
a   i   p
b  hj  pr
c g k o s
df  ln  t
e   m   u

i - ((i%(rows+rows-2))+2)

 */
