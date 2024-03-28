import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] dist = new int[n+1][n+1];
		int INF = 100000*100+1;
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				if (i == j) {
					dist[i][j] = 0;
					continue;
				}
				dist[i][j] = INF;
			}
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dist[a][b] = Math.min(dist[a][b], c);
		}
		
		for (int k=1; k<=n; k++) {
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);

				}
			}
		}
		
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				if(dist[i][j] == INF) {
					sb.append(0);
				}
				else {
					sb.append(dist[i][j]);
				}
				sb.append(" ");

			}
			sb.append("\n");
		}
		System.out.println(sb);

	}
}