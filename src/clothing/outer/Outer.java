package clothing.outer;

import clothing.ClothingItem;

public class Outer extends ClothingItem {
    private String thickness;

    public Outer(String name, String style, String weather, String thickness) {
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