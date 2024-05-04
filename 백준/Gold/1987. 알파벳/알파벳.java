import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
	static int R,C,max_v;
	static char[][] graph;

	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static HashSet<Character> ans = new HashSet<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken()); 

		graph = new char[R][C];
		max_v = Integer.MIN_VALUE;

		for (int i=0; i<R; i++) {
			String s = br.readLine();
			for (int j=0; j<C; j++) {
				graph[i][j] = s.charAt(j);
			}
		}
		ans.add(graph[0][0]);

		dfs(0,0,1);
		System.out.println(max_v);

	}

	static void dfs(int x, int y, int cnt) {

		max_v = Math.max(cnt,max_v);

		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!check(nx,ny)) continue;

			if (!ans.contains(graph[nx][ny])) {

				ans.add(graph[nx][ny]);
				dfs(nx,ny,cnt+1);
				ans.remove(graph[nx][ny]);

			}
		}
	}

	static boolean check(int x, int y) {
		if (0 <= x && x < R && 0 <= y && y < C) return true;
		else return false;
	}

}