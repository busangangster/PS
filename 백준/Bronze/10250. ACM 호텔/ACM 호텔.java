import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int floor = N % H;
			int ho = N / H;
			if (floor == 0) {
				floor = H;
			}
			else {
				ho += 1;
			}
			sb.append(floor).append(ho <= 9 ? "0" + ho : ho).append("\n");
		}
		System.out.println(sb);
	}
}