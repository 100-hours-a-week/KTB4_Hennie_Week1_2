package app;

import clothing.ClothingItem;
import clothing.Style;
import clothing.Weather;
import clothing.bottom.Bottom;
import clothing.outer.Outer;
import clothing.shoes.Shoes;
import clothing.top.Top;
import recommender.Recommender;

import java.util.Optional;
import java.util.Scanner;

public class ClosetApp {
    private final Recommender recommender;
    private final Scanner scanner;

    public ClosetApp() {
        recommender = new Recommender();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== 옷장 코디 추천 프로그램 ===");

        final Weather weather = askWeather();
        final Style style = askStyle();

        showResult(weather, style);
    }

    public Weather askWeather() {
        System.out.println();
        while (true) {
            System.out.println("오늘 날씨를 입력하세요.");
            System.out.println(OptionSelector.listingOptions(Weather.values()) + " 중 하나를 입력하세요.");
            System.out.print("날씨: ");

            Optional<Weather> weather = OptionSelector.fromInput(scanner.nextLine(), Weather.values());
            if (weather.isPresent()) {
                return weather.get();
            }

            System.out.println("잘못된 입력입니다. 선택지 중 하나를 다시 입력해주세요.");
            System.out.println();
        }
    }

    public Style askStyle() {
        System.out.println();
        while (true) {
            System.out.println("원하는 스타일을 입력하세요.");
            System.out.println(OptionSelector.listingOptions(Style.values()) + " 중 하나를 입력하세요.");
            System.out.print("스타일: ");

            Optional<Style> style = OptionSelector.fromInput(scanner.nextLine(), Style.values());
            if (style.isPresent()) {
                return style.get();
            }

            System.out.println("잘못된 입력입니다. 선택지 중 하나를 다시 입력해주세요.");
            System.out.println();
        }
    }

    public void showResult(Weather weather, Style style) {
        Optional<Top> top = recommender.recommendTop(weather, style);
        Optional<Bottom> bottom = recommender.recommendBottom(weather, style);
        Optional<Outer> outer = recommender.recommendOuter(weather, style);
        Optional<Shoes> shoes = recommender.recommendShoes(weather, style);

        System.out.println();
        System.out.println("=== 추천 코디 결과 ===");

        showRecommendedItem("[Top]", top, "상의를 선택하지 못했습니다.");
        showRecommendedItem("[Bottom]", bottom, "하의를 선택하지 못했습니다.");

        if (!outer.isPresent() && weather == Weather.HOT) {
            System.out.println();
            System.out.println("[Outer]");
            System.out.println("오늘은 아우터를 입지 않아도 괜찮습니다.");
        } else {
            showRecommendedItem("[Outer]", outer, "아우터를 선택하지 못했습니다.");
        }

        showRecommendedItem("[Shoes]", shoes, "신발을 선택하지 못했습니다.");
    }

    private void showRecommendedItem(String title, Optional<? extends ClothingItem> item, String failMessage) {
        System.out.println();
        System.out.println(title);

        if (item.isPresent()) {
            ClothingItem clothingItem = item.get();
            clothingItem.showInfo();
            clothingItem.wear();
            return;
        }

        System.out.println(failMessage);
    }
}
