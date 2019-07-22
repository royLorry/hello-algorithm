import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        char c;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                c = board[i][j];
                Set set = new HashSet<Character>();
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                c = board[j][i];
                Set set = new HashSet<Character>();
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
        }

        
        
        return true; 
    }
}