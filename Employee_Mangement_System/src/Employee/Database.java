package Employee;

import java.sql.*;
import java.math.BigInteger;

public class Database {
	
	public static void main(String args[])
	{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
			
			System.out.println(empIdGenerator("I.T", 9));
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver Not Found");
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}
	static String empIdGenerator(String department, int count)
    {
    	//empCode is generated by concatenating the DEPARTMENT_CODE and TOTAL_NUMBER_OF_EMPLOYEES + 1
    	String empCode = "aditya";
    	
    	//Every department have its own DEPARTMENT_CODE
    		//I.T 		 - 	01
    		//Electrical -  02
    		//Civil 	 - 	03
    		//Management - 	04
    		//Accounting - 	05
    	if(department == "I.T")
    	{
    		System.out.println("yes");
    		empCode = empCode + 01;
    		System.out.println("Emp Code - " + empCode);
    	}
    	else if(department == "Electrical")
    	{
    		empCode.concat("02");
    	}
    	else if(department == "Civil")
    	{
    		empCode.concat("03");
    	}
    	else if(department == "Management")
    	{
    		empCode.concat("04");
    	}
    	else if(department == "Accounting")
    	{
    		empCode.concat("05");
    	}
    	
    	System.out.println(empCode);
    	empCode.concat(Integer.toString(count+1));
    	System.out.println(empCode);
    	return empCode;
    }

}
