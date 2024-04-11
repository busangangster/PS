import java.util.*;
import java.io.*;

public class Main {
	static int N,K,ans;
	static int[] kit,used;
	static boolean[] checked;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		kit = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		
		used = new int[N];
		checked = new boolean[N];
		ans = 0;
		
		perm(0,500);
		System.out.println(ans);
	}
	
	static void perm(int cnt, int sum) {

		if (cnt == N) {
			ans++;
			return;
		}
		
		for (int i=0; i<N; i++) {
			
			if (checked[i]) continue;
			
			if (sum+kit[i] - K >= 500) {
				checked[i] = true;
				perm(cnt+1,sum+kit[i]-K);
				checked[i] = false;
			}
			
		}
	}	
}