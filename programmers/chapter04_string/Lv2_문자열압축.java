import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int min = s.length(); //문자열이 1글자일 때 처리 위함
        // s.length / 2만큼만 자름
        for(int i=1; i<= s.length()/2; i++)
        {
            List<String> sliced = slice(s,i);
            int plen = press(sliced);
            if(plen < min){
                min = plen;
            }
        }
        answer = min;
        return answer;
    }
    public List<String> slice(String s, int len){
        System.out.println("==================");
        //System.out.println("길이 : "+ s.length());
        int str = 0;
        int end = str+len;
        
        List<String> sliced = new ArrayList<>();
        for(int i=0; i<s.length(); i++)
        {
            String ss = s.substring(str,end);
            //System.out.println("["+i+"]"+"ss : "+ ss);
            sliced.add(ss);
            
            // 다음 처리
            str += len;
            end += len;
            
            if(end > s.length())
            {
                end = s.length();
            }
            if(str >= end){
                break;
            }
        }
        //System.out.println(sliced);
        return sliced;
    }
    public int press(List<String> sliced){
        int len = 0;
        String prev = sliced.get(0);
        int cnt = 1;
        String pressed = "";
        
        for(int i=1; i<sliced.size(); i++){
            
            //System.out.println("-------------------");
            String cur = sliced.get(i);
            
            //만약 같으면?
            if(cur.equals(prev))
            {
                cnt++;
                //System.out.println("[=] prev: "+prev+" | cur: "+cur);
            }
            // 다르면?
            else{
                 // cnt가 1보다 크면 숫자+prev 압축!
                if(cnt>1){
                    pressed += cnt+prev;  
                }
                // cnt가 1이면 그냥 prev만 압축!
                else{
                    pressed += prev;
                }
                // cnt 초기화
                cnt = 1;
                //System.out.println("[!=] prev: "+prev+" | cur: "+cur);
            }
            
            // prev = cur로 초기화
            prev = cur;
            //System.out.println("pressed: "+pressed);
        }
        // for문 끝나고 마지막 prev 처리
        if (cnt > 1) {
            pressed += cnt + prev;
        } else {
            pressed += prev;
        }
        return pressed.length();
    }
}