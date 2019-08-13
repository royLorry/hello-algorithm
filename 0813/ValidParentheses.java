import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    class Official {
        // Hash table that takes care of the mappings.
        private HashMap<Character, Character> mappings;

        // Initialize hash map with mappings. This simply makes the code easier to read.
        public Solution() {
            this.mappings = new HashMap<Character, Character>();
            this.mappings.put(')', '(');
            this.mappings.put('}', '{');
            this.mappings.put(']', '[');
        }

        public boolean isValid(String s) {

            // Initialize a stack to be used in the algorithm.
            Stack<Character> stack = new Stack<Character>();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // If the current character is a closing bracket.
                if (this.mappings.containsKey(c)) {

                    // Get the top element of the stack. If the stack is empty, set a dummy value of
                    // '#'
                    char topElement = stack.empty() ? '#' : stack.pop();

                    // If the mapping for this bracket doesn't match the stack's top element, return
                    // false.
                    if (topElement != this.mappings.get(c)) {
                        return false;
                    }
                } else {
                    // If it was an opening bracket, push to the stack.
                    stack.push(c);
                }
            }

            // If the stack still contains elements, then it is an invalid expression.
            return stack.isEmpty();
        }
    }

    /**
     * 用栈将正的放入，遇到反的就去栈去除进行匹配，匹配成功继续，匹配失败return false
     */
    public boolean isValid(String s) {
        if (null == s) {
            return false;
        }
        if (0 == s.length()) {
            return true;
        }
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        map1.put('(', ')');
        map1.put('[', ']');
        map1.put('{', '}');
        map2.put(')', '(');
        map2.put(']', '[');
        map2.put('}', '{');

        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            Character c = Character.valueOf(s.charAt(i));
            if (map1.containsKey(c)) {
                stack.push(c);
            } else {
                if (!stack.empty() && stack.peek() == map2.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }

    }
}