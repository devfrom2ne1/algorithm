import java.util.*;
class Solution {

    public long getSum(LinkedList<String> list, String opStr)
    {
        long sumVal = -1;
        String[] ops = opStr.split("");

        // 1순위 계산
        list = calculate(list, ops[0]);

        // 2순위 게산
        list = calculate(list, ops[1]);

        // 3순위 계산
        list = calculate(list, ops[2]);

        sumVal = Long.parseLong(list.get(0));
        if(sumVal < 0)
            sumVal *= -1;

        return sumVal;
    }
    public LinkedList<String> calculate(LinkedList<String> list, String op)
    {
        while(list.contains(op))
        {
            int opIdx = list.indexOf(op);

            if(opIdx > -1){
                long bfVal = Long.parseLong(list.get(opIdx-1));
                long afVal = Long.parseLong(list.get(opIdx+1));

                long tmp = -1;
                if(op.equals("*"))
                    tmp = bfVal * afVal;
                else if(op.equals("-"))
                    tmp = bfVal - afVal;
                else if(op.equals("+"))
                    tmp = bfVal + afVal;

                list.set(opIdx-1, Long.toString(tmp));
                list.remove(opIdx);
                list.remove(opIdx);
            }
        }
        return list;
    }

    public long solution(String expression) {
        long answer = 0;
        long max = Long.MIN_VALUE;

        // 숫자와 기호 분리하기
        StringTokenizer st = new StringTokenizer(expression, "*+-", true);
        LinkedList<String> list = new LinkedList<>();

        while(st.hasMoreTokens())
        {
            list.add(st.nextToken());
        }

        // 우선순위 경우의 수만큼 계산하기
        String[] cases = {"*-+","*+-","-+*","-*+","+-*","+*-"};

        long temp = -1;

        for(String cs : cases)
        {
            LinkedList<String> copied = new LinkedList<>(list); // 깊은 복사
            temp = getSum(copied, cs);
            // 최대값 구하기
            if(temp>max)
            {
                max = temp;
            }
        }
        answer = max;
        return answer;
    }
}