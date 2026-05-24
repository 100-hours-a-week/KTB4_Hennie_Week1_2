package user;

public enum User {
    OLDER_SISTER("언니"),
    YOUNGER_SISTER("동생");

    private final String displayName;

    User(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}