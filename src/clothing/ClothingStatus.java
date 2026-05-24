package clothing;

// 옷 상태 추가
public enum ClothingStatus {
    CLEAN("깨끗함"),
    IN_LAUNDRY("빨래 바구니");

    private final String value;

    ClothingStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}