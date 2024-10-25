package orangesRotting;
import java.util.Queue;
import java.util.LinkedList;

class orangesRot {
    int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int orangesRotting(int[][] grid) {
        int currRot = 0;
        int all = 0;
        int mins = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                    currRot++;
                    all++;
                } else if (grid[i][j] == 1) {
                    all++;
                }
            }
        }
        
        if (all == 0) {
            return 0;
        }
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size != 0) {
                int[] coord = q.poll();
                size--;
                int i = coord[0];
                int j = coord[1];
                
                for (int[] adj : dir) {
                    int iDir = adj[0];
                    int jDir = adj[1];
                    if (inBounds(i + iDir, j + jDir, grid)) {
                        if (grid[i + iDir][j + jDir] == 1) {
                            currRot++;
                            grid[i + iDir][j + jDir] = 2;
                            q.add(new int[]{i + iDir, j + jDir});
                        }
                    }
                }
            }
            mins++;
        }
        
        if (mins == 1) {
            return currRot == all ? 0 : -1;
        }
        return currRot == all ? mins - 1 : -1;
    }
    
    public boolean inBounds(int i, int j, int[][] grid) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length;
    }
}
