public class Main {

    public static void main(String[] args) {
       Sort_Serial sort_serial=new Sort_Serial();
       int []data={1,4,7,2,5,8,3,6,9,0};
       sort_serial.bubbleSort(data);
       sort_serial.selectionSort(data);
       sort_serial.insertSort(data);
       sort_serial.ShellSort(data);
    }
}
