public class SubStr {

    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        int length1 = haystack.length();
        int length2 = needle.length();
        if (length2 > length1) {
            return -1;
        }
        for (int i = 0; i < length1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;
                while (j < length2) {
                    if (i + j < length1) {
                        if (haystack.charAt(i + j) != needle.charAt(j)) {
                            break;
                        }
                    } else {
                        return -1;
                    }
                    j++;
                }
                if (j == length2) {
                    return i;
                } else {
                    continue;
                }
            }
        }
        return -1;
    }
}