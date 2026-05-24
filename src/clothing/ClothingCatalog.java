package clothing;

import option.Style;
import option.Weather;
import clothing.bottom.Bottom;
import clothing.outer.Outer;
import clothing.shoes.Shoes;
import clothing.top.Top;

import java.util.List;

public class ClothingCatalog {
    public static final List<Top> TOPS = List.of(
            new Top("TShirt", Style.CASUAL, Weather.HOT, "short sleeve"),
            new Top("Blouse", Style.FORMAL, Weather.WARM, "long sleeve"),
            new Top("Hoodie", Style.SPORTY, Weather.COOL, "long sleeve")
    );

    public static final List<Bottom> BOTTOMS = List.of(
            new Bottom("Jeans", Style.CASUAL, Weather.COOL, "wide fit"),
            new Bottom("Slacks", Style.FORMAL, Weather.WARM, "straight fit"),
            new Bottom("Training Pants", Style.SPORTY, Weather.COOL, "loose fit")
    );

    public static final List<Outer> OUTERS = List.of(
            new Outer("Coat", Style.FORMAL, Weather.COLD, "thick"),
            new Outer("Cardigan", Style.CASUAL, Weather.COOL, "medium"),
            new Outer("Windbreak", Style.SPORTY, Weather.WINDY, "thin")
    );

    public static final List<Shoes> SHOES = List.of(
            new Shoes("Sneakers", Style.CASUAL, Weather.COOL),
            new Shoes("Mary Jane Shoes", Style.FORMAL, Weather.WARM),
            new Shoes("Crocs", Style.SPORTY, Weather.HOT)
    );
}