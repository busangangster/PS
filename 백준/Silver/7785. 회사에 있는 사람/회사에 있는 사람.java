import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		HashMap<String, Integer> hs = new HashMap<>();
		ArrayList<String> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String cmd = st.nextToken();
			if (cmd.equals("enter")) {
				hs.put(name, 1);
			} else if (cmd.equals("leave")) {
				if (hs.containsKey(name)) {
					hs.put(name, 0);
				}
			}
		}
		for (String key : hs.keySet()) {
			if (hs.get(key) == 1) {
				ans.add(key);
			}
		}
		Collections.sort(ans, Collections.reverseOrder());

		for (String x : ans) {
			System.out.println(x);
		}
	}

}