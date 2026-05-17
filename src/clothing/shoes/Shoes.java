package clothing.shoes;

import clothing.ClothingItem;

public class Shoes extends ClothingItem {

    public Shoes(String name, String style, String weather) {
        super(name, style, weather);
    }

    public void wear() {
        System.out.println(getName() + " 신발을 신습니다.");
    }
}