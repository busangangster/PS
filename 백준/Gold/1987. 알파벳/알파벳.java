import java.util.*;
import java.io.*;

public class Main {
	static int N,M;
	static char[][] arr;
	static HashSet<Character> alpha = new HashSet<Character>();
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		ans = 0;
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<M; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		alpha.add(arr[0][0]);
		DFS(0,0,1);
		System.out.println(ans);
		
	}
	
	public static void DFS(int x,int y,int cnt) {
		ans = Math.max(ans, cnt);
		
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			
			if (0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (!alpha.contains(arr[nx][ny])) {
					
					alpha.add(arr[nx][ny]);
					DFS(nx,ny,cnt+1);
					alpha.remove(arr[nx][ny]);
				}
			}
		}
	}
}