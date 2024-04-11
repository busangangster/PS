import java.util.*;
import java.io.*;

public class Main {
	static int N,max_v;
	static int[] arr,used;
	static boolean[] isSelected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		used = new int[N];
		isSelected = new boolean[N];
		max_v = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		perm(0);
		
		System.out.println(max_v);
	}
	
	static void perm(int cnt) {
		int ans = 0;
		if (cnt == N) {
			for (int i=0; i<N-1; i++) {
				ans += Math.abs(used[i]-used[i+1]);
			}
			max_v = Math.max(max_v, ans);
			return;
		}
		
		for (int i=0; i<N; i++) {
			
			if (isSelected[i]) continue;
			
			used[cnt] = arr[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
			
		}
	}
}