package LeetCodeSubmissions;

import java.util.Date;

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:
Input: num1 = "2", num2 = "3"
Output: "6"

Example 2:
Input: num1 = "123", num2 = "456"
Output: "56088"

Constraints:
1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
public class MultiplyStrings {
    static class Obj {
        int testCase;
        final String operationType = "String Multiplication";
        String num1;
        String num2;
        String result;
        double timeTaken;

        public Obj(int testCase, String num1, String num2, String result, int timeTaken) {
            this.testCase = testCase;
            this.num1 = num1;
            this.num2 = num2;
            this.result = result;
            this.timeTaken = timeTaken;
        }

        @Override
        public String toString() {
            return "\n\tObj{" + "\n" +
                    "\t\ttestCase=" + testCase + "\',\n" +
                    "\t\toperationType='" + operationType + "\',\n" +
                    "\t\tnum1='" + num1 + "\',\n" +
                    "\t\tnum2='" + num2 + "\',\n" +
                    "\t\tresult='" + result + "\',\n" +
                    "\t\ttimeTaken=" + timeTaken +
                    "\n\t}";
        }
    }

    public static void main (String[] args) {
        System.out.println("Test case 1: " + multiply(new Obj(1, "2", "6", "", Integer.MIN_VALUE)));
        System.out.println("Test case 2: " + multiply(new Obj(3, "123", "456", "", Integer.MIN_VALUE)));
        System.out.println("Test case 3: " + multiply(new Obj(4, "12345", "45698", "", Integer.MIN_VALUE)));
        System.out.println("Test case 4: " + multiply(new Obj(5, "912345", "4775698", "", Integer.MIN_VALUE)));
        System.out.println("Test case 5: " + multiply(new Obj(6, "217", "79362", "", Integer.MIN_VALUE)));
        System.out.println("Test case 6: " + multiply(new Obj(7, "79362", "217", "", Integer.MIN_VALUE)));
        System.out.println("Test case 7: " + multiply(new Obj(8, "91234234552345675432", "4775698234523456543234543234543", "", Integer.MIN_VALUE)));
        System.out.println("Test case 8: " + multiply(new Obj(9, "9123476543234567897654345678983456789864212321213452347654323456789765434567898345523476543234567" +
                "8976543456789834552347654323456789765434567852347654323456789765434567898345523476543234567897654345678983455234765432345678976543456789834552347654323456789765434" +
                "5678983455234765432345678976543456789834552347654323456789765434567898345983455234765432345678976543456789834552347654323456789765434567898345523476543234567897654" +
                "3456789834567898642123212134567890909234552342347654323456789765434567898345678986421232121345678909092345523423476543234567897654345678983456789864212321213456789" +
                "0909234552342347654323456789765434567898345678986421232121345678909092345523423476543234567897654345678983456789864212321213456789090923455234234765432345678976543" +
                "45678983456789864212321213456789090923455234678909092345523456776587654345789876543456789876543456784567654565432",
                "4775698234523476543456787654477569823452347654345678765432345678987654334567898765434567898765434567565432345432345434775698234523476543454775698234523476543" +
                        "456784775698234523476543456787654323456789876543345678987654345678987654345675654323454323454347756982345234765434567876543234567898765433456789876543456789" +
                        "876543456756543234543234543477569823452347654345678765432345678987654334567898765434567898765434567565432345432345434775698234523476543456787654323456789876" +
                        "5433456789876543456789876543456756543234543234543477569823452347654345678765432345678987654334567898765434567898765434567565432345432345434775698234523476543" +
                        "4567876543234567898765433456789876543456789876543456756543234543234543765432345678987654334567898765434567898765434567565432345432345434775698234523476543456" +
                        "7876543234567898765433456789876543456789876543456756543234543234543678765432345678987654334567898765434567898765434567565432345432345433234567898765433456789" +
                        "876543456789876543456756543234543234543",
                "", Integer.MIN_VALUE)));
    }

