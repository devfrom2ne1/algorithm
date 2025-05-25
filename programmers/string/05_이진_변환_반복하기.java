import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String s1 = "";
        int s1_len = 0;
        int cnt1 = 0; // 제거된 0의 갯수
        int cnt2 = 0; // 이진변환 횟수
        
        answer = new int[2];
        
        while(!s.equals("1"))
        {
            s1 = "";  
            // 1단계 : 0 없애기 
            // replace는 왜 안 먹었을까? s.replace("0", "");
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);
                if(ch != '0')
                    s1 += ch;
                else
                    cnt1++;
            }
            //System.out.println(s1);

            // 2단계 : 길이 구하기 => 2진수로 변환 => s1바꾸기    
            s1_len = s1.length();
            List<Integer> list = new ArrayList<>();

            while(s1_len>0){
                //System.out.println(s1_len);
                list.add(s1_len%2);
                s1_len = s1_len/2;
                //System.out.println(list);
            }

            Collections.reverse(list);
            StringBuilder sb = new StringBuilder();
            for(int val:list){
                sb.append(val);
                //System.out.println(sb);
            }
            s = sb.toString();
            cnt2++;
        }
        answer[0] = cnt2;
        answer[1] = cnt1;
        return answer;
    }
}
