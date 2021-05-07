package com.value.calculation.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.value.calculation.base.TestBase;
import com.value.calculation.pages.BalancePage;

import com.value.calculation.util.TestUtil;

public class LoginPageTest extends TestBase {

	BalancePage balancepage;
	TestUtil testutil;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();

		testutil = new TestUtil();
		balancepage = new BalancePage();

	}

	@Test
	public void valueCaliculation() throws InterruptedException {

		BalancePage.sumOFinvidualTransactions();
		BalancePage.totalTransaction();
		assertTrue(BalancePage.validateNumberOFTransactions());
		assertTrue(BalancePage.transactionValidation());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
