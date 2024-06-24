
package lesson.refactors;

public class Sample_1_After {
    public static void main(String[] args){
        int a=10,b=5;
        int x=15,y=8;

        addAndPrint(a,b,"Sum1:");
        addAndPrint(x,y,"Sum2:");

        subAndPrint(a,b,"Diff1");
        subAndPrint(x,y,"Diff1");
    }

    public static int addAndPrint(int one,int two,String message){
        int sumAns= one + two;
        System.out.println(message + sumAns);
        return sumAns;
    }

    public static int subAndPrint(int satu,int dua,String message){
        int difAns= satu + dua;
        System.out.println(message + difAns);
        return difAns;
    }
}
