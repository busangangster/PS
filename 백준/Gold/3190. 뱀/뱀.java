import java.util.*;
import java.io.*;

public class Main {
  public static int N, direction;
  public static Queue<Node> apples = new ArrayDeque<>();
  public static Deque<Node> snake = new ArrayDeque<>();
  public static Queue<Command> command = new ArrayDeque<>();
  public static int[] dx = { 0, -1, 0, 1 };
  public static int[] dy = { 1, 0, -1, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());

    int K = Integer.parseInt(br.readLine());
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      apples.add(new Node(a, b));
    }

    int L = Integer.parseInt(br.readLine());
    for (int i = 0; i < L; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      char cmd = st.nextToken().charAt(0);
      command.add(new Command(x, cmd));
    }

    direction = 0;
    snake.addFirst(new Node(1, 1));
    int ans = 0;

    while (true) {

      int nx = snake.peekFirst().x + dx[direction];
      int ny = snake.peekFirst().y + dy[direction];

      ans++;

      if (!BoundaryCheck(nx, ny))
        break;

      if (!bodyCheck(nx, ny))
        break;

      if (!checkApple(nx, ny)) {
        snake.pollLast();
      }

      snake.addFirst(new Node(nx, ny));

      changeDirection(ans, direction);

    }

    System.out.println(ans);

  }

  public static boolean checkApple(int x, int y) {
    int k = apples.size();

    for (int i = 0; i < k; i++) {
      Node cur = apples.poll();
      if (x == cur.x && y == cur.y) {
        return true;
      }
      apples.offer(cur);
    }
    return false;
  }

  public static boolean BoundaryCheck(int x, int y) {
    return (0 < x && x <= N && 0 < y && y <= N);
  }

  public static boolean bodyCheck(int x, int y) {
    int k = snake.size();

    for (int i = 0; i < k; i++) {
      Node cur = snake.pollFirst();
      if (x == cur.x && y == cur.y) {
        return false;
      }
      snake.addLast(cur);
    }
    return true;
  }

  public static void changeDirection(int t, int d) {
    if (!command.isEmpty() && t == command.peek().x) {
      if (command.peek().cmd == 'D') {
        direction = (d + 3) % 4;
      } else {
        direction = (d + 1) % 4;
      }
      command.poll();
    }
  }
}

class Node {
  int x;
  int y;

  public Node(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Command {
  int x;
  char cmd;

  public Command(int x, char cmd) {
    this.x = x;
    this.cmd = cmd;
  }
}