import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] first = new int[N][M];
		int[][] second = new int[N][M];
		int[][] ans = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j < M; j++) {
				first[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j < M; j++) {
				second[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j < M; j++) {
				ans[i][j] = first[i][j] + second[i][j];
			}
		}
		for (int[] x: ans) {
			for (int k=0; k<x.length; k++) {
				sb.append(x[k]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}