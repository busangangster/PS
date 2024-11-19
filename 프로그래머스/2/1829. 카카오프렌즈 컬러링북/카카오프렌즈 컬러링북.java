import java.util.*;

class Solution {
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static boolean[][] visited;
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        visited = new boolean[m][n];
        int area = 0;
        int ans = 0;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int tmp = picture[j][i];
                if (!visited[j][i] && picture[j][i] != 0) {
                    visited[j][i] = true;
                    int res = BFS(j,i,tmp,n,m,picture);
                    area++;
                    ans = Math.max(ans,res);
                }
            }
        }
        answer[0] = area;
        answer[1] = ans;
        return answer;
    }
    
    public static int BFS(int x, int y,int tmp, int n, int m,int[][] picture) {
        Queue<Node> q = new ArrayDeque<Node>();
        q.add(new Node(x,y));
        int cnt = 1;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            for (int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (check(nx,ny,n,m)) {
                    if (!visited[nx][ny] && picture[nx][ny] != 0 && picture[nx][ny] == tmp) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx,ny));
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
    
    public static boolean check(int x, int y, int n, int m) {
        if (0 <= x && x < m && 0 <= y && y < n) return true;
        else return false;
    }
}

class Node{
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}