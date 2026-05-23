package recommender;

import clothing.ClothingItem;
import clothing.Style;
import clothing.Weather;
import clothing.bottom.Bottom;
import clothing.outer.Outer;
import clothing.shoes.Shoes;
import clothing.top.Top;

import java.util.List;
import java.util.Optional;

public class Recommender extends ClothingCatalog{

    public Optional<Top> recommendTop(Weather weather, Style style) {
        return recommendByPriority(ClothingCatalog.TOPS, weather, style);
    }

    public Optional<Bottom> recommendBottom(Weather weather, Style style) {
        return recommendByPriority(ClothingCatalog.BOTTOMS, weather, style);
    }

    public Optional<Outer> recommendOuter(Weather weather, Style style) {
        if (weather == Weather.HOT) {
            return Optional.empty();
        }

        return recommendByPriority(ClothingCatalog.OUTERS, weather, style);
    }

    public Optional<Shoes> recommendShoes(Weather weather, Style style) {
        return recommendByPriority(ClothingCatalog.SHOES, weather, style);
    }

    private <T extends ClothingItem> Optional<T> recommendByPriority(List<T> items, Weather weather, Style style) {
        // 1순위: 날씨와 스타일이 모두 맞는 옷
        for (T item : items) {
            if (item.matches(weather, style)) {
                return Optional.of(item);
            }
        }

        // 2순위: 날씨만 맞는 옷
        for (T item : items) {
            if (item.matchesWeather(weather)) {
                return Optional.of(item);
            }
        }

        // 3순위: 스타일만 맞는 옷
        for (T item : items) {
            if (item.matchesStyle(style)) {
                return Optional.of(item);
            }
        }

        // 4순위: 아무것도 안 맞으면 추천하지 않기
        return Optional.empty();
    }
}