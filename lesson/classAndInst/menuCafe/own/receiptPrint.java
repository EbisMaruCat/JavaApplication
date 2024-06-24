package lesson.classAndInst.menuCafe.own;

public class receiptPrint {

    void Print(){
        System.out.println();
    }
}


// 必要 項目とか (写真より)
/*
注文番号 ____      ← ? たぶん今日の注文数
伝票番号 ____      ← テーブル名ではない...
担当店員 ____      ← 店員ID
お客様 __名様      ← int guestNum
時刻  __:__       ← SDF.form(String)型?  orderTime  (yyyy/MM/dd HH:mm)  どうやって深夜時間とるんだintじゃない...
-------------------------------------------
|         品  名         | 数量  | 単価  |      ←  menuName  menuOrdNum  menuPrice(深夜料金あとで)
         ドリンク                              ←  カテゴリー...
         マフィン
         パン
------------------------------------------
                  | 10%対象小計                ← 税金込み の 合計料金 taxTenTotalPrice (double→int キャスト？)
                  | (うち消費税)               ← 税金だけ の 合計料金 taxTenOnlyPrice
                  | 8%対象小計
                  | (うち消費税)
                  | 深夜料金(税込)           ← ...またあとで
                  | 合計(税込)              ← 総合計料金 totalPrice
                  =======================

             1/_ ←レシート枚数...えぇぇ？
 */
