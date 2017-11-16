package com.demo;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class TestNGPIEChart {

	public static void generateChart(int passVal, int failVal, int skipVal,
			int nonAttempt) throws IOException {
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("PASS", new Double(passVal));
		dataset.setValue("FAILD", new Double(failVal));
		dataset.setValue("SKIP", new Double(skipVal));
		dataset.setValue("NOT ATTEMPTED ", new Double(nonAttempt));

		JFreeChart chart = ChartFactory.createPieChart(
				"MavenTestNGDemo Unit Testcase Report", // chart title
				dataset, // data
				true, // include legend
				true, false);

		int width = 640; /* Width of the image */
		int height = 480; /* Height of the image */
		File pieChart = new File("PieChart.jpeg");
		ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height);
	}
	
	public static void main(String[] args) throws IOException {
		
		generateChart(40, 30, 48, 25);
	}
}
