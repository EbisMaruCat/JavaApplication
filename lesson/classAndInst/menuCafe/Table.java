package lesson.classAndInst.menuCafe;

public class Table {

    int tableNo;
    boolean isUsing;   // int ではなくて、 (0=false 1=true) の boolean
    int guestNum;

    Table(int tableNo,int isUsing, int guestNum){
        this.tableNo = tableNo;
        this.isUsing = false;  // あらかじめ 空席にする
    }
}
