package pages.dashboard;

public enum DashboardSectionEnum {
    CATEGORIES("categories"),
    GROUPS("groups"),
    NETWORKS("networks"),
    OFFERS("offers"),
    PRODUCTS("products"),
    SEGMENTS("segments");

    DashboardSectionEnum(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
