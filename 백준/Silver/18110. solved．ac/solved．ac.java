import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int avg = (int) Math.round(n*0.15);
		Arrays.sort(arr);
		double ans = 0;
		int cnt = 0;
		for (int i=0+avg; i<n-avg; i++) {
			ans +=arr[i];
			cnt++;
		}

		ans =  Math.round(ans/cnt);
		System.out.println((int)ans);
	}
}