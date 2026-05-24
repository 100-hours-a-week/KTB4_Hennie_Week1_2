package clothing.shoes;

import clothing.ClothingItem;
import option.Style;
import option.Weather;

public class Shoes extends ClothingItem {

    public Shoes(String name, Style style, Weather weather) {
        super(name, style, weather);
    }

    public void wear() {
        System.out.println(getName() + " 신발을 신습니다.");
    }
}