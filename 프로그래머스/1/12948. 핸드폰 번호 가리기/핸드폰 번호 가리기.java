class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String words = "";
    
         for (int i=0; i< phone_number.length(); i++) {
                if (i < phone_number.length() - 4) {
                    answer += "*";
                }
                else {
                    answer += phone_number.charAt(i) -'0';
                }
            }
        return answer;
    }
}