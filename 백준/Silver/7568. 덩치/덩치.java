import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		

		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Person> arr = new ArrayList<Person>();
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new Person(x,y));
		}
		
		for (int i=0; i<n; i++) {
			int cnt=0;
			for (int j=0; j<n; j++) {
				if (i == j) continue;
				if (arr.get(i).x <arr.get(j).x && arr.get(i).y < arr.get(j).y) cnt++;
			}
			sb.append(cnt+1).append(" ");
		}
		System.out.println(sb);
	}
	static class Person{
		int x, y;
		public Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}