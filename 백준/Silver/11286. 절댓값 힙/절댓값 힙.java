import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if (tmp == 0) {
				if (pq.isEmpty()) {
					sb.append(0);
				}
				else {
					sb.append(pq.poll().y);
				}
				sb.append("\n");
			}
			else {
				pq.offer(new Pos(Math.abs(tmp),tmp));
			}
		}
		System.out.println(sb);
	}
	static class Pos implements Comparable<Pos>{
		int x,y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pos o) {
			if (this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
	}
}