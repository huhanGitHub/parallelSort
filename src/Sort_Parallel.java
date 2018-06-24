import java.util.concurrent.*;

class Sort_Parallel {

//归并排序
    void mergeSort(int data[]){
        long beginMilli=System.currentTimeMillis();
        ForkJoinPool pool=new ForkJoinPool();
        MergeSortTask task=new MergeSortTask(data,0,data.length-1);
        ForkJoinTask taskResult=pool.submit(task);
        try {
            taskResult.get();
            Util.print(data,beginMilli,"mergeSort_parallel");
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace(System.out);
        }
    }

    private class MergeSortTask extends RecursiveAction{
        private int data[];
        private int left;
        private int right;
        public MergeSortTask(int data[],int left,int right){
            this.data=data;
            this.left=left;
            this.right=right;
        }

        @Override
        protected void compute() {
            int sourceLen=right-left+1;
            if (sourceLen>2){
                int mid=(left+right)/2;
                MergeSortTask task1=new MergeSortTask(data,left,mid);
                task1.fork();
                MergeSortTask task2=new MergeSortTask(data,mid+1,right);
                task2.fork();

                task1.join();
                task2.join();
                joinInts(data,left,mid,right);
            }else {
                int mid=(left+right)/2;
                joinInts(data,left,mid,right);
            }
        }

        private void joinInts(int data[],int left,int mid,int right) {
            int len=right-left+1;
            int[] merge=new int[len];
            if (merge.length<=0) return;
            int i=left,j=mid+1;
            int index=0;
            while(i<=mid && j<=right){
                merge[index++]=data[i]<=data[j]?data[i++]:data[j++];
            }
            while (i<=mid) merge[index++] = data[i++];
            while (j<=right){
                merge[index++]=data[j++];
            }
            for(int k=0;k<merge.length;k++){
                data[left++]=merge[k];
            }
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
