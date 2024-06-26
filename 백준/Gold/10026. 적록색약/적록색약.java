import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static char[][] graph,copy;
	static boolean[][] visited1,visited2;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		graph = new char[N][N];
		copy = new char[N][N];
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<N; j++) {
				graph[i][j] = s.charAt(j);
				if (graph[i][j] == 'R') {
					copy[i][j] = 'G';
				}
				else {
					copy[i][j] = graph[i][j];
				}
			}
		}
				
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i=0;i <N; i++) {
			for (int j=0; j<N; j++) {
				if (!visited1[i][j]) {
					bfs(i,j,graph,visited1);
					cnt1++;
				}
				if (!visited2[i][j]) {
					bfs(i,j,copy,visited2);
					cnt2++;
				}
			}
		}
		System.out.println(cnt1 + " " + cnt2);
	}
	
	static void bfs(int x, int y, char[][] arr, boolean[][] visit) {
		Queue<Node> q = new ArrayDeque<>();
		visit[x][y] = true;
		q.offer(new Node(x,y));
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (!check(nx,ny)) continue;
				if (visit[nx][ny]) continue;
				
				if (arr[cur.x][cur.y]== arr[nx][ny]) {
					q.offer(new Node(nx,ny));
					visit[nx][ny] = true;
				}
			}
		}
		
	}
	
	static boolean check(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) return true;
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