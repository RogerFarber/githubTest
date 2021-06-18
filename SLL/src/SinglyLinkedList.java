public class SinglyLinkedList <T>{

    private Node head = new Node(null, null);

    private class Node{
        private Node next;
        private T data;

        public Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    public void print()
    {
        Node runner = this.head;

        while (null != runner)
        {
            System.out.print(runner.data + "->");
            runner = runner.next;
        }
        System.out.println("null");
    }
    public class ListIteratorImpl implements ListIterator
    {
        private Node my_node;

        ListIteratorImpl(Node node){
            this.my_node = node;
        }

        @Override
        public boolean hasNext()
        {
            return null != this.my_node.next;
        }

        @Override
        public T next()
        {
            T data = this.my_node.data;

            if (hasNext())
            {
                this.my_node = my_node.next;
            }
            return data;
        }
        @Override
        public String toString()
        {
            return ""+my_node.data;
        }
    }

    //creats a new iterator instance that hold the head node

    public ListIteratorImpl begin(){
        return new ListIteratorImpl(this.head);
    }
    // TODO add if data is also null
    public boolean isEmpty(){
        return this.head.next == null;
    }

    //creats new nodes and repraces it with the head node

    public void pushFront(T data){
        Node new_node = new Node(data, this.head);
        this.head = new_node;
    }
    public int size()
    {
        int counter = 0;

        Node runner = this.head;

        while (null != runner.next)
        {
            ++counter;

            runner = runner.next;
        }
        return counter;
    }

    public T popFront()
    {
        T data = this.head.data;
        this.head = this.head.next;
        return  data;
    }

    public void InserInfront(ListIteratorImpl iter, T insert)
    {
        if (this.head == iter.my_node)
        {
            pushFront(insert);
        }
        else
        {
            Node to_insert = new Node(iter.my_node.data, iter.my_node.next);
            iter.my_node.data = insert;
            iter.my_node.next = to_insert;
        }
    }

    public T remove(ListIteratorImpl iter)
    {
        T data = iter.my_node.data;

        if (isEmpty() == true)
        {
            return null;
        }
        iter.my_node.data = iter.my_node.next.data;
        iter.my_node.next = iter.my_node.next.next;

        return data;
    }

    public ListIteratorImpl find(T obj)
    {
        ListIteratorImpl runner = this.begin();

        while (runner.hasNext())
        {

            if (runner.my_node.data.equals(obj))
            {
                return runner;
            }
            runner.next();
        }
        return null;
    }

    public void flip(){
        Node prev = null;
        Node next = null;
        Node curr = this.head;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        this.head = prev;
    }

}

