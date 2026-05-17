package recommender;

import clothing.bottom.Bottom;
import clothing.bottom.Jeans;
import clothing.bottom.Slacks;
import clothing.bottom.Training;
import clothing.outer.Cardigan;
import clothing.outer.Coat;
import clothing.outer.Outer;
import clothing.outer.Windbreak;
import clothing.shoes.Crocs;
import clothing.shoes.MaryJaneShoes;
import clothing.shoes.Shoes;
import clothing.shoes.Sneakers;
import clothing.top.Blouse;
import clothing.top.Hoodie;
import clothing.top.TShirt;
import clothing.top.Top;

public class Recommender {

    public Top recommendTop(String weather, String style) {
        // 상의 후보 목록
        Top[] tops = {
                new TShirt(),
                new Blouse(),
                new Hoodie()
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

    public Bottom recommendBottom(String weather, String style) {
        Bottom[] bottoms = {
                new Jeans(),
                new Slacks(),
                new Training()
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

    public Outer recommendOuter(String weather, String style) {
        if (weather.equals("hot")) {
            return null;
        }

        Outer[] outers = {
                new Coat(),
                new Cardigan(),
                new Windbreak()
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
    public Shoes recommendShoes(String weather, String style) {
        Shoes[] shoesList = {
                new Sneakers(),
                new MaryJaneShoes(),
                new Crocs()
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