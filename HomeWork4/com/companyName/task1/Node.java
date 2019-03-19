package HomeWork4.com.companyName.task1;

public class Node {
    private int element;
    private Node next;

    public Node () {

    }

    public Node (int element) {
        this.element = element;
    }

    public Node(int element, Node next) {

    }

    public void setElement(int element) {
        this.element = element;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getElement() {
        return element;
    }

    public Node getNext() {
        return next;
    }

}
