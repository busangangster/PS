import java.io.*;
import java.util.*;
public class Main {
	static int N,M;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M];

		int time = 1;
		int cheese = 0;
		int before = 0;
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1) {
					cheese++;
				}
			}
		}
		
		while (true) {
			bfs();
			melt();
			before = cheese;
			cheese = countUp();
			if (cheese == 0) {
				System.out.println(time);
				System.out.println(before);
				break;
			}
			time++;
		}
	}
	
	static void bfs() {
		Queue<Node> q = new ArrayDeque<Node>();
		visited = new boolean[N][M];
		visited[0][0] = true;
		q.offer(new Node(0,0));
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (!boundCheck(nx, ny)) continue;
				if (visited[nx][ny]) continue;
				
				if (graph[nx][ny] == 0) {
					q.offer(new Node(nx,ny));
				}
				else if (graph[nx][ny] == 1) {
					graph[nx][ny] = -1;
				}
				visited[nx][ny]= true; 
			}
		}
	}
	
	static void melt() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if(graph[i][j] == -1) {
					graph[i][j] = 0;
				}
			}
		}
	}
	
	static int countUp() {
		int cnt = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (graph[i][j] == 1) cnt++;
			}
		}
		return cnt;
	}
	
	static boolean boundCheck(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) return true;
		else return false;
	}
	
	static class Node{
		int x,y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}