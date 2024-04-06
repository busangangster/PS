import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
				
		ArrayList<Info> arr = new ArrayList<>(); 
		
		for (int i=0; i<n;i++) {
			String[] s = br.readLine().split("\\.");
			arr.add(new Info(s[0],s[1]));
		}		
		
		for (int i=0; i<m;i++) {
			String e = br.readLine();
			Info.list.add(e);
		}
		
		Collections.sort(arr);
		
		for (int i=0; i< arr.size();i++) {	
			sb.append(arr.get(i).name+"." + arr.get(i).ex).append("\n");
		}
		
		System.out.println(sb);

	}
}

class Info implements Comparable<Info> {
	String name;
	String ex;
	static HashSet<String> list = new HashSet<>(); // list로 하니까 시간초과 뜸 ! 

	public Info(String name, String ex ) {
		this.name = name;
		this.ex = ex;
	}
	
	@Override
	public int compareTo(Info o) {
		if (this.name.equals(o.name)) { // 파일명이 같을 때 
			
			if (!(list.contains(this.ex))&& list.contains(o.ex)) { 
				return this.ex.compareTo(o.ex); 
			}
			
			else if (list.contains(this.ex) && !(list.contains(o.ex))) { 
				return o.ex.compareTo(this.ex);  
			}
			
			return this.ex.compareTo(o.ex);
		} 
		
		return this.name.compareTo(o.name);
	}
}