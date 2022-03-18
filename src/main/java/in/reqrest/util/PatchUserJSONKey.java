package in.reqrest.util;

public enum PatchUserJSONKey {
    NAME("[name]"),
    JOB("[job]");

    private final String value;

    PatchUserJSONKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

