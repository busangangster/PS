import java.io.*;
import java.util.*;
 
class Main {
	static int N;
	static int[][] map;
	static ArrayList<ArrayList<Integer>> arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int k=0; k<N; k++) {
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (map[i][k]==1 && map[k][j]==1) {
						map[i][j] = 1;
					}
				}
			}
		}
		for (int[] x : map) {
			for (int val : x ) {
				sb.append(val).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	
}