class Solution {
        
    
    public void solve(char[][] board) {
        this.board = board;
        this.mRow = board.length;
        this.nColumn = board[0].length;
        initVisit();
        
        for (int i=0; i < mRow; i++) {
            for (int j=0; j < nColumn; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        
    }
    private void bfs(int sx, int sy) {
        List<Pair> zeroList = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        zeroList.add(new Pair(sx, sy));
        q.add(new Pair(sx, sy));
        
        visited[sx][sy] = true;
        
        while(!q.isEmpty()) {
            int x = q.peek().getFirst();
            int y = q.peek().getSecond();
            q.poll();
            
            for (int i=0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= mRow || ny < 0 || ny >= nColumn) {
                    continue;
                }
                if (this.board[nx][ny] == 'X') {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                
                q.add(new Pair(nx, ny));
                visited[nx][ny] = true;
                
                zeroList.add(new Pair(nx, ny));
            }
        }
        
        // 是否要改变区域
        changeX(zeroList);
    }
    
    
    private int mRow ;
    private int nColumn;
    private char[][] board;
    private boolean[][] visited;
    
    private int[] dx = {-1, 0, 0, 1};
    private int[] dy = {0, -1, 1, 0};
    
    /**
     * 已访问
     */
    private void initVisit() {
        visited = new boolean[mRow][]; 
        for (int i=0; i < mRow; i++) {
            visited[i] = new boolean[nColumn]; 
            for (int j=0; j <nColumn; j++ ) {
                visited[i][j] = false;
            }
        }
    }
    
    /**
     * 改变内部区域为X
     */
    private void changeX(List<Pair> v) {
        boolean canChange = false;
        for(int i=0; i < v.size(); i++) {
            Pair n = v.get(i);
            int x = n.getFirst();
            int y = n.getSecond();
            
            if (x == 0 || x == mRow-1 || y == 0 || y == nColumn - 1 ) {
                canChange = true;
            }
        }
        if (!canChange) {
            for(int i=0; i < v.size(); i++) {
                Pair n = v.get(i);
                int x = n.getFirst();
                int y = n.getSecond();
                this.board[x][y] = 'X';
            }
        }
    }
    
    class Pair {
        private int first;
        private int second;
        
        public Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }
        public int getFirst() {
            return first;
        }
        public int getSecond() {
            return second;
        }
    }

}
