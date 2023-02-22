public class Main {
    public static void main(String[] args) {
        SortedArray arr = new SortedArray(20);
        arr.put(20);
        arr.put(10);
        arr.put(5);
        arr.put(9);
        arr.put(2);
        arr.put(6);
        arr.put(30);
        arr.put(1);
        System.out.println(arr);
        arr.removeElementAt(3);
        System.out.println(arr);
        if (arr.existsElement(15)) {
            System.out.println("exists");
        } else {
            System.out.println("doesn't exist");
        }
    }
}