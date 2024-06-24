package lesson.classAndInst.menuCafe;

import java.util.List;

public abstract class MenuManager {
    static List<Menu> allMenu = List.of(new Coffee());

    public static Menu getMenuById(int id) {
        for(int i = 0; i < allMenu.size(); i++) {
            if(allMenu.get(i).id == id) {
                return allMenu.get(i);
            }
        }

        // TODO:例外を返す
        throw new IllegalArgumentException("メニューが存在しません。");
    }
}