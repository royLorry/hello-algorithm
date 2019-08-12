public class LongestCommonPrefix {

    /**
     * 最快的
     */
    public String longestCommonPrefix1(String[] strs) {
        if(strs == null || strs.length < 1) return "";
        String res = strs[0];
        for(int i = 1;i < strs.length;i++) {
            while(!strs[i].startsWith(res)) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

    /**
     * 第一个想法，一次次遍历，比较同位
     * 第二个想法，只需遍历一次，将前后两个对比找到共同pre即可
     */
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (null == strs || strs.length == 0) {
            return prefix;
        }
        prefix = strs[0];
        for (int i = 1; i < arrayLength; i++) {
            prefix = commonPrefix(prefix, strs[i]);
            if (prefix.equals("")) {
                return prefix;
            }
        }
        return prefix;
    }

    public String commonPrefix(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        String prefix = "";
        if (s1Length == 0 || s2Length == 0) {
            return prefix;
        }
        int max = s1Length < s2Length ? s1Length : s2Length;
        for (int i = 0; i < max ; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                prefix += s1.charAt(i);
            } else {
                break;
            }
        }
        return prefix;
    }
}