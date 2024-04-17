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
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<M; j++) {
				graph[i][j] = s.charAt(j) -'0';
			}
		}
		bfs();
		System.out.println(graph[N-1][M-1]);
			
	}
	
	static void bfs() {
		Queue<Node> q = new ArrayDeque<Node>();
		visited = new boolean[N][M];
		visited[0][0] = true;
		q.offer(new Node(0,0,1));
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if (cur.x == N-1 && cur.y == M-1) {
				return;
			}
			
			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (!check(nx,ny)) continue;
				if (visited[nx][ny]) continue;
				
				if (graph[nx][ny] == 1) {
					visited[nx][ny] = true;
					graph[nx][ny] = cur.cnt+1;
					q.offer(new Node(nx,ny,cur.cnt+1));
				}
			}
		}
	}
	
	static boolean check(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) return true;
		else return false;
	}
	
	static class Node{
		int x,y,cnt;
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

}