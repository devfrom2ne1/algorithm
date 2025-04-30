import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {};
        answer = new int[5];
        Arrays.fill(answer, 1); // 처음엔 전부 1로 가정
        
        // 입력된 모든 case 탐색
        for(int i=0; i<5; i++)
        {
            // 각 case에 대해서 반별 시작
            String[] place =  places[i]; // "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"

            for(int j=0; j<5; j++)
            {
                boolean bCheck = true;
                String str = place[j]; // "POOOP"
                
                for(int k=0; k<5; k++)
                {
                    char ch = str.charAt(k);
                    
                    if(ch == 'P'){
                        // 현재 좌표 (x, y) = (j, k)
                        
                        // 거리 1인 주변 탐색 (상, 하, 좌, 우) 
                        
                        // 상 : (j-1, k  ) place[j-1].charAt(k) --> if( j-1>-1 )
                        // 하 : (j+1, k  ) place[j+1].charAt(k) --> if( j+1<5 )
                        // 좌 : (j. , k-1) place[j].charAt(k-1) --> if( k-1>-1 )
                        // 우 : (j. , k+1) place[j].charAt(k+1) --> if( k+1<5 )
                        
                        if( 
                            ( (j-1)>-1 && place[j-1].charAt(k) == 'P') || // 상
                            ( (j+1)<5  && place[j+1].charAt(k) == 'P') || // 하
                            ( (k-1)>-1 && place[j].charAt(k-1) == 'P') || // 좌
                            ( (k+1)<5  && place[j].charAt(k+1) == 'P')    // 우
                        )
                        {
                            bCheck = false;
                            break;
                        }
                        
                        // ==> 이 거리에 P가 있으면 바로 탈출(return 0)                        
                        // 거리 2인 주변 탐색 (대각선 상오,상좌, 하좌,하우 / 일렬로 상,하,좌,우)
                        // 대각선 상좌 : (j-1, k-1 ) / 상, 좌 != '0'
                        // 대각선 상우 : (j-1, k+1 ) / 상, 우 != '0'
                        // 대각선 하우 : (j+1, k+1 ) / 하, 우 != '0'
                        // 대각선 하좌 : (j+1, k-1 ) / 하, 좌 != '0'
                        
                        // 상상 : (j-2, k  ) / 상 != '0'
                        // 하하 : (j+2, k  ) / 하 != '0'
                        // 좌좌 : (j. , k-2) / 좌 != '0'
                        // 우우 : (j. , k+2) / 우 != '0'
                        
                        // 사이에 O가 있으면 바로 탈출(return 0)                                                     
                        if( (j-1)>-1 && place[j-1].charAt(k) == 'O' ) // 상
                        {
                            if( 
                                ( (j-1)>-1 && (k-1)>-1 && place[j-1].charAt(k-1) == 'P' ) || // 대각선 상좌
                                ( (j-1)>-1 && (k+1)<5  && place[j-1].charAt(k+1) == 'P' ) || // 대각선 상우
                                ( (j-2)>-1 && place[j-2].charAt(k) == 'P' ) // 상상
                            )
                            {
                                bCheck = false;
                                break;
                            }

                        }
                        if( (j+1)<5  && place[j+1].charAt(k) == 'O' ) // 하
                        {
                            if( 
                                ( (j+1)<5 && (k+1)<5 && place[j+1].charAt(k+1) == 'P' )   || // 대각선 하우
                                ( (j+1)<5 && (k-1)>-1  && place[j+1].charAt(k-1) == 'P' ) || // 대각선 하좌
                                ( (j+2)<5 && place[j+2].charAt(k) == 'P' ) // 하하
                            )
                            {
                                bCheck = false;
                                break;
                            }
                        }
                        if( (k-1)>-1 && place[j].charAt(k-1) == 'O' ) // 좌
                        {
                            if( 
                                ( (j-1)>-1 && (k-1)>-1 && place[j-1].charAt(k-1) == 'P' ) || // 대각선 상좌
                                ( (j+1)<5 && (k-1)>-1  && place[j+1].charAt(k-1) == 'P' ) || // 대각선 하좌
                                ( (k-2)>-1 && place[j].charAt(k-2) == 'P' ) // 좌좌
                            )
                            {
                                bCheck = false;
                                break;
                            }
                        }
                        if( (k+1)<5  && place[j].charAt(k+1) == 'O' ) // 우
                        {
                           if( 
                                ( (j-1)>-1 && (k+1)<5  && place[j-1].charAt(k+1) == 'P' ) || // 대각선 상우
                                ( (j+1)<5 && (k+1)<5 && place[j+1].charAt(k+1) == 'P' )   || // 대각선 하우
                                ( (k+2)<5 && place[j].charAt(k+2) == 'P' ) // 우우
                            )
                            {
                                bCheck = false;
                                break;
                            }

                        }
                        
                    }

                }
                
                if(bCheck == false)
                {
                    answer[i] = 0;
                    break;
                }
            }
            
        }

        return answer;
    }
}