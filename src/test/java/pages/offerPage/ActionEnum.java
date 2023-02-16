package pages.offerPage;

public enum ActionEnum {
    DELETE(" Delete "),
    EDIT(" Edit ");

    ActionEnum(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
