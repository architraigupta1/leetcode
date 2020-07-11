package com.archit.coding.leetcode;

public class IntegerToEnglishWords_273 {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.print(s.numberToWords(
        1234567));
  }

  static class Solution {
    public String numberToWords(int n) {
      int num = n;
      if (num < 0) {
        return "";
      }

      if (num == 0) {
        return "Zero";
      }

      String result = "";

      while (num != 0) {
        if (num >= 1000000000 && num <= Integer.MAX_VALUE) {
          result += convertToString(num / 1000000000);
          result += " Billion";
          num = num % 1000000000;
        } else if(num >= 1000000 && num <= 999999999) {
          result += convertToString(num / 1000000);
          result += " Million";
          num = num % 1000000;
        } else if (num >= 1000 && num <= 999999) {
          result += convertToString(num / 1000);
          result += " Thousand";
          num = num % 1000;
        }  else if (num >= 100 && num <= 999) {
          result += getHundredsString(num);
          num = num % 100;
        } else if (num >= 11 && num <= 19) {
          result += getTensString(num);
          num = 0;
        }
        else if (num == 10 || num >= 20 && num <= 99) {
          result += getTensString(num);
          num = num % 10;
        } else {
          result += getOnesString(num);
          num = 0;
        }
      }

      return result;
    }

    private String convertToString(int num) {
      String result = "";

      while (num != 0) {
        if (num >= 1 && num <= 9) {
          result += getOnesString(num);
          num = 0;
        }

        if (num >= 11 && num <= 19) {
          result += getTensString(num);
          num = 0;
        }

        if (num == 10 || num >=20 && num <= 99) {
          result += getTensString(num);
          num = num % 10;
        }

        if (num >= 100 && num <= 999) {
          result += getHundredsString(num);
          num = num % 100;
        }
      }
      return result;
    }

    private String getOnesString(int num) {
      String result = "";
      switch(num) {
        case 1: result += " One";
          break;
        case 2: result += " Two";
          break;
        case 3: result += " Three";
          break;
        case 4: result += " Four";
          break;
        case 5: result += " Five";
          break;
        case 6: result += " Six";
          break;
        case 7: result += " Seven";
          break;
        case 8: result += " Eight";
          break;
        case 9: result += " Nine";
          break;
      }
      return result;
    }

    private String getTensString(int num) {
      String result = "";
      switch(num) {
        case 11: return " Eleven";

        case 12: return " Twelve";

        case 13: return " Thirteen";

        case 14: return " Fourteen";

        case 15: return " Fifteen";

        case 16: return " Sixteen";

        case 17: return " Sevent";

        case 18: return " Eighteen";

        case 19: return " Nineteen";
      }

      int tens = num / 10;
      switch (tens) {
        case 1: result += " Ten";
          break;
        case 2: result += " Twenty";
          break;
        case 3: result += " Thirty";
          break;
        case 4: result += " Fourty";
          break;
        case 5: result += " Fifty";
          break;
        case 6: result += " Sixty";
          break;
        case 7: result += " Seventy";
          break;
        case 8: result += " Eighty";
          break;
        case 9: result += " Ninety";
          break;
      }

      return result;
    }

    private String getHundredsString(int num) {
      String result = getOnesString(num / 100) + " Hundred";
      return result;
    }
  }
}
