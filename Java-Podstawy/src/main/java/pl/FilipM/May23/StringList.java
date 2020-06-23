package pl.FilipM.May23;

public class StringList {
    private StringListElement head;
    private StringListElement tail;
    private int lenght;

    public StringList() {
        this.head = null;
        this.tail = null;
        this.lenght = 0;
    }

    public StringList(String val) {
        this.head = new StringListElement(val);
    }

    public int getLenght() {
        return lenght;
    }

    public void add(String newValue) {
        StringListElement element = new StringListElement(newValue);

        if (head == null) {
            head = element;
            //tail = element;
        } else {
            tail.setNext(element);
        }

        tail = element;
        lenght++;
    }

    public void addAt(String newValue, int index) {
        StringListElement element = new StringListElement(newValue);

        if (head == null) {
            head = element;
        } else {
            if (index > 0) {
                int currentIndex = 0;
                StringListElement currentElement = head;
                StringListElement previousElement = null;
                while (currentElement != null && currentIndex < index) {
                    previousElement = currentElement;
                    previousElement.setNext(currentElement.getNext());
                    currentIndex++;
                }
                if (previousElement != null) {
                    previousElement.setNext(element);
                }
            } else if (index == 0) {
                element.setNext(head);
            }
        }

        //tail = element;
        lenght++;
    }

    @Override
    public String toString() {

        StringListElement current = this.head;
        StringBuilder printList = new StringBuilder();

        while(current != null) {
            printList.append(current.getValue()).append(" ");
            current = current.getNext();
        }

        return printList.toString();
    }
}
