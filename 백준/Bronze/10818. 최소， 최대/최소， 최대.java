import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int max_v = Integer.MIN_VALUE;
		int min_v = Integer.MAX_VALUE; 
		for (int i=0;i <n; i++) {
			int k = Integer.parseInt(st.nextToken());
			max_v = Math.max(max_v, k);
			min_v = Math.min(min_v, k);
		}
		sb.append(min_v).append(" ").append(max_v);
		System.out.println(sb);
	}
}