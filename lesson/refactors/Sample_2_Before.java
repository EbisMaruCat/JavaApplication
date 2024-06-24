package lesson.refactors;

import java.util.List;

public class Sample_2_Before {
    public static void main(String[] args){

        List<Integer> list01 = List.of(3,2,1);
        int sum1=0;
        for(Integer e:list01){
            sum1 += e;
        }

        List<Integer> list02 = List.of(3,2,11);
        int sum2=0;
        for(Integer e:list02){
            sum2 += e;
        }

        List<Integer> list03 = List.of(3,21,1);
        int sum3=0;
        for(Integer e:list03){
            sum3 += e;
        }

        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
    }
}
