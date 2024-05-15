import java.io.*;
import java.util.*;

class Main {
	static int N, M, INF, y;
	static int[] min_dis;
	static ArrayList<ArrayList<Node>> arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new ArrayList<ArrayList<Node>>();
		INF = 10000 * 200000 + 1;

		for (int i = 0; i <= N; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr.get(u).add(new Node(v, w));
		}

		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());

		int[] toY = dijkstra(x);
		int[] toZ = dijkstra(y);

		if (toY[y] == INF || toZ[z] == INF) {
			sb.append(-1).append(" ");
		} else {
			sb.append(toY[y] + toZ[z]).append(" ");
		}

		int[] tmp = dijkstra2(x);
		long second = tmp[z];
		sb.append(second == INF ? -1 : second);
		System.out.println(sb);
	}

	static int[] dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		min_dis = new int[N + 1];
		Arrays.fill(min_dis, INF);
		min_dis[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (min_dis[cur.node] < cur.cost)
				continue;

			for (Node next : arr.get(cur.node)) {
				if (min_dis[next.node] > cur.cost + next.cost) {
					min_dis[next.node] = cur.cost + next.cost;
					pq.offer(new Node(next.node, cur.cost + next.cost));
				}
			}
		}
		return min_dis;
	}

	static int[] dijkstra2(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		min_dis = new int[N + 1];
		Arrays.fill(min_dis, INF);
		min_dis[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (min_dis[cur.node] < cur.cost)
				continue;

			for (Node next : arr.get(cur.node)) {
				if (next.node == y)
					continue;
				if (min_dis[next.node] > cur.cost + next.cost) {
					min_dis[next.node] = cur.cost + next.cost;
					pq.offer(new Node(next.node, cur.cost + next.cost));
				}
			}
		}
		return min_dis;
	}

	static class Node implements Comparable<Node> {
		int node, cost;

		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

}