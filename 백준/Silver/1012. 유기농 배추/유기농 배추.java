import java.io.*;
import java.util.*;
public class Main {
	static int M,N,K;
	static int[][] graph;
	static boolean[][] visited;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
			
		int t = Integer.parseInt(br.readLine());
		
		for (int tc=0; tc<t; tc++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			graph = new int[N][M];
			visited = new boolean[N][M];
			int cnt = 0;
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				graph[x][y] = 1;
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (graph[i][j] == 1 && !visited[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
			
		}
		System.out.println(sb);
		
	}
	
	static void bfs(int x, int y) {
		Queue<Node> q = new ArrayDeque<Node>();

		visited[x][y] = true;
		q.offer(new Node(x,y));
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (!check(nx,ny)) continue;
				if (visited[nx][ny]) continue;
				
				if (graph[nx][ny] == 1) {
					visited[nx][ny] = true;
					q.offer(new Node(nx,ny));
				}
			}
		}
	}
	
	static boolean check(int x, int y) {
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