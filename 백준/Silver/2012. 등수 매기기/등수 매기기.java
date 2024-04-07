import java.io.*;
import java.util.*;
 
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		int cnt = 1;
		for (int i=0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		long ans = 0;
	
		int rate = 1;
		for (int i=0; i<n; i++) {
			ans += Math.abs(rate-arr[i]);
			rate+= 1;
		}

		System.out.println(ans);
	}
}