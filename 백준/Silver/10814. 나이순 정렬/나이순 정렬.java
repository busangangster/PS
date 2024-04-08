import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Member> arr = new ArrayList<Member>();
		
		for (int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int num = i;
			arr.add(new Member(age,name,num));
		}
		Collections.sort(arr);
		
		for (Member x: arr) {
			sb.append(x.age).append(" ").append(x.name).append("\n");
		}
		System.out.println(sb);
		
	}
	
	static class Member implements Comparable<Member>{
		int age, num;
		String name;
		
		public Member(int age, String name, int num) {
			this.age = age;
			this.name = name;
			this.num = num;
		}
		@Override
		public int compareTo(Member o) {
			if ( this.age == o.age) { 
				return this.num - o.num;
			}
			return this.age - o.age;		
		}
	}
}