
package lesson.classAndInst.menuCafe.own;

public class MenuItems {

    String menuID;
    String menuName;      // 品物名
    int menuPrice;        // 単価料金
    int menuOrdNum = 0;        // 注文個数

    // コンストラクタ cafeMenu (品名id、品名、単価料金)
    public MenuItems(String menuID, String menuName, int menuPrice) {
        this.menuID = menuID;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    // 注文 品名の 取得 ?
    public String getMenuName(){
        return menuName;
    }

    // 注文個数 の 取得
    public int getMenuOrdNum(){
        return menuOrdNum;
    }

    // 注文した品物 の 注文金額 の取得 ? :  単価料金 * 注文個数
    public int getMenuPrice(){
        return menuPrice * menuOrdNum;
    }


    // 要素の置き換え?
    /*
       // 品名
       public String setMenuName(){return menuName;};

       // 注文個数 ( scannerより )
       public int setMenuOrdNum(int scanOrdNum){
           return menuOrdNum=scanOrdNum;           // Scanner scanOrdNum
       };

       // 単価料金
       public int setMenuPrice(int today_HOUR ){   // timeCHQパッケの Calendar.javaから...
           if (( today_HOUR > 21) || (today_HOUR < 2)){
               return menuPrice = nightPrice;
           }else{
               return menuPrice;
           }
     */


    // 注文内容 の 表示 :  品名 \t 数量 \t 単価
    // public void printOrder(){  System.out.println(menuName + "\t" + menuOrdNum + "\t" + menuPrice );  }

}

// 未使用 データ
/*
String menuGenre;      ジャンル
int nightPrice;        深夜得料金
double tax10 = 0.1;    10%消費税
double tax08 = 0.08;    8%消費税
 */

// ジャンルとして扱うなら  ArrayListじゃなくて 継承クラスだったら
/*
public class Breads extends menuItem{
    Breads(String mID,String mNae,int mPrc){
    }
}
public class Drinks extends menuItem{}
public class MCakes extends menuItem{}
 */