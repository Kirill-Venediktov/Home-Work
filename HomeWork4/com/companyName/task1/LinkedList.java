package HomeWork4.com.companyName.task1;

public class LinkedList {

    private Node firstNode;

    public void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }

    public Node getFirstNode() {
        return firstNode;
    }

    public void add(int element) {
        if (firstNode == null) {
            this.setFirstNode(new Node (element));
        } else {
            Node currentNode = this.getFirstNode();
            while (currentNode.getNext() != null){
                currentNode.getNext();
            }
            currentNode.setNext(new Node(element));
       }

   }

    public void remove() {
        Node currentNode = this.getFirstNode();
        if (currentNode.getNext() != null) {
            while (currentNode.getNext().getNext() != null) {
                currentNode.getNext();
            }
            currentNode.setNext(null);
        } else {
            this.setFirstNode(null);
        }

    }

}
