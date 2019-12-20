import java.util.ArrayList;
import java.util.Collections;

public class QuickSort implements Runnable{

    private ArrayList<Integer> data;
    private VisualizerFrame frame;

    public QuickSort(ArrayList<Integer> data, VisualizerFrame frame) {
        this.data = data;
        this.frame = frame;
    }

    public void run() {
        sort(0, data.size() - 1);
        SortingVisualizer.isSorting=false;
    }

    private void sort(int low, int high) {
        int i = low;
        int j = high;

        int pivot = data.get(low + (high - low) / 2);

        while (i <= j) {
            while (data.get(i) < pivot) {
                i++;
            }
            while (data.get(j) > pivot) {
                j--;
            }
            if (i <= j) {
                Collections.swap(data, i, j);
                i++;
                j--;
            }

            frame.reDrawArray(data, pivot, j, i);
            try {
                Thread.sleep(SortingVisualizer.sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (low < j) {
            sort(low, j);
        }

        if (i < high) {
            sort(i, high);
        }
    }
}
