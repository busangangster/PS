import java.io.*;
import java.util.*;
public class Main {
	static int N,cnt;
	static int[][] graph;
	static ArrayList<Integer> arr;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		arr = new ArrayList<>();
		visited = new boolean[N][N];
		cnt = 0;
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<N; j++) {
				graph[i][j] = s.charAt(j)-'0';
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (graph[i][j] != 0 && !visited[i][j]) {
					cnt++;
					int tmp = bfs(i,j,cnt);
					arr.add(tmp);
				}
			}
		}
		Collections.sort(arr);
		System.out.println(cnt);
		for (int x: arr) {
			System.out.println(x);
		}
		
	}
	
	static int bfs(int x, int y, int c) {
		Queue<Node> q = new ArrayDeque<Node>();
		visited[x][y] = true;
		q.offer(new Node(x,y,c));
		int ans = 1;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (!check(nx,ny)) continue;
				if (visited[nx][ny]) continue;
				if (graph[nx][ny] == 0) continue;
				
				graph[nx][ny] = cur.c;
				q.offer(new Node(nx,ny,cur.c));
				visited[nx][ny] = true;
				ans ++;
				
			}
		}
		return ans;
	}
	
	static boolean check(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y <N) return true;
		else return false;
	}
	
	static class Node{
		int x, y, c;
		public Node(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}