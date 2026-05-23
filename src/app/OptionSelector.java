package app;

import clothing.SelectableOption;

public class OptionSelector {
    // 입력값 검증 (유효한 선택지만 남김)
    public static <T extends Enum<T> & SelectableOption> T fromInput(String input, T[] options) {
        String validatedInputValue = input.trim().toLowerCase();

        for (T option : options) {
            if (option.getValue().equals(validatedInputValue)) {
                return option;
            }
        }

        return null;
    }

    // 선택지 나열용
    public static String listingOptions(SelectableOption[] options) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < options.length; i++) {
            if (i > 0) {
                builder.append(" / ");
            }
            builder.append(options[i].getValue());
        }

        return builder.toString();
    }
}
