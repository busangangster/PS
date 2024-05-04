import java.util.*;
import java.io.*;

class Main {
    static int N,islandNum,min_v;
	static int[][] graph;
	static boolean[][] visited;
	static boolean[][] checked;

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		graph = new int[N][N];
		visited = new boolean[N][N];
		islandNum = 1;
		min_v = Integer.MAX_VALUE;

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (!visited[i][j] && graph[i][j] == 1) {
					graph[i][j] = islandNum;
					findIsland(i,j);
					islandNum++;
				}
			}
		}
		// for (int[] x: graph) {
		// 	System.out.println(Arrays.toString(x));
		// }
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (graph[i][j] != 0) {
					bfs(i,j);
				}
			}
		}
		System.out.println(min_v);
	}

	static void bfs(int x, int y){
		Queue<Node> q = new ArrayDeque<>();
		checked = new boolean[N][N];
		checked[x][y] = true;
		q.offer(new Node(x,y,0));

		while (!q.isEmpty()){
			Node cur = q.poll();

			if (graph[cur.x][cur.y] != 0 && graph[cur.x][cur.y] != graph[x][y]) {
				min_v = Math.min(cur.cnt-1,min_v);
			}

			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (!check(nx, ny)) continue;
				if (checked[nx][ny]) continue;
				if (graph[nx][ny] == graph[x][y]) continue;

				q.offer(new Node(nx,ny,cur.cnt+1));
				checked[nx][ny] = true;
				
			}
		}

	}

	static void findIsland(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		visited[x][y] = true;
		q.offer(new Node(x,y));

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i=0; i <4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (!check(nx,ny)) continue;
				if (visited[nx][ny]) continue;

				if (graph[nx][ny] == 1) {
					graph[nx][ny] = islandNum;
					visited[nx][ny] = true;
					q.offer(new Node(nx,ny));
				}
			}
		}

	}

	static boolean check(int x, int y){
		if (0 <= x && x < N && 0 <= y && y < N) return true;
		else return false;
	}

	static class Node{
		int x,y,cnt;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}