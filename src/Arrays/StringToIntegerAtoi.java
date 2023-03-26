package Arrays;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("12"));
    }

    public static int myAtoi (String s) {
        if(s.length() == 0) return 0;
        long finalNum = 0l;
        boolean isNegativeNumber = false;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == ' ')) {
                //DO NOTHING
            } else if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                break;
            } else {
                if (finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE) {
                    break;
                }
                int digit = s.charAt(i) - '0';
                finalNum = (finalNum * 10) + digit;
            }
        }
        if (s.charAt(0) == '-')
            finalNum *= -1;

        if (finalNum > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (finalNum < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)finalNum;
    }
}
