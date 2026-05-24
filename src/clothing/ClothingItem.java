package clothing;

import option.Style;
import option.Weather;

public class ClothingItem {
    private final String name;
    private final Style style;
    private final Weather weather;

    public ClothingItem(String name, Style style, Weather weather) {
        this.name = name;
        this.style = style;
        this.weather = weather;
    }

    public void showInfo() {
        System.out.println("이름: " + name);
        System.out.println("스타일: " + style.getValue());
        System.out.println("추천 날씨: " + weather.getValue());
    }

    public void wear() {
        System.out.println(name + "을/를 착용합니다.");
    }

    // 옷 추천 방식 (1순위: 스타일과 날씨가 맞을 때, 2순위: 날씨가 맞을 때, 3순위: 스타일이 맞을 때)
    public boolean matches(Weather weather, Style style) {
        return this.weather == weather && this.style == style;
    }

    public boolean matchesWeather(Weather weather) {
        return this.weather == weather;
    }

    public boolean matchesStyle(Style style) {
        return this.style == style;
    }

    public String getName() {
        return name;
    }
}