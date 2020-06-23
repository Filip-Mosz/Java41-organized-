package pl.FilipM.May23;

public class ImmutableListElement {
    final String value;
    final StringListElement nextElement;

    public ImmutableListElement(String value, StringListElement nextElement) {
        this.value = value;
        this.nextElement = nextElement;
    }

    public String getValue() {
        return value;
    }

    public StringListElement getNextElement() {
        return nextElement;
    }
}
