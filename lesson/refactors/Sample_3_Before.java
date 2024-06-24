
package lesson.refactors;

public class Sample_3_Before {
    public static void main(String[] args){

        double overWorkHours = Employee.calcOverWorkHours(6);
        System.out.println(overWorkHours);
    }
}

class Employee{

    public static double calcOverWorkHours(double wHour){
        if(wHour<8){
            return 0;
        }
        else
            return wHour -8 ;
    }
}