import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cnt = 0;
        int weight = 0;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(0);
        }
        else {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int k = Integer.parseInt(st.nextToken());
                if (weight + k > M) {
                    cnt++;
                    weight = k;
                } else if (weight + k < M) {
                    weight += k;
                } else if (weight + k == M) {
                    cnt++;
                    weight = 0;
                }
            }
            System.out.println(weight == 0 ? cnt : cnt+1);
        }
    }
}