package com.company.vendor.utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;


@Component
public class ReportUtilityimpl implements ReportUtility {

	@Override
	public void generatePieChart(String path, List<Object[]> data) 
	{
		// TODO Auto-generated method stub
		DefaultPieDataset dataset = new DefaultPieDataset();
		for(Object[] object : data) {
			dataset.setValue(object[0].toString(),Double.parseDouble(object[1].toString()));
		}
		JFreeChart chart = ChartFactory.createPieChart3D("Vendor Type Report", dataset);
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/report.jpeg"), chart, 500, 500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
