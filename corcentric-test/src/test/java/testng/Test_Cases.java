package testng;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import page_objects.ChapterOne;
import page_objects.Home;
import utils.Util_fucntions;

public class Test_Cases extends Util_fucntions{
	
	Home page_home;
	ChapterOne page_chapterOne;

    @BeforeClass
    public void Setup() {
    	page_home = new Home();
    	page_chapterOne = new ChapterOne();
    }
	
    @Test(priority = 1)
    public void test_1_openPage() {
    	open_url();
        Assert.assertEquals(getText(page_home.Home_title), "Selenium: Beginners Guide");
    }
    
    @Test(priority = 2)
    public void test_2_open_chapter1() {
    	click(page_home.link_chapter_1);
        Assert.assertEquals(getText(page_chapterOne.div_left), "Assert that this text is on the page");
    }
    
    @Test(priority = 3)
    public void test_3_navigate_back() {
    	click(page_chapterOne.page_home);
        Assert.assertEquals(getText(page_home.Home_title), "Selenium: Beginners Guide");
    }
    
    @AfterClass
    public void teardown() {
    	close_driver();
    }
}
