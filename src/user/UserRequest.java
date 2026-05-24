package user;

import option.Style;
import option.Weather;

public class UserRequest {
    private final User user;
    private final Weather weather;
    private final Style style;

    public UserRequest(User user, Weather weather, Style style) {
        this.user = user;
        this.weather = weather;
        this.style = style;
    }

    public User getUser() {
        return user;
    }

    public Weather getWeather() {
        return weather;
    }

    public Style getStyle() {
        return style;
    }
}
