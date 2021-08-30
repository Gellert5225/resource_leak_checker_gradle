package gradle_test;

public class Object {
    private String name;

    public Object(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hello " + this.name;
    }
}