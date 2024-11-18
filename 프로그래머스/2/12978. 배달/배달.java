import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int INF = 20000001; // 최대 거리보다 큰 값으로 설정
        int[] min_dis = new int[N + 1];
        ArrayList<ArrayList<Node>> arr = new ArrayList<>();

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        // 도로 정보 추가
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];

            boolean isUpdated = false;

            // a에서 b로 가는 기존 도로 중 최소 시간으로 업데이트
            for (Node node : arr.get(a)) {
                if (node.node == b) {
                    if (node.time > c) {
                        node.time = c;
                    }
                    isUpdated = true;
                    break;
                }
            }
            if (!isUpdated) {
                arr.get(a).add(new Node(b, c));
            }

            isUpdated = false;

            // b에서 a로 가는 기존 도로 중 최소 시간으로 업데이트
            for (Node node : arr.get(b)) {
                if (node.node == a) {
                    if (node.time > c) {
                        node.time = c;
                    }
                    isUpdated = true;
                    break;
                }
            }
            if (!isUpdated) {
                arr.get(b).add(new Node(a, c));
            }
        }

        // 다익스트라 알고리즘 실행
        dijkstra(1, arr, min_dis, INF);

        // 결과 계산
        for (int i = 1; i <= N; i++) {
            if (min_dis[i] <= K) answer++;
        }

        return answer;
    }

    public void dijkstra(int start, ArrayList<ArrayList<Node>> arr, int[] min_dis, int INF) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        Arrays.fill(min_dis, INF);

        pq.offer(new Node(start, 0));
        min_dis[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (min_dis[cur.node] < cur.time) continue;

            for (Node next : arr.get(cur.node)) {
                if (min_dis[next.node] > min_dis[cur.node] + next.time) {
                    min_dis[next.node] = min_dis[cur.node] + next.time;
                    pq.offer(new Node(next.node, min_dis[next.node]));
                }
            }
        }
    }
}

class Node {
    int node;
    int time;

    public Node(int node, int time) {
        this.node = node;
        this.time = time;
    }
}
