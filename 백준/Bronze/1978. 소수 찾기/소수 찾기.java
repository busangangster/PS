import java.io.*;
import java.util.*;
 
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int  n = Integer.parseInt(br.readLine());
		
		int cnt = 0;

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			boolean flag = true;
			int k = Integer.parseInt(st.nextToken());
			if (k == 1) continue;
			for (int j=2; j<k ;j++) {
				if (k % j == 0) {
					flag = false;
					break;
				}

			}
			if (flag) cnt++;
		}
		System.out.println(cnt);
	}
}