package Arrays;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII,
which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX.
There are six instances where subtraction is used:
I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.

Example 1:
Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.

Example 2:
Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.

Example 3:
Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/
public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        if(num>=1000){ return "M" + intToRoman(num-1000);}
        if(num>=900){ return "CM" + intToRoman(num-900); }
        if(num>=500){ return "D" + intToRoman(num-500);}
        if(num>=400){ return "CD" + intToRoman(num-400);}
        if(num>=100){ return "C" + intToRoman(num-100);}
        if(num>=90){ return "XC" + intToRoman(num-90);}
        if(num>=50){ return "L" + intToRoman(num-50);}
        if(num>=40){ return "XL" + intToRoman(num-40);}
        if(num>=10){ return "X" + intToRoman(num-10);}
        if(num==9){ return "IX";}
        if(num>=5){ return "V"+ intToRoman(num-5);}
        if(num==4){ return "IV";}
        if(num>=1){ return "I"+intToRoman(num-1);}
        return "";
    }
}
