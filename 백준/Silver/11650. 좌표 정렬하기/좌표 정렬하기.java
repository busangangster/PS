import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Map> arr = new ArrayList<>();
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr.add(new Map(x,y));
			
		}
		Collections.sort(arr);
		
		for (Map x: arr) {
			sb.append(x.x).append(" ").append(x.y).append("\n");
		}
		System.out.println(sb);
	}
	
	static class Map implements Comparable<Map>{
		int x,y;
		public Map(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Map o) {
			if (this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
	}
}