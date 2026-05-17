package clothing.top;

import clothing.ClothingItem;

public class Top extends ClothingItem {
    private String sleeveType;

    public Top(String name, String style, String weather, String sleeveType) {
        super(name, style, weather);
        this.sleeveType = sleeveType;
    }

    public void wear() {
        System.out.println(getName() + " 상의를 입습니다.");
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("소매 타입: " + sleeveType);
    }
}