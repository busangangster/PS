import java.io.*;
import java.util.*;

public class Main {
	static int[] line,origin;
	static int N,len;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		origin = new int[N];
		line = new int[N];
		for (int i=0; i<N; i++) {
			origin[i] = Integer.parseInt(br.readLine());
		}
		
		line[0] = origin[0];
		len = 1;
		for (int i=1; i<N; i++) {
			if (line[len-1] < origin[i]) {
				line[len++] = origin[i];
			}
			else if (line[len-1] > origin[i]) {
				int tmp = bs(0,len-1,origin[i]);
				line[tmp] = origin[i];
				
			}

		}
		System.out.println(N-len);

	}
	
	public static int bs(int lt, int rt, int target) {
		int mid;
		
		while (lt < rt) {
			mid = (lt+rt)/2;
			
			if (line[mid] < target) {
				lt = mid + 1;
			}
			else {
				rt = mid;
			}
		}
		return rt;
	}
}