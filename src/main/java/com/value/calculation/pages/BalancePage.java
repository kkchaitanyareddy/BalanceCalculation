package com.value.calculation.pages;

import java.awt.Label;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.record.LabelSSTRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.value.calculation.base.TestBase;
import com.value.calculation.util.TestUtil;

public class BalancePage extends TestBase {
	public static List<Float> val = new ArrayList<Float>();
	public static ArrayList<String> values;
	public static ArrayList<String> txtvalues;
	public static float TotalTransactionValue = 0;
	public static float sumOFIndividualTransactions = 0;

	// Initializing page objects
	public BalancePage() {
		PageFactory.initElements(driver, this);

	}

	public static void sumOFinvidualTransactions() {

		TestUtil.getText(prop.getProperty("labelvalues"));
		values = TestUtil.text;

		TestUtil.getText(prop.getProperty("individual_txtvalues"));
		txtvalues = TestUtil.text;

		val.clear();

		for (int i = 0; i < txtvalues.size() ; i++) {

			val.add(TestUtil.floatTypeConversion(txtvalues.get(i)));

		}
		System.out.println("transation values are " + val);

		for (int i = 0; i <= val.size() ; i++) {
			try {
				if (val.get(i) > 0.0) {

					sumOFIndividualTransactions = sumOFIndividualTransactions + val.get(i);
				}
			} catch (Exception e) {
				System.out.println(" Element is less than zero " + e.getMessage());
			}
		}

		System.out.println(sumOFIndividualTransactions);

	}

	public static void totalTransaction() {
		String txt = TestUtil.waitForText(prop.getProperty("Total_Txtvalues"));
		TotalTransactionValue = TestUtil.floatTypeConversion(txt);
		System.out.println(TotalTransactionValue);

	}

	public static boolean transactionValidation() {
		return TestUtil.intValidation(BalancePage.TotalTransactionValue, BalancePage.sumOFIndividualTransactions);

	}
	
	public static boolean validateNumberOFTransactions() {
		return TestUtil.intValidation(txtvalues.size(),val.size());

	}

}