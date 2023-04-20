package LeetCodeSubmissions;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println("isValid(\"()[]{}\"):" + isValid("()[]{}"));
        System.out.println("isValid(\"()]{}\"): " + isValid("()]{}"));
    }

    public static boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int tos = -1, i = 0;
        while (i < s.length()) {
            switch(s.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    stack[++tos] = s.charAt(i);
                    break;
                case ')':
                    if (tos < 0 || stack[tos--] != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (tos < 0 || stack[tos--] != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (tos < 0 || stack[tos--] != '[') {
                        return false;
                    }
                    break;
            }
            i++;
        }
        return (tos == -1);
    }
}
