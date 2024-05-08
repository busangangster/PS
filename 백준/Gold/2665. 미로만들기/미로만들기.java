import java.io.*;
import java.util.*;

public class Main {
	static int N,INF;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];		
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<N; j++) {
				graph[i][j] = s.charAt(j)-'0';
			}
		}
		
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		Deque<Node> dq = new ArrayDeque<>();
		dq.offer(new Node(0,0,0));
		visited = new boolean[N][N];
		visited[0][0] = true;
		
		while (!dq.isEmpty()) {
			Node cur = dq.poll();
			
			if (cur.x == N-1 && cur.y == N-1) {
				return cur.cost;
			}
			
			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (!check(nx,ny)) continue;
				if (visited[nx][ny]) continue;
				
				if (graph[nx][ny] == 1) {
					dq.addFirst(new Node(nx,ny,cur.cost));
				}
				else if (graph[nx][ny] == 0) {
					dq.add(new Node(nx,ny,cur.cost+1));
				}
				visited[nx][ny] = true;
			}
		}
		return 0;
	}
	
	static boolean check(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) return true;
		else return false;
	}
	
	static class Node{
		int x,y,cost;
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}