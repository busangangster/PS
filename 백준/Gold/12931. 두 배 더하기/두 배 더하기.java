import java.io.*;
import java.util.*;

class Main { 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;
		int max_v = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			int cnt =0;
			while (arr[i] != 0 ) {
				if (arr[i]  % 2 == 0 ){
					arr[i] = arr[i]/2;
					cnt++;
				}
				else {
					arr[i]-= 1;
					ans++;
				}
			}
			max_v= Math.max(max_v, cnt);
		}
		ans += max_v;
		System.out.println(ans);	
	}	
}