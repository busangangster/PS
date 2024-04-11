import java.util.*;
import java.io.*;

public class Solution {
	static int N,start_x,start_y,end_x,end_y;
	static int[][] graph;
	static boolean[][] visited;
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc<=t; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			graph = new int[N][N];
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			st = new StringTokenizer(br.readLine());
			start_x = Integer.parseInt(st.nextToken());
			start_y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			end_x = Integer.parseInt(st.nextToken());
			end_y = Integer.parseInt(st.nextToken());
			
			int tmp = bfs(start_x,start_y,0);
			sb.append("#").append(tc).append(" ").append(tmp).append("\n");
		}
		System.out.println(sb);
	}
	
	static int bfs(int x, int y, int cnt) {
		Queue<Swim> q = new ArrayDeque<Swim>();
		visited = new boolean[N][N];
		q.offer(new Swim(x,y,cnt));
		visited[x][y] = true;
		
		while (!q.isEmpty()) {
			Swim cur = q.poll();
			
			if (cur.x == end_x && cur.y == end_y) {
				return cur.cnt;
			}
			
			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(!check(nx,ny)) continue;
				
				if (visited[nx][ny]) continue;
				
				if (graph[nx][ny] == 1) continue;
				
				q.offer(new Swim(nx,ny,cur.cnt+1));
				visited[nx][ny] = true;		
			}
			
		}
		return -1;
	}
	
	static boolean check(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) return true;
		else return false;
			
	}
	
	static class Swim{
		int x,y,cnt;
		public Swim(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}