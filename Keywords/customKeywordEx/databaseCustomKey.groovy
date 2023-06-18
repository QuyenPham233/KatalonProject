package customKeywordEx

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class databaseCustomKey {

	private static java.sql.Connection connection = null;

	@Keyword
	public static connectDB(String url, String dbname, String port, String username, String password){
		String conn = "jdbc:mysql://" + url + ":" + port + "/" + dbname
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection =  DriverManager.getConnection(conn, username, password)
		return connection
	}

	@Keyword
	public static executeQuery(String queryString) {
		connectDB("sql12.freesqldatabase.com", "sql12626093", "3306", "sql12626093", "fHVrhJQSKx")
		Statement stm = connection.createStatement()
		if(queryString.contains("SELECT")){
			ResultSet result = stm.executeQuery(queryString)
			return result
		}else {
			int result = stm.executeUpdate(queryString)
			return result
		}
	}
}
