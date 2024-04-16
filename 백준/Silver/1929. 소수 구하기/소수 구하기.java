import java.io.*;
import java.util.*;

public class Main {

	static int M, N;
	static boolean[] primeNumber;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		primeNumber = new boolean[N + 1];
		Arrays.fill(primeNumber, true);

		isPrime(N);

		for (int i = M; i <= N; i++) {
			if (primeNumber[i])
				sb.append(i).append("\n");
		}
		System.out.println(sb);

	}

	static void isPrime(int n) {

		primeNumber[0] = primeNumber[1] = false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (primeNumber[i]) {
				for (int j = i * i; j <= n; j += i) {
					primeNumber[j] = false;
				}
			}
		}
	}

}