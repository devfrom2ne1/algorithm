package string;

public class 04_시저_암호 {
    class Solution {
        public String solution(String s, int n) {
            String answer = "";

            int length = s.length();

            for(int i=0; i<length; i++){
                char ch = s.charAt(i);

                if(ch==' '){
                    answer += ' ';
                }
                else{
                    if( ch>='A' && ch<='Z' ){ // A:65 Z:90
                        ch += n;
                        if(ch>'Z')
                            ch -= 26;
                    }
                    else if( ch>='a' && ch<='z' ){ // a:97 z:122
                        ch += n;
                        if(ch>'z')
                            ch -= 26;
                    }
                    answer += ch;
                }
            }

            return answer;
        }
    }
}
