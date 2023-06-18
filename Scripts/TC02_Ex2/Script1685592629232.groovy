import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.security.KeyException

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import customKeywordEx.testCustomKeyword as KeyEx
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.intranetURL)

//CustomKeywords.'exCustomKey.checkLogin'(findTestObject('Object Repository/Page_Login Intranet/header_Login'))

'Input user name'
WebUI.setText(findTestObject('Object Repository/Page_Login Intranet/input_Username'), Email)
'Input password'
WebUI.setText(findTestObject('Object Repository/Page_Login Intranet/input_Password'), Password)
'Click btt login'
WebUI.click(findTestObject('Object Repository/Page_Login Intranet/btt_Login'))
'Verify login successfully'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Intranet/icon_Profile'))
'Click btt Activities'
WebUI.click(findTestObject('Object Repository/Page_Intranet/bttActivities'))
'List of Activities'
String[] arr = ['All', 'Event', 'ESAT' ]
'Loop to click each activity then check if activity is active and other is inactive'
for(int i = 0; i< arr.length ;i++) {
	WebUI.click(findTestObject('Object Repository/Page_Intranet/Activites/divByText', ['text':arr[i]]))
	KeywordUtil.logInfo("Test category "+ arr[i])
	KeyEx.checkActivities()
}

WebUI.closeBrowser()