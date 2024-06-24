package example;

/*  コードを実行するには、Shift + F10を押すか
    ガターの「▷」アイコンをクリックします
*/
public class Hello {
    public static void main(String[] args) {
        /*  ハイライトされたテキストに キャレットがある状態で
            Alt + Enter を押すと
            InteliJ IDEA　によるその修正案を確認できます
        */
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            /*  Shift + F9 を押して コードのデバッグを開始します。
            　　 赤丸ブレークポイントを１つ設定が、 ctrl + F8 を押すと
                いつでもほかのブレークポイントを追加できます。
            */
            System.out.println("i = " + i);
        }
    }
}