import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/description/
public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        String[] arrStr = s.split("");
        Stack<String> elements = new Stack<>();
        try {
            for (String str : arrStr) {
                switch (str) {
                    case "(":
                        elements.push(")");
                        break;
                    case "{":
                        elements.push("}");
                        break;
                    case "[":
                        elements.push("]");
                        break;
                    default:
                        if(!elements.pop().equals(str)) return false;
                }
            }
            if (elements.size() == 0)   return true;
            return false;
        }catch (Exception ex){
            return false;
        }
    }
}
