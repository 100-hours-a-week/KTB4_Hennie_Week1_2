package clothing;

public enum Style implements SelectableOption {
    CASUAL("casual"),
    FORMAL("formal"),
    SPORTY("sporty");

    private final String value;

    Style(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
