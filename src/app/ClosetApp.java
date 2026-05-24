package app;

import option.Style;
import option.Weather;
import option.OptionSelector;
import recommender.Recommender;
import user.User;
import user.UserRecommendationTask;
import user.UserRequest;

import java.util.Optional;
import java.util.Scanner;

public class ClosetApp {
    private final Recommender recommender;
    private final Scanner scanner;
    private final Object printLock;

    public ClosetApp() {
        recommender = new Recommender();
        scanner = new Scanner(System.in);
        printLock = new Object();
    }

    public void start() {
        System.out.println("=== 옷장 코디 추천 프로그램 ===");

        UserRequest olderSisterRequest = askUserRequest(User.OLDER_SISTER);
        UserRequest youngerSiblingRequest = askUserRequest(User.YOUNGER_SISTER);

        Thread olderSisterThread = new Thread(
                new UserRecommendationTask(olderSisterRequest, recommender, printLock),
                User.OLDER_SISTER.getDisplayName()
        );
        Thread youngerSiblingThread = new Thread(
                new UserRecommendationTask(youngerSiblingRequest, recommender, printLock),
                User.YOUNGER_SISTER.getDisplayName()
        );

        olderSisterThread.start();
        youngerSiblingThread.start();

        try {
            olderSisterThread.join();
            youngerSiblingThread.join();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            System.out.println("추천 작업이 중단되었습니다.");
        }
    }

    private UserRequest askUserRequest(User user) {
        System.out.println();
        System.out.println("[" + user.getDisplayName() + " 입력]");
        Weather weather = askWeather();
        Style style = askStyle();

        return new UserRequest(user, weather, style);
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

}
