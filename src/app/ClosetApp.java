package app;

import clothing.ClothingItem;
import clothing.bottom.Bottom;
import clothing.outer.Outer;
import clothing.shoes.Shoes;
import clothing.top.Top;
import recommender.Recommender;

import java.util.Scanner;

public class ClosetApp {
    // 프로그램에서 허용되는 입력값 목록 (상수로 이용)
    private static final String[] WEATHER_OPTIONS = {"hot", "warm", "cool", "cold", "windy"};
    private static final String[] STYLE_OPTIONS = {"casual", "formal", "sporty"};

    private Recommender recommender;
    private Scanner scanner;

    public ClosetApp() {
        recommender = new Recommender();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== 옷장 코디 추천 프로그램 ===");

        String weather = askWeather();
        String style = askStyle();

        showResult(weather, style);
    }

    public String askWeather() {
        System.out.println();
        return askOption(
                "오늘 날씨를 입력하세요.",
                "hot / warm / cool / cold / windy 중 하나를 입력하세요.",
                "날씨: ",
                WEATHER_OPTIONS
        );
    }

    public String askStyle() {
        System.out.println();
        return askOption(
                "원하는 스타일을 입력하세요.",
                "casual / formal / sporty 중 하나를 입력하세요.",
                "스타일: ",
                STYLE_OPTIONS
        );
    }

    private String askOption(String title, String guide, String prompt, String[] options) {
        while (true) {
            System.out.println(title);
            System.out.println(guide);
            System.out.print(prompt);

            // 입력값 검증 (유효한 선택지만 남김)
            String input = scanner.nextLine().trim().toLowerCase();
            if (isValidOption(input, options)) {
                return input;
            }

            System.out.println("잘못된 입력입니다. 선택지 중 하나를 다시 입력해주세요.");
            System.out.println();
        }
    }

    private boolean isValidOption(String input, String[] options) {
        for (String option : options) {
            if (option.equals(input)) {
                return true;
            }
        }

        return false;
    }

    public void showResult(String weather, String style) {
        Top top = recommender.recommendTop(weather, style);
        Bottom bottom = recommender.recommendBottom(weather, style);
        Outer outer = recommender.recommendOuter(weather, style);
        Shoes shoes = recommender.recommendShoes(weather, style);

        System.out.println();
        System.out.println("=== 추천 코디 결과 ===");

        showRecommendedItem("[Top]", top, "상의를 선택하지 못했습니다.");
        showRecommendedItem("[Bottom]", bottom, "하의를 선택하지 못했습니다.");

        if (outer == null && weather.equals("hot")) {
            System.out.println();
            System.out.println("[Outer]");
            System.out.println("오늘은 아우터를 입지 않아도 괜찮습니다.");
        } else {
            showRecommendedItem("[Outer]", outer, "아우터를 선택하지 못했습니다.");
        }

        showRecommendedItem("[Shoes]", shoes, "신발을 선택하지 못했습니다.");
    }

    private void showRecommendedItem(String title, ClothingItem item, String failMessage) {
        System.out.println();
        System.out.println(title);

        if (item == null) {
            System.out.println(failMessage);
        } else {
            item.showInfo();
            item.wear();
        }
    }
}
