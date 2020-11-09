package com.corcentric.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.corcentric.pageClasses.ChapterOne;
import com.corcentric.pageClasses.Home;
import com.corcentric.utils.UtilFucntions;

public class TestCorcentric extends UtilFucntions {

	Home page_home;
	ChapterOne page_chapterOne;

	@BeforeClass
	public void Setup() {
		page_home = new Home();
		page_chapterOne = new ChapterOne();
	}

	@Test(priority = 1)
	public void testOneOpenPage() {
		openUrl();
		Assert.assertEquals(getText(page_home.Home_title), "Selenium: Beginners Guide");
	}

	@Test(priority = 2)
	public void testTwoOpenChapter1() {
		click(page_home.link_chapter_1);
		Assert.assertEquals(getText(page_chapterOne.div_left), "Assert that this text is on the page");
	}

	@Test(priority = 3)
	public void testThreeNavigateBack() {
		click(page_chapterOne.page_home);
		Assert.assertEquals(getText(page_home.Home_title), "Selenium: Beginners Guide");
	}

	@AfterClass
	public void teardown() {
		closeDriver();
	}
}
