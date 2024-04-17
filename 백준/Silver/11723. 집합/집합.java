import java.io.*;
import java.util.*;
 
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		HashSet<Integer> hs = new HashSet<>();

		int M = Integer.parseInt(br.readLine());
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (s.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				hs.add(x);
			}
			else if (s.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				hs.remove(x);
			}
			else if (s.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				if (hs.contains(x)) sb.append(1);
				else sb.append(0);
				sb.append("\n");
			}
			else if (s.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				if (hs.contains(x)) hs.remove(x);
				else hs.add(x);
			}
			else if (s.equals("all")) {
				for (int j=1; j<=20; j++) {
					hs.add(j);
				}
			}
			else if (s.equals("empty")) {
				hs = new HashSet<>();
			}
		}
		System.out.println(sb);
	}

}