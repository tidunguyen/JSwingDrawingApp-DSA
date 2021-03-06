package sorting;

import geom.Graph;
import geom.Graph.GraphMode;
import geom.Point2D;
import geom.PointComparator;
import geom.SpaceMapping;

import java.awt.*;

public class Sorting {
    @SuppressWarnings("rawtypes")
    static ISort[] algorithms = { 
            new BubbleSort<Point2D>(), 
            new SelectionSort<Point2D>(),
            new StraightInsertionSort<Point2D>(), 
            new ShellSort<Point2D>(), 
            new QuickSort<Point2D>(),
            new MergeSort<Point2D>(), 
            new HeapSort<Point2D>() };

    static Color[] colors = { Color.RED, Color.GREEN, Color.BLUE, Color.CYAN, Color.YELLOW, Color.MAGENTA,
            Color.ORANGE };

    /*
     * Question 8: Shell sort is the best because with the sequence {1, 3, 7}, time
     * complexity to shell sort is O(n^1.5) while all the others have time
     * complexity to O(n^2)
     * 
     * Bubble Sort is the worst because bubble sort algorithm compare adjacent
     * elements which leads to longer processing time on average compared to other
     * algorithms.
     */

    public static Graph[] graphIt(SpaceMapping spaceMapping) {
        Graph[] graphs = new Graph[algorithms.length];
        for (int i = 0; i < algorithms.length; i++) {
            Point2D[] performances = SortingEval.timeit(algorithms[i], 500, 500, new PointComparator());
            spaceMapping.updateLogViewPort(0, 500, 0, 1.2);
            graphs[i] = new Graph(performances, colors[i], GraphMode.SCATTER);
        }
        return graphs;
    }

    public static void main(String[] args) {
//        SortingEval.timeit(new QuickSort(), 50, 50, new PointComparator());
        SortDemo.demoValue(500, algorithms[1], ISort.SortDirection.DESCENDING);
    }
}
