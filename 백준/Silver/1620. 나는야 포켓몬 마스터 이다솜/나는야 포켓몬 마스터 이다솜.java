import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String,String> hm = new HashMap<>();
		
		for (int i=1; i<=N; i++) {
			String s = br.readLine();
			hm.put(String.valueOf(i), s);
			hm.put(s, String.valueOf(i));
		}
		
		for (int i=0; i<M; i++) {
			String cmd = br.readLine();
			sb.append(hm.get(cmd)).append("\n");
		}
		
		System.out.println(sb);
	}
}