import java.io.*;
import java.util.*;

class Main {
	static int N, M;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selected = new int[M];

		comb(0, 1);
		System.out.println(sb);
	}

	static void comb(int cnt, int start) {
		if (cnt == M) {
			for (int x : selected) {
				sb.append(x).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {

			selected[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}
}