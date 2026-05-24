package recommender;

import clothing.ClothingCatalog;
import clothing.ClothingItem;
import option.Style;
import option.Weather;
import clothing.bottom.Bottom;
import clothing.outer.Outer;
import clothing.shoes.Shoes;
import clothing.top.Top;
import user.User;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Recommender extends ClothingCatalog {

    // 한 사용자의 전체 outfit 추천이 끝날 때까지 다른 사용자 스레드를 시작하지 않음
    public synchronized Outfit recommendOutfit(User user, Weather weather, Style style) {
        Optional<Top> top = recommendTop(user, weather, style);
        Optional<Bottom> bottom = recommendBottom(user, weather, style);
        Optional<Outer> outer = recommendOuter(user, weather, style);
        Optional<Shoes> shoes = recommendShoes(user, weather, style);

        return new Outfit(top, bottom, outer, shoes);
    }

    private Optional<Top> recommendTop(User user, Weather weather, Style style) {
        return recommendByPriority(user, ClothingCatalog.TOPS, weather, style);
    }

    private Optional<Bottom> recommendBottom(User user, Weather weather, Style style) {
        return recommendByPriority(user, ClothingCatalog.BOTTOMS, weather, style);
    }

    private Optional<Outer> recommendOuter(User user, Weather weather, Style style) {
        if (weather == Weather.HOT) {
            return Optional.empty();
        }

        return recommendByPriority(user, ClothingCatalog.OUTERS, weather, style);
    }

    private Optional<Shoes> recommendShoes(User user, Weather weather, Style style) {
        return recommendByPriority(user, ClothingCatalog.SHOES, weather, style);
    }

    private <T extends ClothingItem> Optional<T> recommendByPriority(User user, List<T> items, Weather weather, Style style) {
        // 1순위: 날씨와 스타일이 모두 맞는 옷
        Optional<T> matchedItem = findAndWear(user, items, item -> item.matches(weather, style));
        if (matchedItem.isPresent()) {
            return matchedItem;
        }

        // 2순위: 날씨만 맞는 옷
        matchedItem = findAndWear(user, items, item -> item.matchesWeather(weather));
        if (matchedItem.isPresent()) {
            return matchedItem;
        }

        // 3순위: 스타일만 맞는 옷
        matchedItem = findAndWear(user, items, item -> item.matchesStyle(style));
        if (matchedItem.isPresent()) {
            return matchedItem;
        }

        // 4순위: 아무것도 안 맞으면 추천하지 않기
        return Optional.empty();
    }

    private <T extends ClothingItem> Optional<T> findAndWear(User user, List<T> items, Predicate<T> condition) {
        for (T item : items) {
            if (condition.test(item) && item.tryWear(user)) {
                return Optional.of(item);
            }
        }

        return Optional.empty();
    }
}