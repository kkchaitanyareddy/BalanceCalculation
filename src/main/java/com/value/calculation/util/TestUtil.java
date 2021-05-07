package com.value.calculation.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import com.value.calculation.base.TestBase;



public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20; 
	public static ArrayList<String> text = new ArrayList<String>();
	public static String TotalValuetext="";
	
	public TestUtil() {
		PageFactory.initElements(driver, this);

	}

	public static List<WebElement> getText(String MultiElementLocater) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(By.xpath(MultiElementLocater));

			text.clear();
			System.out.println("elements size " + elements.size());
			for (int i = 0; i < elements.size(); i++) {

				String elementText = elements.get(i).getText();

				text.addAll(Arrays.asList(elementText));

			}
			System.out.println(text);
		} catch (Exception e) {
			System.out.println("Exception occured in selecting multiple elements due to " + e.getMessage());
		}

		return elements;

	}

	public static float floatTypeConversion(String S) {
		S = S.replaceAll("[^0-9.]", "");
		
		float f = Float.parseFloat(S);
		System.out.println("afters conversion value is  " + f);
		return f;
	}
	
	
	public static boolean intValidation(float id1,float id2) {
		boolean flag = false;
		if(id1 == id2) {
			System.out.println( id1 +" = " + id2);
			flag = true;
		}
		return false;
		
	}
	
	
	 public static String waitForText(String Webelement) {
		 try {
		 WebElement form = driver.findElement(By.xpath(Webelement));
		 if (form != null) {
		 TotalValuetext = form.getText();
		 System.out.println(TotalValuetext);
		 return TotalValuetext;
		 } else {
		 return null;
		 }
		 } catch (Exception e) {
		 return "";
		 }
	
	
		
	}}
	
	
		
		
	
	
	
	
	

