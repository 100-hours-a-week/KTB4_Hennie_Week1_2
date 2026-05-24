package user;

import clothing.ClothingItem;
import option.Weather;
import recommender.Outfit;
import recommender.Recommender;

public class UserRecommendationTask implements Runnable {
    private final UserRequest request;
    private final Recommender recommender;
    private final Object printLock;

    public UserRecommendationTask(UserRequest request, Recommender recommender, Object printLock) {
        this.request = request;
        this.recommender = recommender;
        this.printLock = printLock;
    }

    @Override
    public void run() {
        User user = request.getUser();
        Outfit outfit = recommender.recommendOutfit(user, request.getWeather(), request.getStyle());

        synchronized (printLock) {
            System.out.println();
            System.out.println("=== " + user.getDisplayName() + " 추천 코디 결과 ===");

            outfit.getTop().ifPresentOrElse(
                    item -> showRecommendedItem("[Top]", item),
                    () -> showFailMessage("[Top]", "상의를 선택하지 못했습니다.")
            );
            outfit.getBottom().ifPresentOrElse(
                    item -> showRecommendedItem("[Bottom]", item),
                    () -> showFailMessage("[Bottom]", "하의를 선택하지 못했습니다.")
            );

            if (outfit.getOuter().isEmpty() && request.getWeather() == Weather.HOT) {
                System.out.println();
                System.out.println("[Outer]");
                System.out.println("오늘은 아우터를 입지 않아도 괜찮습니다.");
            } else {
                outfit.getOuter().ifPresentOrElse(
                        item -> showRecommendedItem("[Outer]", item),
                        () -> showFailMessage("[Outer]", "아우터를 선택하지 못했습니다.")
                );
            }

            outfit.getShoes().ifPresentOrElse(
                    item -> showRecommendedItem("[Shoes]", item),
                    () -> showFailMessage("[Shoes]", "신발을 선택하지 못했습니다.")
            );
        }
    }

    private void showRecommendedItem(String title, ClothingItem item) {
        System.out.println();
        System.out.println(title);
        item.showInfo();
        item.wear();
    }

    private void showFailMessage(String title, String failMessage) {
        System.out.println();
        System.out.println(title);
        System.out.println(failMessage);
    }
}
