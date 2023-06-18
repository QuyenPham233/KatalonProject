import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.security.KeyException

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import customKeywordEx.testCustomKeyword as KeyEx
WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.intranetURL)

//CustomKeywords.'exCustomKey.checkLogin'(findTestObject('Object Repository/Page_Login Intranet/header_Login'))

WebUI.setText(findTestObject('Object Repository/Page_Login Intranet/input_Username'), Email)

WebUI.setText(findTestObject('Object Repository/Page_Login Intranet/input_Password'), Password)

WebUI.click(findTestObject('Object Repository/Page_Login Intranet/btt_Login'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Intranet/icon_Profile'))

WebUI.click(findTestObject('Object Repository/Page_Intranet/bttActivities'))

String[] arr = ['All', 'Event', 'ESAT' ]

for(int i = 0; i< arr.length ;i++) {
	WebUI.click(findTestObject('Object Repository/Page_Intranet/Activites/divByText', ['text':arr[i]]))
	KeywordUtil.logInfo("Test category "+ arr[i])
	//CustomKeywords.'customKeywordEx.testCustomKeyword.checkActivities'()
	KeyEx.checkActivities()
}

WebUI.closeBrowser()