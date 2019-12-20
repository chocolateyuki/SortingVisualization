import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort implements Runnable{

	private ArrayList<Integer> data;
	private VisualizerFrame frame;

	public BubbleSort(ArrayList<Integer> data, VisualizerFrame frame) {
		this.data = data;
		this.frame = frame;
	}

	public void run() {
		sort();
		SortingVisualizer.isSorting=false;
	}

	public void sort() {
		for (int i = 0; i < data.size() - 1; i++) {
			for (int j = 1; j < data.size(); j++) {
				if (data.get(j).compareTo(data.get(j - 1)) < 0) {
					Collections.swap(data, j, j-1);
					frame.reDrawArray(data, j, j+1, -1);
					try {
						Thread.sleep(SortingVisualizer.sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		frame.reDrawArray(data, -1, -1, -1);
	}
}
