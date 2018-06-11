import java.util.Arrays;
import java.util.concurrent.*;

class Sort_Parallel {

//归并排序
    void mergeSort(int data[]){
        long beginMilli=System.currentTimeMillis();
        ForkJoinPool pool=new ForkJoinPool();
        MergeSortTask task=new MergeSortTask(data);
        ForkJoinTask<int []> taskResult=pool.submit(task);
        try {
            Util.print(taskResult.get(),beginMilli,"mergeSort_parallel");
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace(System.out);
        }
    }

    private class MergeSortTask extends RecursiveTask<int []>{
        private int data[];
        public MergeSortTask(int data[]){
            this.data=data;
        }

        @Override
        protected int[] compute() {
            int sourceLen=data.length;
            if (sourceLen>2){
                int mid=sourceLen/2;
                MergeSortTask task1=new MergeSortTask(Arrays.copyOf(data,mid));
                task1.fork();
                MergeSortTask task2=new MergeSortTask(Arrays.copyOfRange(data,mid,sourceLen));
                task2.fork();

                int result1[]=task1.join();
                int result2[]=task2.join();
                int merge[]=joinInts(result1,result2);
                return merge;
            }else {
                if (sourceLen==1 || data[0]<data[1]){
                    return data;
                }else {
                    int target[]=new int[sourceLen];
                    target[0]=data[1];
                    target[1]=data[0];
                    return target;
                }
            }
        }

        private int[] joinInts(int[] result1, int[] result2) {
            int left=0;
            int right=0;
            int[] merge=new int[result1.length+result2.length];
            if (merge.length==0) return null;
            for(int i=0;i<result1.length+result2.length;i++){
                if (result1.length==left){
                    merge[i]=result2[right];
                    right++;
                    continue;
                }
                else if (result2.length==right){
                    merge[i]=result1[left];
                    left++;
                    continue;
                }
                if (result1[left]<=result2[right]){
                    merge[i]=result1[left];
                    left++;
                }else {
                    merge[i]=result2[right];
                    right++;
                }
            }
            return merge;
        }
    }

    //快速排序
    void quickSort(int data[]){
        long beginMilli=System.currentTimeMillis();
        ForkJoinPool pool=new ForkJoinPool();
        QuickSortTask task=new QuickSortTask(data,0,data.length-1);
        Future<Void> taskResult=pool.submit(task);
        try {
            taskResult.get();
            Util.print(data,beginMilli,"quickSort_parallel");
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace(System.out);
        }
    }

    private class QuickSortTask extends RecursiveAction{
        private int[] data;
        private int left;
        private int right;
        public QuickSortTask(int data[],int left,int right){
            this.data=data;
            this.left=left;
            this.right=right;
        }

        @Override
        protected void compute() {
            int base=partition(data,left,right);
            QuickSortTask task1=null;
            QuickSortTask task2=null;
            if (base-left>1){
                task1=new QuickSortTask(data,left,base-1);
                task1.fork();
            }
            if (right-base>1){
                task2=new QuickSortTask(data,base+1,right);
                task2.fork();
            }
            if (task1!=null && !task1.isDone()){
                task1.join();
            }
            if (task2!=null && !task2.isDone()){
                task2.join();
            }
        }
    }

    private int partition(int data[],int left,int right){
        int base=left;
        while (left<right){
            while (data[right]>=data[base] && left<right){
                right--;
            }
            Util.swap(data,right,base);
            base=right;
            while (data[left]<=data[base] && left<right){
                left++;
            }
            Util.swap(data,left,base);
            base=left;
        }
        return base;
    }
}
