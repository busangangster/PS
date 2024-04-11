import java.util.*;
import java.io.*;
 
public class Solution {
     
    static int N,W,H,min_v;
    static int[][] brick,brick_copy;
    static int[] nums;
    static boolean[][] visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
     
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(br.readLine());
         
        for (int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
             
            brick = new int[H][W];
            brick_copy = new int[H][W];
            nums = new int[N];
            min_v = Integer.MAX_VALUE;
             
            for (int i=0; i<H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<W; j++) {
                    brick[i][j] =  brick_copy[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            perm(0);
            sb.append("#").append(tc).append(" ").append(min_v).append("\n");
        }
        System.out.println(sb);
         
    }
     
    public static void perm(int cnt) {
        if (cnt == N) {
            // 탐색 
            solve(nums);
            // 최솟값 찾기
        
            min_v = Math.min(min_v, brickCnt());
            // 배열 갱신
            reNew();
            return;
             
        }
         
        for (int i=0; i<W; i++) {
            nums[cnt] = i;
            perm(cnt+1);
        }
         
    }
     
     
    public static void solve(int[] arr) {
        int x = 0;
        int y = 0;
         
        for (int i=0; i<N; i++) {
            for (int j=0; j<H; j++) {
                if (brick[j][arr[i]] != 0) {
                    x = j;
                    y = arr[i];
                    break;
                }
            }
            bfs(x,y);
            down();
        }
    }
     
    public static void bfs(int x, int y) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x,y,brick[x][y]));
        brick[x][y] = 0;
         
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int power = cur.cost;
             
            for (int i=1; i<power; i++) {
                for (int d=0; d<4; d++) {
                    int nx = cur.x + dx[d]*i;
                    int ny = cur.y + dy[d]*i;
                     
                    if (nx < 0 || nx >= H || ny <0 || ny >= W || brick[nx][ny] == 0) continue;
                    if (brick[nx][ny] != 0) {
                        q.offer(new Node(nx,ny,brick[nx][ny]));
                        brick[nx][ny]= 0 ;
                    }
                }
            }
        }
             
    }
     
    public static boolean check(int x, int y) {
        if (0 <= x && x < H && 0 <= y && y < W) return true;
        else return false;
    }
     
    public static void down() {
        Stack<Integer> stack = new Stack<>();
         
        for (int i=0; i<W; i++) {
            for (int j=0; j<H; j++) {
                if (brick[j][i] != 0) stack.add(brick[j][i]);
            }
            for (int j=H-1; j>=0; j--) {
                if (stack.isEmpty()) brick[j][i] = 0;
                else brick[j][i] = stack.pop();
            }
        }
    }
     
    public static int brickCnt() {
        int cnt = 0;
         
        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                if (brick[i][j] != 0) cnt++;
            }
        }
        return cnt;
    }
     
    public static void reNew() {
        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                brick[i][j] = brick_copy[i][j];
            }
        }
         
    }
}
 
class Node{
    int x,y,cost;
    public Node(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}