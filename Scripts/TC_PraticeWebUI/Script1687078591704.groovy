import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.io.FileUtils

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Css value'
//WebUI.openBrowser('https://docs.katalon.com/docs/maintain/configure-failure-handling-settings-in-katalon-studio')

'Call test case'
//WebUI.callTestCase(findTestCase('Test Cases/TC02_Ex3'),null)

'Failure handing with if'
//WebUI.openBrowser('https://docs.katalon.com/docs/maintain/configure-failure-handling-settings-in-katalon-studio')
//if(WebUI.verifyElementNotClickable(findTestObject("Object Repository/katalonLogo"), FailureHandling.CONTINUE_ON_FAILURE)) {
//	KeywordUtil.logInfo("true")
//}
//WebUI.click(findTestObject("Object Repository/katalonLogo"))

'Read file txt'
//File notePadFile = new File("C:\\Users\\ASUS\\Downloads\\testReadFileTXT.txt")
//String text = FileUtils.readFileToString(notePadFile)
//KeywordUtil.logInfo(text)

'Read file excel by using libraly'
//FileInputStream file = new FileInputStream("C:\\Users\\ASUS\\Downloads\\testReadExcelFilexlsx.xlsx")
//Workbook wb = new XSSFWorkbook(file); //or new XSSFWorkbook("/somepath/test.xls")
//Sheet sheet = wb.getSheetAt(0);
//FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
//// suppose formula is in B1
//CellReference cellReference = new CellReference("B1");
//Row row = sheet.getRow(cellReference.getRow());
//Cell cell = row.getCell(cellReference.getCol());
//KeywordUtil.logInfo('mess '+ cell.getStringCellValue())


'Assert and verify'
WebUI.openBrowser('Trello.com')
B= WebUI.verifyElementNotVisible(findTestObject('Object Repository/Trello/features'), FailureHandling.OPTIONAL)
assert B == false


