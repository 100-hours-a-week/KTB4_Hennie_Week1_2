package clothing.bottom;

import clothing.ClothingItem;
import clothing.Style;
import clothing.Weather;

public class Bottom extends ClothingItem {
    private final String fit;

    public Bottom(String name, Style style, Weather weather, String fit) {
        super(name, style, weather);
        this.fit = fit;
    }

    public void wear() {
        System.out.println(getName() + " 하의를 입습니다.");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("핏: " + fit);
    }
}