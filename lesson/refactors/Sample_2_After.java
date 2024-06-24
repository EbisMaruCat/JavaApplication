package lesson.refactors;

import java.util.List;

public class Sample_2_After {
    public static void main(String[] args){
        List<Integer> list01 = List.of(3,2,1);
        List<Integer> list02 = List.of(3,2,11);
        List<Integer> list03 = List.of(3,21,11);

        sumSet(list01,"sum1");
        sumSet(list02,"sum2");
        sumSet(list03,"sum3");

    }

    public static int sumSet(List<Integer> listSample,String words){
        int sumAns = 0;

        for(Integer e:listSample)
            sumAns += e;

        System.out.println(words + sumAns);
        return sumAns;
    }

}
