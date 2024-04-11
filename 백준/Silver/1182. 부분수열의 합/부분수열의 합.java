import java.util.*;
import java.io.*;

public class Main {
	static int N,S,ans;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		ans = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0,0);
		
		if (S == 0 ) {
			ans--;
		}
		System.out.println(ans);
		
	}
	
	static void subset(int cnt,int sum) {
		if (cnt == N) {
			if (sum == S) {
				ans++;
			}
			return;
		}
		
		subset(cnt+1,sum+arr[cnt]);
		subset(cnt+1,sum);
		
	}
	
}