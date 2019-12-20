import java.util.ArrayList;

public class MergeSort implements Runnable{

    private ArrayList<Integer> data;
    private VisualizerFrame frame;

    public MergeSort(ArrayList<Integer> data, VisualizerFrame frame) {
        this.data = data;
        this.frame = frame;
    }

	public void run() {
		sort(data, 0, data.size()-1);
		SortingVisualizer.isSorting=false;
	}

   private void sort (ArrayList<Integer> data, int first, int last ) {
       int mid, lt, rt;
       int tmp;

       if (first >= last)
           return;

       mid = (first + last) / 2;

       sort (data, first, mid);
       sort (data, mid+1, last);

       lt = first;  rt = mid+1;

       if(data.get(mid) <= data.get(rt))
           return;

       while (lt <= mid && rt <= last) {
           if ( data.get(lt) <= data.get(rt))
               lt++;
           else {
               tmp = data.get(rt);
               for (int i = rt-lt;i>0; i--){
                   data.set(lt+i, data.get(lt+i-1));
               }
               data.set(lt, tmp);

               lt++;
               mid++;
               rt++;
           }

           frame.reDrawArray(data, mid, rt, lt);
           try {
               Thread.sleep(SortingVisualizer.sleep);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   }
}
