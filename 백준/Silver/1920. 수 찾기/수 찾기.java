import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer,Integer> hm = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N;i++) {
			hm.put(Integer.parseInt(st.nextToken()), 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			if (hm.containsKey(Integer.parseInt(st.nextToken()))) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.println(sb);
	}
}