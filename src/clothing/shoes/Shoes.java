package clothing.shoes;

import clothing.ClothingItem;
import clothing.Style;
import clothing.Weather;

public class Shoes extends ClothingItem {

    public Shoes(String name, Style style, Weather weather) {
        super(name, style, weather);
    }

    public void wear() {
        System.out.println(getName() + " 신발을 신습니다.");
    }
}