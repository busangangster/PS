import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new ArrayDeque<Integer>();
		ArrayList<Integer> ans = new ArrayList<>();
		
		for (int i=1; i<=N;i++) {
			q.add(i);
		}
		
		int cnt = 1;
		while (!q.isEmpty()) {
			if (cnt == K) {
				ans.add(q.poll());
				cnt = 1;
			}
			else {
				q.add(q.poll());
				cnt++;
			}


		}
		sb.append("<");
		for (int i=0; i<N; i++) {
			if (i == N-1) {
				sb.append(ans.get(i));
			}
			else {
				sb.append(ans.get(i)).append(", ");

			}
		}
		sb.append(">");
		System.out.println(sb);
	}
}