package lesson.classAndInst.menuCafe.own;

import java.util.ArrayList;
import java.util.List;

public class MenuList {
    public static void main(String[] args){
        List<MenuItems> menuList = new ArrayList<MenuItems>();

        menuList.add(new MenuItems("d_01","コーヒー",500));
        menuList.add(new MenuItems("d_02","瓶コーラ",500));
        menuList.add(new MenuItems("d_03","レモネード",500));
        menuList.add(new MenuItems("m_02","くるみマフ",550));
        menuList.add(new MenuItems("b_02","たまごサンド",550));
    }
}

//  初期
/*
        menuItem menuD_d1 = new menuItem("d_01","コーヒー",500);
        menuItem menuD_d2 = new menuItem("d_02","瓶コーラ",500);
        menuItem menuD_d3 = new menuItem("d_03","レモネード",500);

        menuItem menuM_m1 = new menuItem("m_01","クランブル",550);
        menuItem menuM_m2 = new menuItem("m_02","くるみマフ",550);
        menuItem menuM_m3 = new menuItem("m_03","ビッグマフ",650);

        menuItem menuB_b1 = new menuItem("b_01","バタートースト",450);
        menuItem menuB_b2 = new menuItem("b_02","たまごサンド",550);
        menuItem menuB_b3 = new menuItem("b_03","あん食",550);
 */

// ArrayList
/*
List=インターフェース
ArrayList= そのクラス
 */