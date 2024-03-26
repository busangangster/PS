import java.io.*;
import java.util.*;

public class Main {
	static int N,INF;
	static int[][] arr;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int cnt;
	static int[][] min_dis;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		INF = Integer.MAX_VALUE;
		cnt = 1;
		
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			else {
				
				arr = new int[N][N];

				for (int i=0; i<N; i++) {
					st = new StringTokenizer(br.readLine());
					for (int j=0; j<N; j++) {
						arr[i][j] = Integer.parseInt(st.nextToken());
					}
				}
				dijkstra();
			}
			cnt++;
		}
		System.out.println(sb);
	}
	
	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((o1,o2) -> o1.rupee - o2.rupee);
		
		min_dis = new int[N][N];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				min_dis[i][j] = INF;
			}
		}
		
		min_dis[0][0] = arr[0][0];
		
		pq.offer(new Node(0,0,arr[0][0]));
		
		while (!pq.isEmpty()) {
			
			Node cur = pq.poll();

			if (cur.x == N-1 && cur.y == N-1) {
				sb.append("Problem").append(" ").append(cnt).append(":").append(" ").append(min_dis[N-1][N-1]);
				sb.append("\n");
			}
			
			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if (check(nx,ny)) {
					int cost = cur.rupee + arr[nx][ny];
					if (min_dis[nx][ny] > cost) {
						min_dis[nx][ny] = cost;
						pq.offer(new Node(nx,ny,cost));	
					}
				}
			}
		}
	}

	public static boolean check(int x, int y) {
		if (0<= x &&  x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}

}

class Node{
	int x;
	int y;
	int rupee;
	
	public Node(int x, int y, int rupee) {
		this.x = x;
		this.y = y;
		this.rupee = rupee;
	}
}