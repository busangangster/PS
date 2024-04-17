import java.io.*;
import java.util.*;
public class Main {
	
	static int N,M,target_x,target_y;
	static boolean[][] visited;
	static int[][] graph;
	static int[][] ans;
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
		ans = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 2) {
					target_x = i;
					target_y = j;
				}
			}
		}
		
		for (int i=0;i <N; i++) {
			for (int j= 0; j<M; j++) {
				if (graph[i][j] == 1) {
					graph[i][j] = -1;
				}
			}
		}
		bfs();
		for (int[] x : graph) {
			for (int val : x) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
	static void bfs() {
		Queue<Node> q = new ArrayDeque<Node>();
		visited = new boolean[N][M];
		visited[target_x][target_y] = true;
		q.offer(new Node(target_x,target_y,0));
		graph[target_x][target_y] = 0;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (!check(nx,ny)) continue;
				if (visited[nx][ny]) continue;
				
				if (graph[nx][ny] == -1) {
					visited[nx][ny] = true;
					graph[nx][ny] = cur.dis +1;
					q.offer(new Node(nx,ny,cur.dis+1));
				}
				else if (graph[nx][ny] == 0) {
					visited[nx][ny] = true;
				}
 			}
		}
	}
	
	static boolean check(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) return true;
		else return false;
	}
	
	static class Node{
		int x,y,dis;
		public Node(int x, int y, int dis) {
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}
}