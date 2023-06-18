import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.sql.ResultSet

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import customKeywordEx.databaseCustomKey as Data

'Insert data'
String insert = "INSERT INTO SUBJECT (Name_Subject,ID) VALUES ('History','3')"
'Update data'
String update ="UPDATE ACCOUNT set Name = 'quyen1@gmai.com' where ID = 1"
'Inner join'
String join = "SELECT Name, Name_Subject FROM ACCOUNT JOIN SUBJECT on ACCOUNT.ID = SUBJECT.ID"
'Select user have more than 1 subject'
String select = "SELECT Name from ACCOUNT where ID in (SELECT ID from SUBJECT group by ID having count(ID)>1)"

'Run query Insert/Delete/Update'
int result = Data.executeQuery(update)

'Run query Select then add result to list'
ResultSet result = Data.executeQuery("")
List<String> userName = new ArrayList<String>();
while (result.next()) {
	userName.add(result.getString("Name"))
	KeywordUtil.logInfo(result.getString("Name"))
}
