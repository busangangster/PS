import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());

    ArrayList<Person> ppl = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      String name = st.nextToken();
      ppl.add(new Person(a, name, i));
    }

    Collections.sort(ppl);
    for (Person p : ppl) {
      sb.append(p.age + " " + p.name).append("\n");
    }

    System.out.println(sb);

  }
}

class Person implements Comparable<Person> {
  int age;
  String name;
  int num;

  public Person(int age, String name, int num) {
    this.age = age;
    this.name = name;
    this.num = num;
  }

  @Override
  public int compareTo(Person o) {
    if (this.age == o.age) {
      return this.num - o.num;
    }
    return this.age - o.age;
  }
}