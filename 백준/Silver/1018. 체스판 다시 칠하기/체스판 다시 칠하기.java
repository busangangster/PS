import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[N][M];
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<M; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		int min_v = Integer.MAX_VALUE;
		
		for (int i=0; i<N-7; i++) {
			for (int j=0; j<M-7; j++) {
				for (int k=0; k<2; k++) {
					int cnt = 0;
					char start = k == 0 ? 'W':'B';
					
					for (int t=i; t < i+8; t++) {
						for (int p=j; p < j+8; p++) {
							if (start != arr[t][p]) {
								cnt++;
							}
							start = start == 'W'? 'B':'W';
						}
						start = start == 'W'? 'B':'W';
					}
					min_v = Math.min(min_v, cnt);
				}
			}
		}
		System.out.println(min_v);

	}
}