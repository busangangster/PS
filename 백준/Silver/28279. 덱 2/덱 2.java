import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 1:
                    int val = Integer.parseInt(st.nextToken());
                    dq.addFirst(val);
                    break;
                case 2:
                    int v = Integer.parseInt(st.nextToken());
                    dq.add(v);
                    break;
                case 3:
                    if (dq.isEmpty())
                        sb.append(-1);
                    else
                        sb.append(dq.pollFirst());

                    sb.append("\n");
                    break;
                case 4:
                    if (dq.isEmpty())
                        sb.append(-1);

                    else
                        sb.append(dq.pollLast());
                    sb.append("\n");
                    break;
                case 5:
                    sb.append(dq.size());
                    sb.append("\n");
                    break;
                case 6:
                    if (dq.isEmpty())
                        sb.append(1);
                    else
                        sb.append(0);
                    sb.append("\n");
                    break;
                case 7:
                    if (dq.isEmpty())
                        sb.append(-1);

                    else
                        sb.append(dq.peekFirst());
                    sb.append("\n");
                    break;
                case 8:
                    if (dq.isEmpty())
                        sb.append(-1);

                    else
                        sb.append(dq.peekLast());
                    sb.append("\n");
                    break;

            }

        }
        System.out.println(sb);
        
    }
}