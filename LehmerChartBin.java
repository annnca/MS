package charts;

import java.util.Collections;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import randomJava.Lehmer;

public class LehmerChartBin extends ApplicationFrame{
	public LehmerChartBin(final String title) {

        super(title);
        
        XYDataset dataset = createDataset();
        
        JFreeChart chart = ChartFactory.createXYLineChart(
            title,
            "X",
            "Y",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            false,
            false
        );
        XYPlot plot = (XYPlot) chart.getPlot();
        
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesShapesVisible(1, true);        
        plot.setRenderer(renderer);
        
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1500, 300));
        setContentPane(chartPanel);

    }
	
	 private XYDataset createDataset() {
		 XYSeries series = new XYSeries("Number of apparitions");
	        int noOfNumbersToBeGenerated = 1000;
			int a = 21;
			int c = 9;
			int m = 10000;
			int n = 200;
			double p = 0.8;
			   
			Lehmer random = new Lehmer(a, c, m, noOfNumbersToBeGenerated);
			List<Integer> numbers = random.binomialGenerator(n, p);

			  for(Integer s: numbers){  
				  series.add((Number)s.intValue(), Collections.frequency(numbers,s));
				 /* System.out.println(s + " " +Collections.frequency(numbers,s));*/

				 }
	        XYSeriesCollection dataset = new XYSeriesCollection();
	        dataset.addSeries(series);
	        return dataset;
	    }
}
