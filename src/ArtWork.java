public abstract class ArtWork implements ITradeable,IComparable,ISearchable {
    protected String name;
    protected String style;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public abstract double calculateCost();

}
