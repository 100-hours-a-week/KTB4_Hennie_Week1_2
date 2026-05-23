package recommender;

import clothing.Style;
import clothing.Weather;
import clothing.bottom.Bottom;
import clothing.outer.Outer;
import clothing.shoes.Shoes;
import clothing.top.Top;

public class Recommender {

    public Top recommendTop(Weather weather, Style style) {
        // 상의 후보 목록
        Top[] tops = {
                new Top("TShirt", Style.CASUAL, Weather.HOT, "short sleeve"),
                new Top("Blouse", Style.FORMAL, Weather.WARM, "long sleeve"),
                new Top("Hoodie", Style.SPORTY, Weather.COOL, "long sleeve")
        };

        // 1순위: 날씨와 스타일이 모두 맞는 옷
        for (Top top : tops) {
            if (top.matches(weather, style)) {
                return top;
            }
        }

        // 2순위: 날씨만 맞는 옷
        for (Top top : tops) {
            if (top.matchesWeather(weather)) {
                return top;
            }
        }

        // 3순위: 스타일만 맞는 옷
        for (Top top : tops) {
            if (top.matchesStyle(style)) {
                return top;
            }
        }

        // 4순위: 아무것도 안 맞으면 추천하지 않기
        return null;
    }

    public Bottom recommendBottom(Weather weather, Style style) {
        Bottom[] bottoms = {
                new Bottom("Jeans", Style.CASUAL, Weather.COOL, "wide fit"),
                new Bottom("Slacks", Style.FORMAL, Weather.WARM, "straight fit"),
                new Bottom("Training Pants", Style.SPORTY, Weather.COOL, "loose fit")
        };

        for (Bottom bottom : bottoms) {
            if (bottom.matches(weather, style)) {
                return bottom;
        }
    }

        for (Bottom bottom : bottoms) {
            if (bottom.matchesWeather(weather)) {
                return bottom;
            }
    }

        for (Bottom bottom : bottoms) {
            if (bottom.matchesStyle(style)) {
                return bottom;
            }
        }

        return null;
    }

    public Outer recommendOuter(Weather weather, Style style) {
        if (weather == Weather.HOT) {
            return null;
        }

        Outer[] outers = {
                new Outer("Coat", Style.FORMAL, Weather.COLD, "thick"),
                new Outer("Cardigan", Style.CASUAL, Weather.COOL, "medium"),
                new Outer("Windbreak", Style.SPORTY, Weather.WINDY, "thin")
        };

        for (Outer outer : outers) {
            if (outer.matches(weather, style)) {
                return outer;
            }
        }

        for (Outer outer : outers) {
            if (outer.matchesWeather(weather)) {
                return outer;
            }
        }

        for (Outer outer : outers) {
            if (outer.matchesStyle(style)) {
                return outer;
            }
        }

        return null;
    }

    public Shoes recommendShoes(Weather weather, Style style) {
        Shoes[] shoesList = {
                new Shoes("Sneakers", Style.CASUAL, Weather.COOL),
                new Shoes("Mary Jane Shoes", Style.FORMAL, Weather.WARM),
                new Shoes("Crocs", Style.SPORTY, Weather.HOT)
        };

        for (Shoes shoes : shoesList) {
            if (shoes.matches(weather, style)) {
                return shoes;
            }
        }

        for (Shoes shoes : shoesList) {
            if (shoes.matchesWeather(weather)) {
                return shoes;
            }
        }

        for (Shoes shoes : shoesList) {
            if (shoes.matchesStyle(style)) {
                return shoes;
            }
        }

        return null;
    }
}