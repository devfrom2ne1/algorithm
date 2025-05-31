class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        
        String str = String.valueOf(n);
        int length = str.length();
        answer = new int[length];
        int cnt = 0;
        
        for(int i=length-1; i>=0; i--){
            char ch = str.charAt(i);
            
            // 아스키코드를 int로 변환 (3가지 방법)
            // (1) int k = (int) ch - '0'; 
            // (2) int k = Character.getNumericValue(ch);
            // (3) int k = Integer.parseInt( String.valueOf(ch) );
            int k = Integer.parseInt( String.valueOf(ch) );
            answer[cnt] = k;
            cnt++;
        }
        
        return answer;
    }
}
