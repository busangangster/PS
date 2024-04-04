import java.util.*;
import java.io.*;

public class Solution {
	static int N,INF;
	static int[][] graph,min_dis;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		INF = Integer.MAX_VALUE;
		
		for (int tc=1; tc<=t; tc++) {
			N = Integer.parseInt(br.readLine());
			graph = new int[N][N];
			
			for (int i=0; i<N; i++) {
				String s = br.readLine();
				for (int j=0; j<N; j++) {
					graph[i][j] = s.charAt(j) - '0';
				}
			}
			dijkstra();
			sb.append("#").append(tc).append(" ").append(min_dis[N-1][N-1]).append("\n");
			
		}	
		System.out.println(sb);
	}
	 static void dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		min_dis = new int[N][N];
		for (int[] x: min_dis) {
			Arrays.fill(x,INF);
		}
		min_dis[0][0] = 0;
		pq.offer(new Point(0,0,graph[0][0]));
		
		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if (cur.x == N-1 && cur.y == N-1) {
				return;
			}
			
			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (check(nx,ny)) {
					if (min_dis[nx][ny] > cur.cost + graph[nx][ny]) {
						min_dis[nx][ny] = cur.cost + graph[nx][ny];
						pq.offer(new Point(nx,ny,cur.cost+graph[nx][ny]));
					}
				}			
			}
		}
		
	}
	 
	 static boolean check(int x, int y) {
		 if (0 <= x &&  x < N && 0 <= y && y < N ) return true;
		 else return false;
	 }
	
	static class Point implements Comparable<Point>{
		int x,y,cost;
		public Point(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Point o) {
			return this.cost - o.cost;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", cost=" + cost + "]";
		}
		
		
	}

}