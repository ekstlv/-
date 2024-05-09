import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;

public class PerformanceChart {

    public static void main(String[] args) {
        XYSeries series = new XYSeries("Execution Time");

        for (int size = 1000; size <= 10000; size += 1000) {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                numbers.add(i);
            }

            long startTime = System.currentTimeMillis();
            NumberProcessor._sum(numbers);
            long endTime = System.currentTimeMillis();

            series.add(size, endTime - startTime);
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Performance Analysis",
                "Number of Elements",
                "Time (Milliseconds)",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
