/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiyoshi.gui;

import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class AreaChart extends JPanel {

    public ChartPanel chartPanel;

    public JPanel getChart() {
        // create a dataset...
        final double[][] data = new double[][]{
            {1.0, 4.0, 3.0, 5.0, 5.0, 7.0, 7.0, 8.0},
            {5.0, 7.0, 6.0, 8.0, 4.0, 4.0, 2.0, 1.0},
            {4.0, 3.0, 2.0, 3.0, 6.0, 3.0, 4.0, 3.0}
        };

        final CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
                "Series ", "Type ", data
        );

        // create the chart...
        final JFreeChart chart = createChart(dataset);
        chartPanel = new ChartPanel(chart);
        JPanel b = new JPanel();
        JPanel c = (JPanel) b.add(chartPanel);
        return c;
    }

    private JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createAreaChart(
                "Area Chart", // chart title
                "Category", // domain axis label
                "Value", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                false // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        // set the background color for the chart...
//        final StandardLegend legend = (StandardLegend) chart.getLegend();
        //      legend.setAnchor(StandardLegend.SOUTH);
        chart.setBackgroundPaint(Color.white);
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setForegroundAlpha(0.5f);

        //      plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        domainAxis.setLowerMargin(0.0);
        domainAxis.setUpperMargin(0.0);
        domainAxis.addCategoryLabelToolTip("Type 1", "The first type.");
        domainAxis.addCategoryLabelToolTip("Type 2", "The second type.");
        domainAxis.addCategoryLabelToolTip("Type 3", "The third type.");

        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setLabelAngle(0 * Math.PI / 2.0);
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;

    }
}
