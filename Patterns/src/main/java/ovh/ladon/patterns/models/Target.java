package ovh.ladon.patterns.models;

public class Target {
    private Size size;
    private Visibility visibility;

    public Target(Size size, Visibility visibility) {
        this.size = size;
        this.visibility = visibility;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }
}
