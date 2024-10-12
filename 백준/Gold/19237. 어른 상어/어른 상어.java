import java.util.*;
import java.io.*;

public class Main {
    static int N, M, k;
    static int[][] map; // 현재 상어 위치
    static Smell[][] smells; // 냄새 정보
    static Shark[] sharks; // 상어 정보
    static int[] dx = {0, -1, 1, 0, 0}; // 상하좌우 이동을 위한 배열 (0번 인덱스 사용 안함)
    static int[] dy = {0, 0, 0, -1, 1};
    static int time = 0;

    static class Shark {
        int x, y, dir;
        int[][] priority;
        boolean alive;

        public Shark(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.alive = true;
            this.priority = new int[5][5]; // 방향별 우선순위 저장
        }
    }

    static class Smell {
        int sharkNum;
        int time;

        public Smell(int sharkNum, int time) {
            this.sharkNum = sharkNum;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 부분
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        smells = new Smell[N][N];
        sharks = new Shark[M + 1]; // 상어 번호가 1부터 시작하므로 M+1 크기로 설정

        // 상어 위치 입력 및 초기 냄새 설정
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int sharkNum = Integer.parseInt(st.nextToken());
                map[i][j] = sharkNum;
                if (sharkNum > 0) {
                    sharks[sharkNum] = new Shark(i, j, 0);
                    smells[i][j] = new Smell(sharkNum, k);
                }
            }
        }

        // 각 상어의 초기 방향 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            int dir = Integer.parseInt(st.nextToken());
            sharks[i].dir = dir;
        }

        // 각 상어의 이동 우선순위 입력
        for (int i = 1; i <= M; i++) {
            Shark shark = sharks[i];
            for (int d = 1; d <= 4; d++) {
                st = new StringTokenizer(br.readLine());
                for (int p = 1; p <= 4; p++) {
                    shark.priority[d][p] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // 시뮬레이션 시작
        while (true) {
            time++;
            if (time > 1000) {
                System.out.println(-1);
                return;
            }

            // 모든 상어 이동 결정
            int[][] newMap = new int[N][N];
            for (int i = 1; i <= M; i++) {
                Shark shark = sharks[i];
                if (!shark.alive) continue;

                int x = shark.x;
                int y = shark.y;
                int dir = shark.dir;
                boolean moved = false;

                // 1. 냄새가 없는 칸으로 이동 시도
                for (int p = 1; p <= 4; p++) {
                    int ndir = shark.priority[dir][p];
                    int nx = x + dx[ndir];
                    int ny = y + dy[ndir];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if (smells[nx][ny] == null) {
                        // 이동 가능
                        shark.x = nx;
                        shark.y = ny;
                        shark.dir = ndir;
                        moved = true;
                        break;
                    }
                }

                // 2. 자신의 냄새가 있는 칸으로 이동 시도
                if (!moved) {
                    for (int p = 1; p <= 4; p++) {
                        int ndir = shark.priority[dir][p];
                        int nx = x + dx[ndir];
                        int ny = y + dy[ndir];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if (smells[nx][ny] != null && smells[nx][ny].sharkNum == i) {
                            // 이동 가능
                            shark.x = nx;
                            shark.y = ny;
                            shark.dir = ndir;
                            break;
                        }
                    }
                }

                // 이동 결과를 임시 맵에 저장
                if (newMap[shark.x][shark.y] == 0) {
                    newMap[shark.x][shark.y] = i;
                } else {
                    // 이미 다른 상어가 있는 경우 번호가 작은 상어만 남음
                    if (newMap[shark.x][shark.y] > i) {
                        sharks[newMap[shark.x][shark.y]].alive = false;
                        newMap[shark.x][shark.y] = i;
                    } else {
                        shark.alive = false;
                    }
                }
            }

            // 맵과 냄새 업데이트
            updateSmells();
            leaveSmells();
            map = newMap;

            // 1번 상어만 남았는지 확인
            if (checkOnlyOne()) {
                System.out.println(time);
                return;
            }
        }
    }

    // 냄새 시간 감소 및 제거
    static void updateSmells() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (smells[i][j] != null) {
                    smells[i][j].time--;
                    if (smells[i][j].time == 0) {
                        smells[i][j] = null;
                    }
                }
            }
        }
    }

    // 현재 상어 위치에 냄새 남기기
    static void leaveSmells() {
        for (int i = 1; i <= M; i++) {
            Shark shark = sharks[i];
            if (!shark.alive) continue;
            smells[shark.x][shark.y] = new Smell(i, k);
        }
    }

    // 1번 상어만 남았는지 확인
    static boolean checkOnlyOne() {
        for (int i = 2; i <= M; i++) {
            if (sharks[i].alive) {
                return false;
            }
        }
        return true;
    }
}