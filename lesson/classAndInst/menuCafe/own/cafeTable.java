package lesson.classAndInst.menuCafe.own;

public class cafeTable {

    int tableNo;          // テーブル番号
    boolean tableState;   // 空席 = 0   使用 = 1
    int guestNum;         // お客様の数

    cafeTable(int tableNo,boolean tableState,int guestNum){
        this.tableNo=tableNo;
        this.tableState=false;    // 空席にする
        this.guestNum=guestNum;
    }
}
