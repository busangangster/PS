import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    System.out.println(n % 7 == 0 || n % 7 == 2 ? "CY" : "SK");
  }
}