import java.io.*;
import java.util.*;
 
class Main {
    static List<ArrayList<Integer>> list;
    static int ans[];
    static int n, m;
    static boolean visit[];
    public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

		Deque<Integer> dq = new ArrayDeque<>();
        
		int n = Integer.parseInt(br.readLine());
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			if (cmd.equals("push_back")){
				int k = Integer.parseInt(st.nextToken());
				dq.addLast(k);
			}
			else if (cmd.equals("push_front")) {
				int k = Integer.parseInt(st.nextToken());
				dq.addFirst(k);
			}
			else if (cmd.equals("pop_front")) {
				if (!dq.isEmpty()) System.out.println(dq.pollFirst());
				else System.out.println(-1);
			}
			else if (cmd.equals("pop_back")) {
				if (!dq.isEmpty()) System.out.println(dq.pollLast());
				else System.out.println(-1);
			}
			else if (cmd.equals("size")) {
				System.out.println(dq.size());
			}
			else if (cmd.equals("empty")) {
				if (!dq.isEmpty()) System.out.println(0);
				else System.out.println(1);
			}
			else if (cmd.equals("front")) {
				if (!dq.isEmpty()) System.out.println(dq.peekFirst());
				else System.out.println(-1);
			}
			else if (cmd.equals("back")) {
				if (!dq.isEmpty()) System.out.println(dq.peekLast());
				else System.out.println(-1);
			}
		}
	}
}