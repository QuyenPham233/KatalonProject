import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import customKeywordEx.testCustomKeyword as Custom
import internal.GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.tutorialsninjaURL)
'Search "HP LP3065" '
WebUI.setText(findTestObject('Object Repository/PageTutorial/searchBar'), 'HP LP3065')
'Click btt Search'
WebUI.click(findTestObject('Object Repository/PageTutorial/bttSearch'))
'Click product image'
WebUI.click(findTestObject('Object Repository/PageTutorial/productImage'))
'Click btt calendar'
WebUI.click(findTestObject('Object Repository/PageTutorial/bttCalenda'))
'Click swicth to mont'
WebUI.click(findTestObject('Object Repository/PageTutorial/switchDatePickerDate'))
'Click switch to year'
WebUI.click(findTestObject('Object Repository/PageTutorial/switchDatePickerMonth'))

String dateTest = "01/Sep/2000"
'Choose date in celendar'
Custom.chooseDate(dateTest)
'Get value of date after choosed'
dateActual = WebUI.getAttribute(findTestObject('Object Repository/PageTutorial/inputField'), 'value')
'Convert date in celendar to format of test value'
SimpleDateFormat format1 = new SimpleDateFormat("dd/MMM/yyyy")
SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd")
Date date = format2.parse(dateActual)
String formatDateActual = format1.format(date)

'Verify date in celendar after choosed equal date test'
WebUI.verifyEqual(formatDateActual, dateTest)
