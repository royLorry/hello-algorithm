public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int count = 0;
        while (i >= 0 ) {
            if (s.charAt(i) == ' ') {
                i--;
            } else {
                break;
            }
        }
        while (i >= 0 ) {
            if (s.charAt(i) != ' ') {
                count++;
                i--;
            } else {
                break;
            }
        }
        return count;
    }
}