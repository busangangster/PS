import java.io.*;
import java.util.*;
 
class Solution {
	static int N,M,k,max_v;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			max_v = Integer.MIN_VALUE;

			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					bfs(i,j);
				}
			}
			sb.append("#").append(tc).append(" ").append(max_v).append("\n");
		}
		System.out.println(sb);
	
	}

	static void bfs(int x, int y){
		Queue<Node> q = new ArrayDeque<>();
		int k = 1;
		int house = 0;
		visited = new boolean[N][N];
		q.offer(new Node(x,y));
		visited[x][y] = true;
		

		while (!q.isEmpty()) {
			int cost = k*k + (k-1) * (k-1);
			int qSize = q.size();

			while (qSize --> 0) {
				Node cur = q.poll();

				if (map[cur.x][cur.y]== 1) {
					house++;
				}

				for (int i=0; i<4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];

					if (!check(nx,ny)) continue;
					if (visited[nx][ny]) continue;

					visited[nx][ny] = true;
					q.offer(new Node(nx,ny));
				}
			}

			if (cost <= M*house) {
				max_v = Math.max(house,max_v);
			}

			k++;
		}
	}

	static boolean check(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) return true;
		else return false;
	}

	static class Node{
		int x,y;
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}