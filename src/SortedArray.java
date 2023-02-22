public class SortedArray {
    private int[] array;
    private int numElements;
    public SortedArray(int n) {
        array = new int[n];
        numElements=0;
        for (int i = 0; i < n; i++) {
            array[i] = -1;
        }
    }
    public int getElementAt(int n) {
        return array[n];
    }
    public int getNumElements() {
        return numElements;
    }
    public int getSize() {
        return array.length;
    }
    public boolean isEmpty() {
        return numElements == 0;
    }
    public boolean isFull() {
        return array.length + 1 == numElements;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numElements; i++) {
            if (i == 0)
                s.append("" + array[i]);
            else
                s.append("," + array[i]);
        }
        return s.toString();
    }
    public void put(int element) {
        int cont = numElements - 1;
        // shift elements to the right
        while (( cont >= 0) && (array[cont] > element)) {
            if (cont < array.length)
                array[cont + 1] = array[cont];
            cont--;
        }

        if (!((cont == numElements - 1) && (numElements == array.length))) {
            array[cont + 1] = element;
            numElements++;
        }
    }
    public void removeElementAt(int n) {
        if ((n > numElements - 1) || (n < 0)) {
            return;
        }
        for (int i = n; i < numElements - 1; i++) {
            if (i < array.length - 1)
                array[i] = array[i + 1];
        }
        array[numElements - 1] = -1;
        numElements--;
    }
    public boolean existsElement(int elem) {
        return binarySearch(elem,0,numElements - 1);
    }
    public boolean existsElementNonRecursiveAndSimple(int element) {
        int cont = 0;
        while ((array[cont] < element) && (cont < numElements - 1)) {
            cont++;
        }
        return array[cont] == element;
    }

    // Exercise binarySearch method
    public boolean binarySearch(int elem, int minorIndex, int upperIndex) {
        if (minorIndex > upperIndex)
            return false;
        int middle= minorIndex + (upperIndex - minorIndex) / 2;
        if (elem == array[middle])
            return true;
        else {
            if (elem < array[middle]) {
                return binarySearch(elem, minorIndex, middle - 1);
            } else {
                return binarySearch(elem, middle + 1, upperIndex);
            }
        }
    }
}