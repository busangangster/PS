import java.io.*;
import java.util.*;
public class Main {
	static int N,M;
	static ArrayList<ArrayList<Integer>> arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
			
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[N+1];
		int cnt = 0;
		
		for (int i=0; i<=N; i++) {
			arr.add(new ArrayList<>());
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr.get(u).add(v);
			arr.get(v).add(u);
		}
		
		for (int i=1; i<=N; i++) {
			if (!visited[i]) {
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);

	}
	
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		visited[start] = true;
		q.offer(start);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int next: arr.get(cur)) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
	}
}