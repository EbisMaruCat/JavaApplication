package samples;

import java.util.Scanner;

public class testPrimeNums {
    private final static Scanner scanNum = new Scanner(System.in);
    public static void main(String[] args){

        System.out.println("Version1 online");
        System.out.println("数値を入れてください: ");
        int gotNum = scanNum.nextInt();
        for(int i=2; i<=gotNum;i++){
            for(int j=2; (i%j!=0&&j<i)||j==i; j++ ){
                if(j==i){
                    System.out.println(i + "は素数です");
                }
            }
        }

        System.out.println("Version2 by chatGPT");
        System.out.println("数値を入れてください: ");
        int gotNum2 = scanNum.nextInt();

        for (int i = 2; i <= gotNum2; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i + "は素数です");
            }
        }

    }
}
