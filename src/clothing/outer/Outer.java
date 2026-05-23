package clothing.outer;

import clothing.ClothingItem;
import clothing.Style;
import clothing.Weather;

public class Outer extends ClothingItem {
    private final String thickness;

    public Outer(String name, Style style, Weather weather, String thickness) {
        super(name, style, weather);
        this.thickness = thickness;
    }

    public void wear() {
        System.out.println(getName() + " 아우터를 입습니다.");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("두께: " + thickness);
    }
}