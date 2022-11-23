class Node{
    int key;
    int value;
    Node next;

    public Node(int key, int value){
        this.key=key;
        this.value=value;
        this.next=null;
    }

}
public class MainClass {
    private Node [] entries;
    private static final int INITIAL_CAPACITY = 1 << 4;
    private static final int MAX_CAPACITY = 1 << 30;

    public MainClass(int capacity){
        int initialCapacity = getCapacityInPowerOf2(capacity);
        entries = new Node[initialCapacity];

    }

    public MainClass(){
        entries = new Node[INITIAL_CAPACITY];
    }

    private void putInMap(int key, int value){
        int index = Integer.valueOf(key).hashCode() % entries.length;

        if(entries[index] == null){
            entries[index] = new Node(key, value);
            return;
        }
        else
        {
            Node temp = entries[index];
            Node prev = null;
            while (temp != null || temp.key != key){
                prev = temp;
                temp = temp.next;
            }
            if(temp == null){
                Node newNode = new Node(key, value);
                prev.next = newNode;
            }
            else{
                temp.value=value;
            }
        }

    }

    private Integer getFromMap(int key){

        int index = Integer.valueOf(key).hashCode() % entries.length;
        if(entries[index] != null){
            Node temp = entries[index];
            while(temp != null && temp.key != key){
                temp = temp.next;
            }

            if(temp == null)
                return null;
            else return temp.value;

        }

        return null;
    }

    private int getCapacityInPowerOf2(int initialCapacity){
         //naive approach;
        int i = 1;
        while((int)Math.pow(2,i) < initialCapacity && i < 31)
            i++;


        return (int)Math.pow(2,i);
    }

    public static void main(String[] args) {

        MainClass obj = new MainClass();
        obj.putInMap(13,100);
        System.out.println(obj.getFromMap(15));



    }
}