    // SOLUTION 1
    // Break both nums into char array, keep multiplying both array indices and put into resultant array index, traverse result array and resolve carry.
    public static Obj multiply(Obj input) {
        long start = System.currentTimeMillis();
        if(isZero(input.num1) || isZero(input.num2)) {
            input.result = "0";
            return input;
        };
        if(isOne(input.num1)) {
            input.result = input.num2;
            return input;
        };
        if(isOne(input.num2)) {
            input.result = input.num1;
            return input;
        };

        char[] c1 = input.num1.toCharArray();
        char[] c2 = input.num2.toCharArray();
        int[] ans = new int[c1.length + c2.length];

        for(int i = c1.length - 1; i >= 0; i--) {
            int c = c1[i] - '0';
            for(int j = c2.length - 1; j >= 0; j--) {
                ans[i + j + 1] += c * (c2[j] - '0');
            }
        }

        for(int i = ans.length - 1; i > 0; i--) {
            if(ans[i] > 9) {
                ans[i - 1] += ans[i] / 10;
                ans[i] %= 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;

        for(; ; i++) if(ans[i] != 0) break;

        for(; i < ans.length; i++) {
            sb.append(ans[i]);
        }
        input.result = sb.toString();
        long end = System.currentTimeMillis();
        input.timeTaken = (double)(end - start);
        return input;
    }

    private static boolean isZero(String num) {
        return num.equals("0");
    }

    private static boolean isOne(String num) {
        return num.equals("1");
    }


    // SOLUTION 2
//    public static Obj multiply(Obj input) {
//        long start = System.currentTimeMillis();
//        int ans[] = new int[input.num1.length() + input.num2.length()]; //for saving the final answer
//        for (int i = input.num1.length() - 1; i >= 0; i--) {//iterating num1
//            for (int j = input.num2.length() - 1; j >= 0; j--) {//iterating num2 each digits
//                //converting to integer by subtracting the ASCII value of the num with starting number that is zero;
//                int result = (input.num1.charAt(i) - '0') * (input.num2.charAt(j) - '0');
//                //add if we have any carry
//                result += ans[i + j + 1];
//                //calculate the remainder and carry
//                int carry = result / 10;
//                int valueToStore = result % 10;
//                //update the answer by performing the sum directly of the numbers
//                ans[i + j] += carry;
//                ans[i + j + 1] = valueToStore;
//            }
//        }
//        String toReturn = "";
//        boolean flag = true;
//        for (int i = 0; i < ans.length; i++) {
//            if (ans[i] != 0) { //ignore the initial zero
//                flag = false;
//            }
//            if (!flag) {
//                toReturn = toReturn + ans[i];
//                flag = false;
//            }
//        }
//        long end = System.currentTimeMillis();
//        input.timeTaken = (double)(end - start);
//        input.result = (toReturn == "") ? "0" : toReturn;
//        return input;
//    }


    // SOLUTION 3
//    private static Obj multiply(Obj input) {
//        long start = System.currentTimeMillis();
//        if (input.num1.equals("0") || input.num2.equals("0")) {
//            input.result = "0";
//        } else {
//            String n1 = new StringBuilder(input.num1).reverse().toString();
//            String n2 = new StringBuilder(input.num2).reverse().toString();
//            StringBuilder ans = new StringBuilder();
//
//            for (int i = 0; i < n1.length(); i++) {
//                ans = addStrings(ans, multiplyOneDigit(n1.charAt(i), n2), i);
//            }
//            long end = System.currentTimeMillis();
//            input.timeTaken = (double)(end - start);
//            input.result = ans.reverse().toString();
//        }
//        return input;
//    }
//
//    private static StringBuilder multiplyOneDigit (Character digit, String n2) {
//        StringBuilder ans = new StringBuilder();
//        int carry = 0;
//        for (int j = 0; j < n2.length(); j++) {
//            int mul = (digit - '0') * (n2.charAt(j) - '0');
//            mul += carry;
//            ans.append(mul % 10);
//            carry = mul / 10;
//        }
//        if (carry != 0)
//            ans.append(carry);
//        return ans;
//    }
//
//    private static StringBuilder addStrings (StringBuilder s1, StringBuilder s2, int place) {
//        if (s1.toString().isEmpty())
//            return s2;
//        StringBuilder retVal = new StringBuilder();
//        int i = 0, j = 0, carry = 0;
//        while (place > 0) {
//            s2 = new StringBuilder().append("0").append(s2);
//            place--;
//        }
//        while (i < s1.length() && j < s2.length()) {
//            int add = (s1.charAt(i++) - '0') + (s2.charAt(j++) - '0') + carry;
//            retVal.append( add % 10 );
//            carry = add / 10;
//        }
//        while (i < s1.length()) {
//            if (carry != 0) {
//                retVal.append((s1.charAt(i++) - '0') + carry);
//                carry = 0;
//            } else {
//                retVal.append(s1.charAt(i++) - '0');
//            }
//        }
//        while (j < s2.length()) {
//            if (carry != 0) {
//                int add = (s2.charAt(j++) - '0') + carry;
//                retVal.append(add % 10);
//                carry = add / 10;
//            } else {
//                retVal.append((s2.charAt(j++) - '0'));
//            }
//        }
//        if (carry != 0)
//            retVal.append(carry);
//        return retVal;
//    }
}
