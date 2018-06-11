public class Main {

    public static void main(String[] args) {
        int length=20;
        Sort_Serial sort_serial=new Sort_Serial();
        Sort_Parallel sort_parallel=new Sort_Parallel();
        int []data=Util.getRandomData(length);
       //int []data={1,4,7,2,5,8,3,6,9,0,-9,-5,89,45,12,789,3,7498,-7845,-46,-5};
       //int []data=Util.getRandomData(100000);
       //sort_serial.bubbleSort(data);
       //int[] data1={1,4,7,2,5,8,3,6,9,0,-9,-5,89,45,12,789,3,7498,-7845,-46,-5};
       // int []data1=Util.getRandomData(100000);
       //sort_serial.selectionSort(data1);
       //int[] data2={1,4,7,2,5,8,3,6,9,0,-9,-5,89,45,12,789,3,7498,-7845,-46,-5};
       // int []data2=Util.getRandomData(100000);
       //sort_serial.insertSort(data2);
       //int[] data3={1,4,7,2,5,8,3,6,9,0,-9,-5,89,45,12,789,3,7498,-7845,-46,-5};
       //sort_serial.shellSort(data3);
        int []data4=new int[length];
        for (int i=0;i<length;i++)
            data4[i]=data[i];
        sort_serial.mergeSort(data4);

        int []data5=new int[length];
        for (int i=0;i<length;i++)
            data5[i]=data[i];
        sort_serial.heapSort(data5);

        int []data6=new int[length];
        for (int i=0;i<length;i++)
            data6[i]=data[i];
        sort_serial.quickSort(data6);

        int []data7=new int[length];
        for (int i=0;i<length;i++)
            data7[i]=data[i];
        sort_parallel.mergeSort(data7);

        int []data8=new int[length];
        for (int i=0;i<length;i++)
            data8[i]=data[i];
        sort_parallel.quickSort(data8);
    }
}
