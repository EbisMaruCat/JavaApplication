package lesson.classAndInst.menuCafe;

public class Menu {
    int id;        //
    int price;
    String name;
    // Category category;
    // int count;

    Menu(int id, int price,String name){
        this.id = id;
        this.price = price;
        this.name = name;
    }
}

class Coffee extends Menu{
    Coffee() {
        super(1, 400, "coffee");
    }
}