import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static int[][] graph;
	static boolean[][] visited;
	static ArrayList<Node> tomato;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		graph = new int[N][M];
		tomato = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if (graph[i][j] == 1)
					tomato.add(new Node(i, j, 0));
			}
		}

		int ans = bfs();
		if (!checkTomato()) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

	}

	static int bfs() {
		Queue<Node> q = new ArrayDeque<>();
		int tmp = 0;
		visited = new boolean[N][M];
		for (Node val : tomato) {
			q.offer(new Node(val.x, val.y, val.time));
			visited[val.x][val.y] = true;
		}

		while (!q.isEmpty()) {
			Node cur = q.poll();
			tmp = cur.time;

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (!check(nx, ny))
					continue;
				if (visited[nx][ny])
					continue;
				if (graph[nx][ny] != 0)
					continue;

				graph[nx][ny] = cur.time + 1;
				q.offer(new Node(nx, ny, cur.time + 1));
				visited[nx][ny] = true;

			}
		}
		return tmp;
	}

	static boolean checkTomato() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (graph[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean check(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M)
			return true;
		else
			return false;
	}

	static class Node {
		int x, y, time;

		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}