package com.blz.D34_JDBCProgram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBCProgram {

	public static void main(String[] args) {
		/*
		 * Defining url of database, username & password for JDBC
		 */
		String dbUrl = "jdbc:mysql://localhost:3306/employeePayroll";
		String username = "root";
		String password = "K@$turi@2808";

		try {
			/*
			 * using connection connecting database to drivemanager
			 * showing options to user to select the operation
			 * If improper inputs given by user then throwing exception for the same
			 */
			Connection connection = DriverManager.getConnection(dbUrl, username, password);
			System.out.println("Welcome to CRUD operation using JDBC.....");
			System.out.println("Enter your choice");
			System.out.println("1. Create data into database");
			System.out.println("2. Read the data from database");
			System.out.println("3. Update the data from database");
			System.out.println("4. Delete the data from the database");
			Scanner sc = new Scanner(System.in);
			int i  = sc.nextInt();
			switch (i) {
			case 1:
				/*
				 * Using preparedstatement creating a data into database
				 * executing the result
				 */
			{
          PreparedStatement prep = connection
                    .prepareStatement("insert into employeePayroll (ID,Employee_name,phone_number,address,department,Start_date,Salary) values (?,?,?,?,?,?,?)");
            prep.setInt(1, 3);
            prep.setString(2, "Dhananjay");
            prep.setString(3, "953791482");
            prep.setString(4, "vashi");
            prep.setString(5, "QC");
            prep.setString(6, "2022-09-06");
            prep.setInt(7, 300000);
            prep.executeUpdate();
            System.out.println("Data added successfully.....");
			}
			break;
			case 2:
			{
				/*
				 * Using prepared statement giving SQL command 
				 * Executing update and printing th data
				 */
			PreparedStatement prep1 = connection.prepareStatement("select * from employeePayroll");
			ResultSet resultSet = prep1.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("ID"));
				System.out.println(resultSet.getString("Employee_name"));
				System.out.println(resultSet.getString("phone_number"));
				System.out.println(resultSet.getString("address"));
				System.out.println(resultSet.getString("department"));
				System.out.println(resultSet.getString("Start_date"));
				System.out.println(resultSet.getInt("Salary"));
			}
			}
			break;
			case 3:
			{
				/*
				 * Using preparedstatement giving command for updation of data
				 * executing the query 
				 */
				PreparedStatement prep2 = connection.prepareStatement("update employeePayroll set Salary = '200000' where ID='1'");
				
				prep2.executeUpdate();
			}
			break;
			case 4:
			{
				/*
				 * Using preparedstatement giving command to delete the data
				 * Executing the query and get vresult into MySQL
				 */
                PreparedStatement prep3 = connection.prepareStatement("delete from employeePayroll where ID = '2'");
				
				prep3.executeUpdate();
			}
			break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
