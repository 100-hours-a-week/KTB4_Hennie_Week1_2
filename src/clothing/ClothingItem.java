package clothing;

public class ClothingItem {
    private String name;
    private String style;
    private String weather;

    public ClothingItem(String name, String style, String weather) {
        this.name = name;
        this.style = style;
        this.weather = weather;
    }

    public void showInfo() {
        System.out.println("이름: " + name);
        System.out.println("스타일: " + style);
        System.out.println("추천 날씨: " + weather);
    }

    public void wear() {
        System.out.println(name + "을/를 착용합니다.");
    }

    // 옷 추천 방식 (1순위: 스타일과 날씨가 맞을 때, 2순위: 날씨가 맞을 때, 3순위: 스타일이 맞을 때)
    public boolean matches(String weather, String style) {
        return this.weather.equals(weather) && this.style.equals(style);
    }

    public boolean matchesWeather(String weather) {
        return this.weather.equals(weather);
    }

    public boolean matchesStyle(String style) {
        return this.style.equals(style);
    }

    public String getName() {
        return name;
    }
}