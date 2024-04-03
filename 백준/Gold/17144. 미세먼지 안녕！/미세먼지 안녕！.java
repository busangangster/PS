import java.io.*;
import java.util.*;

public class Main {
	static int R,C,T;
	static int[][] graph;
	static boolean[][] visited;
	static ArrayList<Pos> air = new ArrayList<Pos>();
	static int[] up_x = {0,-1,0,1};
	static int[] up_y = {1,0,-1,0};
	static int[] down_x = {0,1,0,-1};
	static int[] down_y = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		graph = new int[R][C];
		
		for (int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<C; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == -1) {
					air.add(new Pos(i,j,0));
				}
			}
			
		}
		
		for (int i=0; i<T; i++) {
			go_dust();
			air_cleaner();
			
		}
		int ans = dustCnt();
		System.out.println(ans);
		
	}
	
	static void go_dust() {
		Queue<Pos> q = new ArrayDeque<Pos>();
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (graph[i][j] > 0) {
					q.add(new Pos(i,j,graph[i][j]));
				}
			}
		}
		
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			int cnt = 0;
			int spread = cur.dust / 5; 
			
			for (int i=0; i<4; i++) {
				int nx = cur.x + up_x[i];
				int ny = cur.y + up_y[i];
				
				if (!check(nx,ny)) continue;
								
				if (graph[nx][ny] == -1) continue;
				
				cnt++;
				graph[nx][ny] += spread;
			}
			
			graph[cur.x][cur.y] = graph[cur.x][cur.y] - (spread * cnt); 
		}
		
	}
	
	static void air_cleaner() {
		int top = air.get(0).x;
		
		// 아래로
		for (int i=top-1; i > 0 ;i--) {
			graph[i][0] = graph[i-1][0];	
		}
		
		// 왼쪽으로
		for (int i=0; i<C-1; i++) {
			graph[0][i] = graph[0][i+1];
		}
		
		// 위로
		for (int i=0; i < top; i++) {
			graph[i][C-1] = graph[i+1][C-1];
		}
		
		// 오른쪽으로
		for (int i=C-1; i > 1; i--) {
			graph[top][i] = graph[top][i-1];
		}
		graph[top][1] = 0;
		
		int down = air.get(1).x;
		
		// 위로
		for (int i=down+1; i<R-1; i++) {
			graph[i][0] = graph[i+1][0];
		}
		
		// 왼쪽으로
		for (int i= 0 ; i < C-1; i++) {
			graph[R-1][i] = graph[R-1][i+1];
		}
		
		// 아래로
		for (int i=R-1; i > down; i--) {
			graph[i][C-1] = graph[i-1][C-1];
		}
		
		// 오른쪽으로
		for (int i= C-1; i > 1; i--) {
			graph[down][i] = graph[down][i-1];
		}
		graph[down][1] = 0;
	}
	
	
	static boolean check(int x, int y) {
		if (0 <= x && x < R && 0 <= y && y < C) return true;
		else return false;
	}
	
	static int dustCnt() {
		int count = 0;
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (graph[i][j] != -1) {
					count += graph[i][j];
				}
			}
		}
		return count;
	}

	static class Pos{
		int x,y,dust;
		public Pos(int x, int y, int dust) {
			this.x = x;
			this.y = y;
			this.dust = dust;
		}
	}
}