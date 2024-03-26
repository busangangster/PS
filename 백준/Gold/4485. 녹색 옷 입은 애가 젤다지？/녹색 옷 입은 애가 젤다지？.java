import java.io.*;
import java.util.*;

public class Main {
	static int n,cnt,INF;
	static int[][] graph,min_dis;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		cnt = 1;
		INF = Integer.MAX_VALUE;
		
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) break;
			else {
				graph = new int[n][n];
				
				for (int i=0; i<n; i++) {
					st = new StringTokenizer(br.readLine());
					for (int j=0; j<n; j++) {
						graph[i][j] = Integer.parseInt(st.nextToken());
					}
				}
//				System.out.println(Arrays.deepToString(graph));
				dijkstra(cnt);

			}
			cnt++;
			
		}
		System.out.println(sb);
		
	}
	
	public static void dijkstra(int cnt) {
		PriorityQueue<Node> pq = new PriorityQueue<>(); 
		min_dis = new int[n][n];
		for (int[] next: min_dis) {
			Arrays.fill(next, INF);
		}
		pq.offer(new Node(0,0,graph[0][0]));
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (cur.x == n-1 && cur.y == n-1) {
				sb.append("Problem").append(" ").append(cnt).append(": ").append(cur.c).append("\n");
			}
			
			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (check(nx,ny)) {
					int cost = cur.c + graph[nx][ny];
					if (min_dis[nx][ny] > cost) {
						min_dis[nx][ny] = cost;
						pq.offer(new Node(nx,ny,cost));
					}
				}
			}
			
		}
	}
	
	public static boolean check(int x, int y) {
		if (0 <= x && x < n && 0 <= y && y < n) return true;
		else return false;
	}
	
}

class Node implements Comparable<Node>{
	int x,y,c;
	public Node(int x, int y, int c) {
		this.x = x;
		this.y = y ;
		this.c = c;
	}
	@Override
	public int compareTo(Node o) {
		return this.c - o.c;
	}
}