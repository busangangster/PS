import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Integer[] arr = new Integer[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr, Collections.reverseOrder());

		int cnt = 0;

		for (int i = 0; i < N; i++) {
			cnt += K / arr[i];
			K = K % arr[i];
		}
		System.out.println(cnt);
	}
}