import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<Node> village;
	static long sum = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		
		village = new ArrayList<Node>();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int area = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());
			village.add(new Node(area,people));
			sum += people;
		}
		
		Collections.sort(village);
		long ans = 0;
		
		for (int i=0; i<N; i++) {
			ans += village.get(i).p;
			if (ans >= (sum+1)/2) {
				System.out.println(village.get(i).n);
				break;
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int n,p;
		public Node(int n, int p) {
			this.n = n;
			this.p = p;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.n - o.n;
		}
	}
}