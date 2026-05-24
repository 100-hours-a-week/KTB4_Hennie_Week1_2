package option;

public enum Weather implements SelectableOption {
    HOT("hot"),
    WARM("warm"),
    COOL("cool"),
    COLD("cold"),
    WINDY("windy");

    private final String value;

    Weather(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
