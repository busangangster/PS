import java.io.*;
import java.util.*;

class Main { 

	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<String> names = new ArrayList<>();
		HashMap<String,Integer> hm = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i=0; i<n+m; i++) {
			String s = br.readLine();
			hm.put(s,hm.getOrDefault(s, 0)+1);
		}
		for (String key: hm.keySet()) {
			if (hm.get(key) == 2) {
				names.add(key);
			}
		}
		Collections.sort(names);

		System.out.println(names.size());
		for (String x: names){
			System.out.println(x);
		}	
	}
}