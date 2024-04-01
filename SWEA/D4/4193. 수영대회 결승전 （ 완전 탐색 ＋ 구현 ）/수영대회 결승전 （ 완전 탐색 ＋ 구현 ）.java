import java.io.*;
import java.util.*;
 
class Solution {
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int s_x,s_y,e_x,e_y,n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<=t; tc++) {
			n = Integer.parseInt(br.readLine());
			graph = new int[n][n];
			visited = new boolean[n][n];
			
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			st = new StringTokenizer(br.readLine());
			s_x = Integer.parseInt(st.nextToken());
			s_y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			e_x = Integer.parseInt(st.nextToken());
			e_y = Integer.parseInt(st.nextToken());
		
			
		int tmp = bfs(s_x,s_y);
		sb.append("#").append(tc).append(" ").append(tmp).append("\n");
			
		}
		System.out.println(sb);
	}
	public static int bfs(int x, int y) {
		Queue<Pos> q = new ArrayDeque<>();
		visited[x][y] = true;
		q.offer(new Pos(x,y,0));
		
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			
			if (cur.x == e_x && cur.y == e_y) {
				return cur.time;
			}
			
			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (!check(nx,ny)) continue;
				
				if (graph[nx][ny] == 1) continue;
				
				if (visited[nx][ny]) continue;

				if (graph[nx][ny] == 2) {
					if (cur.time % 3 == 2){
						visited[nx][ny] = true;
						q.offer(new Pos(nx,ny,cur.time+1));
					}
					else {
						visited[cur.x][cur.y] = true;
						q.offer(new Pos(cur.x,cur.y,cur.time+1));
					}
				}
				else {
					visited[nx][ny] = true;
					q.offer(new Pos(nx,ny,cur.time+1));
				}			
				
			}
		}
		return -1;
	}
	
	public static boolean check(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < n) return true;
		else return false;
	}
	
}

class Pos{
	int x,y,time;
	public Pos(int x, int y, int time) {
		this.x = x;
		this.y = y;
		this.time = time;
	}

}