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

'Open browser'
WebUI.openBrowser('')
'Navigate to intranet'
WebUI.navigateToUrl(GlobalVariable.intranetURL)
//CustomKeywords.'exCustomKey.checkLogin'(findTestObject('Object Repository/Page_Login Intranet/header_Login'))
'Input user name'
WebUI.setText(findTestObject('Object Repository/Page_Login Intranet/input_Username'), Email)
'Inout password'
WebUI.setText(findTestObject('Object Repository/Page_Login Intranet/input_Password'), Password)
'Click btt login'
WebUI.click(findTestObject('Object Repository/Page_Login Intranet/btt_Login'))
'Verify login successfully'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Intranet/icon_Profile'))
'Click Employee Contact'
WebUI.click(findTestObject('Object Repository/Page_Intranet/icon_EmployeeContact'))
'E1: Check if tabbar is visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_EmployeeContact/tabbar_EmployeeContact'))
'Click dropdown add fillter'
WebUI.click(findTestObject('Object Repository/Page_EmployeeContact/dropdown_AddFillter'))
'Choose option BadgeID'
WebUI.click(findTestObject('Object Repository/Page_EmployeeContact/option_BadgeID'))
'Click button search'
WebUI.click(findTestObject('Object Repository/Page_EmployeeContact/btt_Search'))
'E2: Verify fillter baged id appear'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_EmployeeContact/inputField_BadgeID'))
'E2: Verify no record showed'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_EmployeeContact/table_NoRecord'))
'Type Binh into input field'
WebUI.sendKeys(findTestObject('Object Repository/Page_EmployeeContact/inputField_FullName'), 'Binh')
'Click button search'
WebUI.click(findTestObject('Object Repository/Page_EmployeeContact/btt_Search'))
'E3: Show record'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_EmployeeContact/table_NoRecord'), 5)
String email ='lthanhbinh@tma.com.vn'
'Get 5 random user'
KeyEx.getInfoUsers(findTestObject('Object Repository/Page_EmployeeContact/table_ResultTable'), 5, null)
'Return user ID with input Email'
KeyEx.getInfoUsers(findTestObject('Object Repository/Page_EmployeeContact/table_ResultTable'), null, email)
'Close browser'
WebUI.closeBrowser()

