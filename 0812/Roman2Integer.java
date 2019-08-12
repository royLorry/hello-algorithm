import java.util.HashMap;
import java.util.Map;

public class Roman2Integer {
    /**
     * https://leetcode-cn.com/problems/roman-to-integer/
     */
    public int romanToInt(String s) {
        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);
        int i = 0; // 进行累计
        int j = 0; // 指示当前最大值
        int temp = 0;
        int length = s.length();
        while (length > 0) {
            temp = romanMap.get(String.valueOf(s.charAt(length - 1)));
            if (temp < j) {
                i -= temp;
            } else {
                j = temp;
                i += temp;
            }
            length--;
        }
        return i;
    }
}