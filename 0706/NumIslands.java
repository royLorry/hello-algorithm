public class NumIslands{

    private int height;
    private int width;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        height = grid.length;
        width = grid[0].length;
        int[][] read = new int[height][width];
        int num = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '0' || read[i][j] == 1) {
                    //为0或已读直接跳过
                    continue;
                } else {
                    //以此为起点开始寻找最大岛屿
                    read[i][j] = 1;
                    findIsland(i-1, j, grid, read);
                    findIsland(i+1, j, grid, read);
                    findIsland(i, j-1, grid, read);
                    findIsland(i, j+1, grid, read);
                    num++;
                }
            }
        }
        return num;
    }

    public void findIsland(int row, int col, char[][] grid, int[][] read){
        if (row < 0 || col < 0 || row >= height || col >= width) {
            // 超出直接跳过
            return;
        }
        if (read[row][col] == 1) {
            // 已读直接跳过
            return;
        }
        // 未读开始判断值
        if (grid[row][col] == '1') {
            // 为1标记此处为已读，继续向上下左右找
            read[row][col] = 1;
            findIsland(row-1, col, grid, read);
            findIsland(row+1, col, grid, read);
            findIsland(row, col-1, grid, read);
            findIsland(row, col+1, grid, read);
            return;
        } else {
            // 为0标记为已读，return
            read[row][col] = 1;
            return;
        }
    }
    
}