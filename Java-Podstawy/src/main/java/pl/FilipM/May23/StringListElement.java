package pl.FilipM.May23;

public class StringListElement {

    private String value;
    private StringListElement next;
    private StringListElement previous;

    public StringListElement(String value) {
        this.value = value;
    }

    StringListElement() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public StringListElement getNext() {
        return next;
    }

    public void setNext(StringListElement next) {
        this.next = next;
    }

}
