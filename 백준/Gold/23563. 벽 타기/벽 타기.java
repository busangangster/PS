import java.util.*;
import java.io.*;

class Main {
	static int N,M,start_x,start_y,end_x,end_y,INF;
	static int[][] min_dis;
	static char[][] graph;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st;

	  st = new StringTokenizer(br.readLine());
	  N = Integer.parseInt(st.nextToken());
	  M = Integer.parseInt(st.nextToken());

	  graph = new char[N][M];
	  INF = 500*500+1;

	  for (int i=0; i<N; i++) {
		String s = br.readLine();
		for (int j=0; j<M; j++) {
			graph[i][j] = s.charAt(j);
			if (graph[i][j] == 'S') {
				start_x = i;
				start_y = j;
			}
			else if (graph[i][j] == 'E') {
				end_x = i;
				end_y = j;
			}
		}
	  }
	  System.out.println(bfs());
	}

	static int bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start_x,start_y,0));
		min_dis = new int[N][M];
		for (int[] x : min_dis) {
			Arrays.fill(x, INF);
		}
		min_dis[start_x][start_y] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			boolean currentFlag =  rockSide(cur.x, cur.y);

			if (min_dis[cur.x][cur.y] < cur.time) continue;

			for (int i=0; i<4; i++) {
				int nx = cur.x + dx[i]; 
				int ny = cur.y + dy[i];

				if (!check(nx,ny)) continue;
				if (graph[nx][ny] == '#') continue;

				boolean tmp = rockSide(nx, ny);

				if (currentFlag && tmp ) {
					if (min_dis[nx][ny] > min_dis[cur.x][cur.y]) {
						min_dis[nx][ny] =  min_dis[cur.x][cur.y];
						pq.offer(new Node(nx,ny,min_dis[nx][ny]));
					}
				}

				else  {
					if (min_dis[nx][ny] > min_dis[cur.x][cur.y]+1) {
						min_dis[nx][ny] =  min_dis[cur.x][cur.y]+1;
						pq.offer(new Node(nx,ny,min_dis[nx][ny]));
					}
				}
			}
		}
		return min_dis[end_x][end_y];
	}

	static boolean rockSide(int x, int y) {
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!check(nx,ny)) continue;
			if (graph[nx][ny] == '#') {
				return true;
			}
		}
		return false;
	}

	static boolean check(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y <M) return true;
		else return false;
	}

	static class Node implements Comparable<Node>{
		int x,y,time;
		
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
			
		}
		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
		
	}
}