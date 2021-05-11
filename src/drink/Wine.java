package drink;

public class Wine extends Drink{
    private String region;

    public void Wine(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "[" + region + "]";
    }
}