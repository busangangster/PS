import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		int si = Integer.parseInt(st.nextToken());
		int bun = Integer.parseInt(st.nextToken());
		int tmp = 0;
		if (si != 0) {
			tmp += 60 * si;
		}
		else {
			tmp += 60*24;
		}
		tmp += bun;
		tmp -= 45;
		sb.append(tmp/60 == 24 ? 0 : tmp/60).append(" ").append(tmp%60);
		System.out.println(sb);
	}
}