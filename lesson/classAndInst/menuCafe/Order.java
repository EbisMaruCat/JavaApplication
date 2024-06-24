package lesson.classAndInst.menuCafe;

import java.util.List;

public class Order {

    int orderId;

    // String menuIds;
    // List<Integer> menuIDs;

    int guestNum;
    int tableNum;

    // String date;
    // Date today_date;

    // int status;
    // Status status

    // String staffId
    // int staffId

    Order(int orderId, /*List<Integer> menuIDs,*/int guestNum, int tableNum /*,int staffId,*/) {
        this.orderId = orderId;
        //this.menuIds = menuIds;
        this.guestNum = guestNum;
        this.tableNum = tableNum;
        //this.staffId = staffId;
        //this.today_date = new Date();
    }


    public int getTotalAmount(){
        int amount = 0;

        /*for(int i=0; i<menuIDs.size(); i++){
            amount = amount +
        }
        */
        return orderId;
    }
}
