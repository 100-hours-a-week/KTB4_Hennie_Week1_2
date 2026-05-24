package recommender;

import clothing.bottom.Bottom;
import clothing.outer.Outer;
import clothing.shoes.Shoes;
import clothing.top.Top;

import java.util.Optional;

public class Outfit {
    private final Optional<Top> top;
    private final Optional<Bottom> bottom;
    private final Optional<Outer> outer;
    private final Optional<Shoes> shoes;

    public Outfit(Optional<Top> top, Optional<Bottom> bottom, Optional<Outer> outer, Optional<Shoes> shoes) {
        this.top = top;
        this.bottom = bottom;
        this.outer = outer;
        this.shoes = shoes;
    }

    public Optional<Top> getTop() {
        return top;
    }

    public Optional<Bottom> getBottom() {
        return bottom;
    }

    public Optional<Outer> getOuter() {
        return outer;
    }

    public Optional<Shoes> getShoes() {
        return shoes;
    }
}
