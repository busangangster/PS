import java.io.*;
import java.util.*;

public class Solution {
    static int N,max_v;
    static int[][] graph;
    static ArrayList<Pos> startPoint;
    static ArrayList<Pos> blackHall;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        for (int tc=1; tc<=t; tc++) {
            N = Integer.parseInt(br.readLine().trim());

            graph = new int[N][N];
            startPoint = new ArrayList<>();
            max_v = Integer.MIN_VALUE;
            blackHall = new ArrayList<>();

            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j=0; j<N; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    if (graph[i][j] == 0) startPoint.add(new Pos(i,j));
                    if (graph[i][j] == -1) blackHall.add(new Pos(i,j));

                }
            }

            for (int i=0; i<startPoint.size(); i++) {
                for (int j=0; j<4; j++) {
                    int tmp = move(startPoint.get(i).x, startPoint.get(i).y,j);
                    max_v = Math.max(tmp, max_v);
                }
            }
            sb.append("#").append(tc).append(" ").append(max_v).append("\n");
        }
        System.out.println(sb);

    }

    static int move(int x, int y, int direction) {
        int score = 0;
        int nx = x;
        int ny = y;
        int d = direction;

        while (true) {
            nx += dx[d];
            ny += dy[d];

            if (!checkWall(nx,ny)) {
                score++;
                nx = nx - dx[d];
                ny = ny - dy[d];
                d = (d+2) % 4;
            }

            if (graph[nx][ny] >= 1 && graph[nx][ny] <= 5) {
                score++;
                d = changeDir(nx, ny, d);
            }


            // 각 블록에 부딪혔을 때 

            else if (graph[nx][ny] >= 6) {
                int[] worm = wormhole(nx, ny, graph[nx][ny]);
                nx = worm[0];
                ny = worm[1];
            }
            
            if (nx == x && ny == y || graph[nx][ny] == -1){
                return score;
            }
        }

    }

    static int[] wormhole(int x, int y, int number) {
        int[] change = new int[2];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if ((x != i || y != j) && graph[i][j] == number) {
                    change[0] = i;
                    change[1] = j;
                    return change;
                }
            }
        }
        return change;
    }

    static boolean checkWall(int x ,int y) {
        if (0 <= x && x < N && 0 <= y && y < N) return true;
        else return false;
    }

    static int changeDir(int x, int y, int d) {
        int nextD = d;
        if (graph[x][y] == 1) {
            if (nextD == 0 ) {
                nextD = 2;
            }
            else if (nextD == 1) {
                nextD = 3;
            }
            else if (nextD == 2) {
                nextD = 1;
            }
            else if (nextD == 3) {
                nextD = 0;
            }

        }
        else if (graph[x][y] == 2) {
            if (nextD == 0 ) {
                nextD = 1;
            }
            else if (nextD == 1) {
                nextD = 3;
            }
            else if (nextD == 2) {
                nextD = 0;
            }
            else if (nextD == 3) {
                nextD = 2;
            }

        }
        else if (graph[x][y] == 3) {
            if (nextD == 0 ) {
                nextD = 3;
            }
            else if (nextD == 1) {
                nextD = 2;
            }
            else if (nextD == 2) {
                nextD = 0;
            }
            else if (nextD == 3) {
                nextD = 1;
            }

        }
        else if (graph[x][y] == 4) {
            if (nextD == 0 ) {
                nextD = 2;
            }
            else if (nextD == 1) {
                nextD = 0;
            }
            else if (nextD == 2) {
                nextD = 3;
            }
            else if (nextD == 3) {
                nextD = 1;
            }
        }
        else if (graph[x][y] == 5) {
            if (nextD == 0 ) {
                nextD = 2;
            }
            else if (nextD == 1) {
                nextD = 3;
            }
            else if (nextD == 2) {
                nextD = 0;
            }
            else if (nextD == 3) {
                nextD = 1;
            }
        }
        return nextD;
    }

    static class Pos{
        int x,y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}