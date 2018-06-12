public class Main {

    public static void main(String[] args) {
        int length=100000;
        Sort_Serial sort_serial=new Sort_Serial();
        Sort_Parallel sort_parallel=new Sort_Parallel();
        int []data=Util.getRandomData(length);

        int []data1=new int[length];
        for (int i=0;i<length;i++)
            data1[i]=data[i];

        int []data2=new int[length];
        for (int i=0;i<length;i++)
            data2[i]=data[i];

        int []data3=new int[length];
        for (int i=0;i<length;i++)
            data3[i]=data[i];

        int []data4=new int[length];
        for (int i=0;i<length;i++)
            data4[i]=data[i];

        int []data5=new int[length];
        for (int i=0;i<length;i++)
            data5[i]=data[i];

        int []data6=new int[length];
        for (int i=0;i<length;i++)
            data6[i]=data[i];

        int []data7=new int[length];
        for (int i=0;i<length;i++)
            data7[i]=data[i];

        int []data8=new int[length];
        for (int i=0;i<length;i++)
            data8[i]=data[i];
        sort_serial.bubbleSort(data1);

        sort_serial.selectionSort(data2);

        sort_serial.insertSort(data3);

        sort_serial.heapSort(data4);

        sort_serial.mergeSort(data5);
        sort_parallel.mergeSort(data6);

        sort_serial.quickSort(data7);
        sort_parallel.quickSort(data8);
    }
}
