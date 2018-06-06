public class Main {

    public static void main(String[] args) {
       Sort_Serial sort_serial=new Sort_Serial();
       int []data={1,4,7,2,5,8,3,6,9,0,-9,-5,89,45,12,789,3,7498,-7845,-46,-5};
       sort_serial.bubbleSort(data);
       int[] data1={1,4,7,2,5,8,3,6,9,0,-9,-5,89,45,12,789,3,7498,-7845,-46,-5};
       sort_serial.selectionSort(data1);
       int[] data2={1,4,7,2,5,8,3,6,9,0,-9,-5,89,45,12,789,3,7498,-7845,-46,-5};
       sort_serial.insertSort(data2);
       int[] data3={1,4,7,2,5,8,3,6,9,0,-9,-5,89,45,12,789,3,7498,-7845,-46,-5};
       //sort_serial.shellSort(data3);
       int[] data4={1,4,7,2,5,8,3,6,9,0,-9,-5,89,45,12,789,3,7498,-7845,-46,-5};
       sort_serial.mergeSort(data4);
    }
}
