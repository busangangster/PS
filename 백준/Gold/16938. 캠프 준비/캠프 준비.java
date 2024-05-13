import java.io.*;
import java.util.*;

public class Main {
	static int N,L,R,X,ans;
	static int[] level;
	static boolean[] selected;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		
		level = new int[N];
		ans = 0;
		selected = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			level[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		System.out.println(ans);

	}
	
	static void subset(int cnt) {
		if (cnt == N) {
			ArrayList<Integer> arr = new ArrayList<>();
			int tmp = 0;
			for (int i=0; i<N; i++) {
				if (selected[i]) {
					arr.add(level[i]);
					tmp += level[i];
				}
			}
			if (arr.size() <= 1) {
				return;
			}
			
			if (tmp > R || tmp < L) {
				return;
			}
			
			if (Collections.max(arr) - Collections.min(arr) < X) {
				return;
			}
			
			ans++;
			return;
		}
		
		selected[cnt] = true;
		subset(cnt+1);
		selected[cnt] = false;
		subset(cnt+1);
		
	}
}