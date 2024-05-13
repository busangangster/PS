import java.io.*;
import java.util.*;

public class Main {
	static int R, C, cur_x, cur_y;
	static char[][] graph;
	static boolean[][] visited;
	static ArrayList<Character> commands;
	static int[] dx = { -1, 1, 0, 0 }; // 상,하,좌,우
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		graph = new char[R][C];
		commands = new ArrayList<>();
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				graph[i][j] = s.charAt(j);
			}
		}

		st = new StringTokenizer(br.readLine());
		cur_x = Integer.parseInt(st.nextToken()) - 1;
		cur_y = Integer.parseInt(st.nextToken()) - 1;

		String cmd = br.readLine();
		for (int i = 0; i < cmd.length(); i++) {
			commands.add(cmd.charAt(i));
		}

		int cnt = 0;

		while (true) {
			if (cnt == commands.size())
				break;

			if (commands.get(cnt) == 'W') {
				bfs();
			} else {
				move(commands.get(cnt));
			}
			cnt++;
		}

		// 최종 위치에서 주변 밝히기
		graph[cur_x][cur_y] = '.';
		for (int i = 0; i < 4; i++) {
			int nx = cur_x + dx[i];
			int ny = cur_y + dy[i];
			if (!check(nx, ny))
				continue;
			
			if (graph[nx][ny] != graph[cur_x][cur_y]) {
				graph[nx][ny] = '.';
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (graph[i][j] == '.') {
					sb.append('.');
				} else {
					sb.append('#');
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

	static void move(char d) {
		if (d == 'U') {
			cur_x += dx[0];
			cur_y += dy[0];
		} else if (d == 'D') {
			cur_x += dx[1];
			cur_y += dy[1];
		} else if (d == 'L') {
			cur_x += dx[2];
			cur_y += dy[2];
		} else if (d == 'R') {
			cur_x += dx[3];
			cur_y += dy[3];
		}
	}

	static boolean check(int x, int y) {
		if (0 <= x && x <= R - 1 && 0 <= y && y <= C - 1)
			return true;
		else
			return false;
	}

	static void bfs() {
		Queue<Node> q = new ArrayDeque<Node>();
		visited[cur_x][cur_y] = true;
		q.offer(new Node(cur_x, cur_y));

		char alpha = graph[cur_x][cur_y];
		graph[cur_x][cur_y] = '.';

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (!check(nx, ny))
					continue;
				if (visited[nx][ny])
					continue;

				if (alpha == graph[nx][ny]) {
					visited[nx][ny] = true;
					graph[nx][ny] = '.';
					q.offer(new Node(nx, ny));
				}
			}
		}
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}