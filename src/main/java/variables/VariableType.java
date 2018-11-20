package variables;

import java.util.Arrays;

public enum VariableType {
    VEC3("vec3"),
    MAT("mat");

    private final String text;

    VariableType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static VariableType getTypeForText(String text) {
        return Arrays.stream(VariableType.values())
                .filter(type -> type.getText().equals(text))
                .findAny()
                .orElse(null);
    }
}
