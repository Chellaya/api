package com.report;

import java.io.File;
import java.util.LinkedList;

import com.base.BaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * @author ashok
 * @see this used to perform report by extends BaseClass
 * @since 02-06-2023
 *
 */
public class Reporting extends BaseClass {

/**
 * @author ashok
 * @param jas
 * @see this method used to perform generateReport
 * @since 02-06-2023
 */
public static void generateReport(String jas) {
		
		File f = new File("D:\\eclipse\\OMRBranchAPIAutomation\\target");
		
		Configuration con = new Configuration(f, "OMRBranchAPIAutomation");
		con.addClassifications("browser ", "chrome");

		LinkedList<String> jason = new LinkedList<String>();
		jason.add(jas);
		ReportBuilder builder = new ReportBuilder(jason, con);
		builder.generateReports();
		
	}


}
