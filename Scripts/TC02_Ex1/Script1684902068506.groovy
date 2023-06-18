import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import customKeywordEx.testCustomKeyword as KeyEx
//login
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.intranetURL)

//CustomKeywords.'exCustomKey.checkLogin'(findTestObject('Object Repository/Page_Login Intranet/header_Login'))

WebUI.setText(findTestObject('Object Repository/Page_Login Intranet/input_Username'), Email)

WebUI.setText(findTestObject('Object Repository/Page_Login Intranet/input_Password'), Password)

WebUI.click(findTestObject('Object Repository/Page_Login Intranet/btt_Login'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Intranet/icon_Profile'))

//click EC
WebUI.click(findTestObject('Object Repository/Page_Intranet/icon_EmployeeContact'))

//check success E1
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_EmployeeContact/tabbar_EmployeeContact'))

//Click dropdown add fillter
WebUI.click(findTestObject('Object Repository/Page_EmployeeContact/dropdown_AddFillter'))
//choose option
WebUI.click(findTestObject('Object Repository/Page_EmployeeContact/option_BadgeID'))
//click button search
WebUI.click(findTestObject('Object Repository/Page_EmployeeContact/btt_Search'))
//verify fillter baged id appear E2
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_EmployeeContact/inputField_BadgeID'))
//verify no record showed E2
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_EmployeeContact/table_NoRecord'))
//type 'Binh'
WebUI.sendKeys(findTestObject('Object Repository/Page_EmployeeContact/inputField_FullName'), 'Binh')
//click search
WebUI.click(findTestObject('Object Repository/Page_EmployeeContact/btt_Search'))
//show record E3
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_EmployeeContact/table_NoRecord'), 5)
String email ='lthanhbinh@tma.com.vn'
//CustomKeywords.'customKeywordEx.testCustomKeyword.getInfoUsers'(findTestObject('Object Repository/Page_EmployeeContact/table_ResultTable'), null, email)
//WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Intranet/Activites/abc',['text':'Event']),0)
KeyEx.getInfoUsers(findTestObject('Object Repository/Page_EmployeeContact/table_ResultTable'), null, email)
WebUI.closeBrowser()
//script/ defn test object
