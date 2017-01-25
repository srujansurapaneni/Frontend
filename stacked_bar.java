import java.awt.*;
import java.io.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtilities;
import java.text.DecimalFormat;
import org.jfree.ui.TextAnchor;
/** Values from command line input **/
public class stackedlabel{
    public static void main (String[] args) throws Exception, IOException
    {
        for (String s: args) {
            String arr[] = s.split(" ", 12);
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            int d = Integer.parseInt(arr[3]);
            int e = Integer.parseInt(arr[4]);
            int f = Integer.parseInt(arr[5]);
            int g = Integer.parseInt(arr[6]);
            int h = Integer.parseInt(arr[7]);
            int i = Integer.parseInt(arr[8]);
            int j = Integer.parseInt(arr[9]);
            int k = Integer.parseInt(arr[10]);
            int l = Integer.parseInt(arr[11]);
/** Create dataset based on inserted values **/
            final String EMP_MED = "Employer Paid - Medical";
            final String MBR_MED = "Member Paid - Medical";
            final String EMP_RX  = "Employer Paid - Pharmacy";
            final String MBR_RX  = "Member Paid - Pharmacy";
            final String Base    = "Base";
            final String Current = "Current";
            final String Norm    = "Norm";
            final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(a, EMP_MED, Base);
            dataset.addValue(b, EMP_MED, Current);
            dataset.addValue(c, EMP_MED, Norm);
            dataset.addValue(d, MBR_MED, Base);
            dataset.addValue(e, MBR_MED, Current);
            dataset.addValue(f, MBR_MED, Norm);
            dataset.addValue(g, EMP_RX, Base);
            dataset.addValue(h, EMP_RX, Current);
            dataset.addValue(i, EMP_RX, Norm);
            dataset.addValue(j, MBR_RX, Base);
            dataset.addValue(k, MBR_RX, Current);
            dataset.addValue(l, MBR_RX, Norm);
/** Create template chart from dataset values **/
            JFreeChart barChart = ChartFactory.createStackedBarChart(
                    " ",
                    " ",
                    " ",
                    dataset,
                    PlotOrientation.HORIZONTAL,
                    false,
                    true,
                    false);
/** Override chart cosmetic features **/
            final CategoryPlot plot = barChart.getCategoryPlot();
            plot.setRangeGridlinesVisible(false);
            plot.setBackgroundPaint(Color.white);
            plot.setOutlineVisible(false);
            final StackedBarRenderer renderer = new StackedBarRenderer();
            plot.setRenderer(renderer);
            ValueAxis range = plot.getRangeAxis();
            range.setVisible(false);
            CategoryAxis ydomain = plot.getDomainAxis();
            ydomain.setVisible(false);
/** Generate label values for each stack and override default cosmetics **/
            System.setProperty("blue","0x002850");
            System.setProperty("lightblue","0x006586");
            System.setProperty("green","0x39B44A");
            System.setProperty("darkgreen","0x007A3E");
            renderer.setSeriesPaint(0,Color.white);
            renderer.setSeriesPaint(1,Color.white);
            renderer.setSeriesPaint(2,Color.white);
            renderer.setSeriesPaint(3,Color.white);
            renderer.setSeriesItemLabelPaint(0,Color.getColor("blue"));
            renderer.setSeriesItemLabelPaint(1,Color.getColor("lightblue"));
            renderer.setSeriesItemLabelPaint(2,Color.getColor("green"));
            renderer.setSeriesItemLabelPaint(3,Color.getColor("darkgreen"));
            renderer.setSeriesItemLabelFont(0, new java.awt.Font("Arial", Font.BOLD,14));
            renderer.setSeriesItemLabelFont(1, new java.awt.Font("Arial", Font.BOLD,14));
            renderer.setSeriesItemLabelFont(2, new java.awt.Font("Arial", Font.BOLD,14));
            renderer.setSeriesItemLabelFont(3, new java.awt.Font("Arial", Font.BOLD,14));
            renderer.setSeriesPositiveItemLabelPosition(0, new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
            renderer.setSeriesPositiveItemLabelPosition(1, new ItemLabelPosition(ItemLabelAnchor.OUTSIDE1, TextAnchor.CENTER));
            renderer.setSeriesPositiveItemLabelPosition(2, new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
            renderer.setSeriesPositiveItemLabelPosition(3, new ItemLabelPosition(ItemLabelAnchor.OUTSIDE1, TextAnchor.CENTER));
            renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("$#,##0")));
            renderer.setBaseItemLabelsVisible(true);
            renderer.setDrawBarOutline(false);
            renderer.setShadowVisible(false);
            renderer.setMaximumBarWidth(0.15);
/** output to a jpeg **/
            int width  = 500; /* Width of the image */
            int height = 200; /* Height of the image */
            File BarChart = new File("BarChart.jpeg");
            ChartUtilities.saveChartAsJPEG(BarChart, barChart, width, height);
        }
    }
}