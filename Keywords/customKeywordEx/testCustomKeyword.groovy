package customKeywordEx
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




public class testCustomKeyword {

	//get 5 random people in table
	@Keyword
	public static getInfoUsers(TestObject table, Integer num, String email) {
		//get current active web driver
		WebDriver driver = DriverFactory.getWebDriver()
		//get table
		WebElement Table = driver.findElement(By.xpath("//table[@id='resultTable']/tbody"))
		//all rows available in tag tr
		List<WebElement> rows_table = Table.findElements(By.tagName('tr'))
		int rows_count = rows_table.size()
		//KeywordUtil.logInfo('Total rows: '+rows_count)
		//loop all rows in table
		if(email!=null) {
			for (int row = 0; row < rows_count; row++) {
				//To locate columns(cells) of that specific row //tag name td in tr
				List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName('td'))
				//List<WebElement> 5Columns_row = rows_table.get(row).findElements(By.tagName('td'))
				//To calculate no of columns(cells) In that specific row' // how much td in tr
				//email in cell
				String celltext = Columns_row.get(3).getText();
				if (celltext == email) {
					KeywordUtil.logInfo('ID: ' + Columns_row.get(0).getText())
					break
				}
			}
		}else {
			Random random = new Random();

			for(int i =0;i<num;i++) {
				int randomIndex = random.nextInt(rows_count);
				List<WebElement> Columns_row = rows_table.get(randomIndex).findElements(By.tagName('td'))
				int columnCount = Columns_row.size();

				for(int j =0; j<columnCount;j++) {
					KeywordUtil.logInfo(Columns_row.get(j).getText()+' ')

				}
				rows_count -=1;
				rows_table.remove(randomIndex);

			}
		}
	}
	//check login page
	@Keyword
	def checkLogin(TestObject title) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(title);
			KeywordUtil.markPassed("Title founded")

		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Title not found")

		}catch (Exception e) {
			KeywordUtil.markFailed("Fail to check on element")
		}
	}

	//test case 02
	@Keyword
	public static checkActivities() {
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement category = driver.findElement(By.xpath('//*[@id = "category-list"]'))
		List<WebElement> categoryFilters = category.findElements(By.id('category-filter'))
		int categoryCount = categoryFilters.size()
		int categorySize = categoryFilters.size()
		for (int i = 0; i < categorySize; i++) {
			if(categoryFilters[i].getAttribute("class").contains("active")) {
				KeywordUtil.logInfo("Category " + categoryFilters[i].getText() + " is active " )
			}else {
				KeywordUtil.logInfo("Category " + categoryFilters[i].getText() + " is inactive " )
			}
		}
	}

	public static chooseDate(String dateTest) {

		//year start in calendar to start loop
		int yearOld =2009;
		int yearNew =2020;

		//current year appear in calendar
		String currentYear ='';

		int yearTest = Integer.parseInt(dateTest.substring(7, 11))
		int dayTest = Integer.parseInt(dateTest.substring(0, 2))

		//find year
		while(yearTest<yearOld || yearTest>yearNew)
		{
			//if year input < the smallest year then click previous btt else click next btt
			if(yearTest<yearOld) {
				WebUI.click(findTestObject('Object Repository/PageTutorial/bttPrevYear'))
			}else{
				WebUI.click(findTestObject('Object Repository/PageTutorial/bttNextYear'))
			}
			//set current year to check while loop
			currentYear = WebUI.getText(findTestObject('Object Repository/PageTutorial/switchDatePickerYear'))
			yearOld = Integer.parseInt(currentYear.substring(0, 4))
			yearNew = Integer.parseInt(currentYear.substring(5, 9))
		}
		//choose date
		WebUI.click(findTestObject('Object Repository/PageTutorial/spanByTextYear',['picker':'datepicker-years','year':yearTest]))
		WebUI.click(findTestObject('Object Repository/PageTutorial/spanByTextYear',['picker':'datepicker-months','year':dateTest.substring(3,6)]))
		if(dayTest<10) {
			WebUI.click(findTestObject('Object Repository/PageTutorial/tdByTextDay',['day':dateTest.substring(1, 2)]))
		}else {
			WebUI.click(findTestObject('Object Repository/PageTutorial/tdByTextDay',['day':dayTest]))
		}
	}
}
