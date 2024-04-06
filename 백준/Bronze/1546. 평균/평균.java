import java.io.*;
import java.util.*;
 
class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		double[] arr = new double[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		double max_v = Arrays.stream(arr).max().getAsDouble();
		
		for (int i=0; i<n; i++) {
			arr[i] = arr[i]/max_v *100;
		}

		double sum = Arrays.stream(arr).sum();
		
		System.out.println(sum/arr.length);
		
	}
}