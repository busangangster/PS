import java.io.*;
import java.util.*;

public class Solution {
    static int N,M,K;
    static ArrayList<micro> arr;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc=1; tc<=t; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new ArrayList<>();

            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken())-1;
                arr.add(new micro(x, y, m, d));
            }

            for (int i=0 ; i<M; i++) {
                move();
            }
            int ans = 0;
            for (int i=0; i<arr.size(); i++) {
                ans += arr.get(i).m;
            }
            // arr.clear();
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);

    }

    static void move() {
        int arrSize = arr.size();
        for (int i=0; i<arrSize; i++) {
            micro cur = arr.get(i);
            cur.x = cur.x + dx[cur.d];
            cur.y = cur.y + dy[cur.d];

            if (check(cur.x,cur.y)) {
                cur.d = changeDirection(cur.d);
                cur.m = cur.m/2;
                if (cur.m == 0) {
                    arr.remove(i);
                    
                }

            }
        }

        Collections.sort(arr);

        for (int i=0; i<arr.size()-1; i++) {
            micro tmp = arr.get(i);
            for (int j = i+1; j<arr.size(); j++) {
                micro next = arr.get(j);

                if (tmp.x == next.x && tmp.y == next.y) {
                    tmp.m += next.m;
                    arr.remove(j);
                    j--; // 리스트에서 값이 제거될 때, 인덱스도 하나씩 감소시켜주기 !! 기억 !! 
                }
            }
        }

    }

    static class micro implements Comparable<micro>{
        int x,y,m,d;
        public micro(int x, int y, int m, int d){
            this.x = x;
            this.y = y;
            this.m = m;
            this.d = d;
        }
        @Override
        public int compareTo(micro o) {
            return o.m - this.m;
        }
    }

    static boolean check(int x, int y) {
        if (x == 0 || x == N-1 || y == 0 || y == N-1) return true; // 방향 바꿔야함 
        else return false; // 안바꿔도 됨 
    }
    
    static int changeDirection(int d) {
        switch (d) {
            case 0:
                return 1;

            case 1:
                return 0;

            case 2:
                return 3;

            case 3:
                return 2;
        }
        return -1;
    }
}