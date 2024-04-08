import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Dot> arr = new ArrayList<>();
		
		for (int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new Dot(x,y));
		}
		
		Collections.sort(arr);
		
		for (Dot cur: arr) {
			sb.append(cur.x).append(" ").append(cur.y).append("\n");
		}
		System.out.println(sb);
	}
	static class Dot implements Comparable<Dot>{
		int x,y;
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Dot o) {
			if (this.y == o.y) {
				return this.x - o.x;
			}
			return this.y - o.y;
		}
	}
}