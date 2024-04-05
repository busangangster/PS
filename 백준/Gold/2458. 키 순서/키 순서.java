import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M,tCnt,sCnt;
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int ans = 0;
		int cnt = 0;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());	
			arr[a][b] = 1;
		}
		
		for (int i=1; i<N+1; i++) {
			tCnt = 0;
			sCnt = 0;
			taller(i);
			smaller(i);
			if (tCnt + sCnt == N-1) cnt++;
		}
		System.out.println(cnt);
	}
	
	static void taller(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(start);
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int tmp = q.poll();
			
			for (int i=1; i<N+1; i++) {
				if (arr[tmp][i] == 1 && !visited[i]) {
					tCnt++;
					visited[i] = true;
					q.offer(i);
				}
			}	
		}
	}
	
	static void smaller(int start) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		q.offer(start);
		boolean[] visited = new boolean[N+1];
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int tmp = q.poll();
			
			for (int i=1; i<N+1; i++) {
				if (arr[i][tmp] == 1 && !visited[i]) {
					sCnt++;
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
}