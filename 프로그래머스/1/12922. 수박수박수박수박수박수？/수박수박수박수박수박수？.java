class Solution {
    public String solution(int n) {
        String answer = "";
        int k = n / 2;
      
        for (int i=0; i<k;i++) {
            answer += "수박";
        }
        if (n % 2 != 0){
            answer += "수";
         }
        
       
        return answer;
    }
}