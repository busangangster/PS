import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int A =  Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
	
		
		int k = (V-B) % (A-B);
		if (k == 0) {
			System.out.println((V-B) / (A-B));
		}
		else {
			System.out.println((V-B) / (A-B)+1);
		}
			
	}
	
}