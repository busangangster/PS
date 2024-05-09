import java.util.*;
import java.io.*;

class Main {
	static int N,M;
	static long INF;
	static long[] min_dis;
	static ArrayList<ArrayList<Node>> arr;
	static int[] code;
	static boolean[] numbers;
	public static void main(String[] args) throws Exception {
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st;

	  st = new StringTokenizer(br.readLine());
	  N = Integer.parseInt(st.nextToken());
	  M = Integer.parseInt(st.nextToken());

	  arr = new ArrayList<ArrayList<Node>>();
	  code = new int[N+1];
	  numbers = new boolean[10000001];
	  INF = 1000000L*400000L+1;  // long형에 넣을 때는 L 붙여서 int을 long형으로 만들어줘야 함 !!! 

	  for (int i=0; i<=N; i++) {
		arr.add(new ArrayList<>());
	  }

	  st = new StringTokenizer(br.readLine());
	  for (int i=1; i<=N; i++) {
		code[i] = Integer.parseInt(st.nextToken());
	  }

	  for (int i=0; i<M; i++) {
		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		arr.get(u).add(new Node(v,w));
		arr.get(v).add(new Node(u,w));
		}

		primeCheck();
		dijkstra();
		System.out.println(min_dis[N] == INF ? "Now where are you?" : min_dis[N]);

	}

	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		min_dis = new long[N+1];
		Arrays.fill(min_dis,INF);
		min_dis[1] = 0;
		pq.offer(new Node(1,0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (min_dis[cur.node] < cur.cost) continue;
			
			for (Node next: arr.get(cur.node)) {
				if (numbers[code[next.node] + code[cur.node]]) {
					if (min_dis[next.node] > cur.cost + next.cost) {
						min_dis[next.node] = cur.cost + next.cost;
						pq.offer(new Node(next.node, cur.cost+next.cost));
					}
				}	
			}
		}
	}


	static void primeCheck() {
		Arrays.fill(numbers,true);
		numbers[0] = false;
		numbers[1] = false;

		for (int i=2; i<=Math.sqrt(10000000); i++) {
			if (numbers[i]) {
				for (int j=i*i; j <= 10000000; j+=i) {
					numbers[j] = false;
				}
			}
		}
	}

	static class Node implements Comparable<Node>{
		int node;
		long cost;
		public Node(int node, long cost) {
			this.node = node;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return (int) ( (int) this.cost - o.cost);
		}
	}
}
