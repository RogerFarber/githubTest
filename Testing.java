public class Testing {
    public static void main(String[] args)
    {
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedList Slist = new SinglyLinkedList();
       System.out.println("List size is " + list.size());
        System.out.println("List size is " + Slist.size());
        Slist.pushFront("Twelve");
        Slist.pushFront("Thirteen");
        Slist.pushFront("Fifteen");
        Slist.pushFront("Sixteen");
        Slist.pushFront("Seventeen");
        Slist.print();
        System.out.println("Flipping String");
        Slist.flip();
        Slist.print();
        Slist.flip();

        SinglyLinkedList.ListIteratorImpl Sfind = Slist.find("Twelve");

        System.out.println("Removing: "+Sfind);
        Slist.remove(Sfind);
        Slist.print();

        Sfind = Slist.find("Thirteen");
        System.out.println("Removing: "+Sfind);
        Slist.remove(Sfind);
        Slist.print();

        Sfind = Slist.find("Fifteen");
        System.out.println("Removing: "+Sfind);
        Slist.remove(Sfind);
        Slist.print();

        Sfind = Slist.find("Sixteen");
        System.out.println("Removing: "+Sfind);
        Slist.remove(Sfind);
        Slist.print();

        Sfind = Slist.find("Seventeen");
        System.out.println("Removing: "+Sfind);
        Slist.remove(Sfind);
        Slist.print();

        /*********************************************************/
       list.pushFront(12);
        list.print();
        list.popFront();
        list.print();
        System.out.println("must be 0 size, size is " + list.size());
        System.out.println("list is empty? " + list.isEmpty());

        list.pushFront(13);

        list.print();

        list.popFront();
        list.print();

        list.pushFront(15);
        list.pushFront(123);
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(43);
        list.pushFront(124454);
        list.pushFront(125345);

        SinglyLinkedList.ListIteratorImpl iter = list.begin();
        System.out.println("List size is " + list.size());

        while (iter.hasNext())
        {
            System.out.println(iter);
            iter.next();
        }

       System.out.println(iter);
        System.out.println(iter);

        SinglyLinkedList.ListIteratorImpl new_iter = list.begin();
        new_iter.next();
        new_iter.next();

        System.out.println(new_iter);
        list.print();
        list.InserInfront(new_iter, 42);
        list.print();

        SinglyLinkedList.ListIteratorImpl start = list.begin();
        list.InserInfront(start, 0);
        list.print();

        SinglyLinkedList.ListIteratorImpl find = list.find(42);
        System.out.println(find.toString());

        list.remove(find);
        list.print();

        find = list.find(0);
        list.remove(find);
        list.print();
        find = list.find(15);
        list.remove(find);
        list.print();
        find = list.find(123);
        list.remove(find);
        list.print();
        find = list.find(1223);
        System.out.println(find);

        list.print();
        list.flip();
        list.print();
    }
}
