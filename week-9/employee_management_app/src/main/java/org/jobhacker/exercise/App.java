package org.jobhacker.exercise;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public class App 
{
    public static void main( String[] args ) throws SQLException {
        String userName = "root";
        String password = "root";

        MysqlDataSource mysqlDS = new MysqlDataSource();
        mysqlDS.setDatabaseName("testDB");
        mysqlDS.setUser(userName);
        mysqlDS.setPassword(password);

        Connection conn = mysqlDS.getConnection();

		createTable(conn);
		insertFiveRows(conn);
        updateUsingBatching(conn);

        conn.close();
    }
	private static void createTable(Connection conn) throws SQLException {

		Statement createStatement = conn.createStatement();
		createStatement.execute("DROP TABLE EMPLOYEE");
		String createTableSQL = """
							CREATE TABLE EMPLOYEE 
							( 
								ID               INT NOT NULL AUTO_INCREMENT, 
								F_Name           VARCHAR(100), 
								L_Name           VARCHAR(100),  
								Sex  	         ENUM('M','F'),  
								Age  	         INT,  
								Address          VARCHAR(500),  
								Phone_Number     VARCHAR(20),  
								Vacation_Balance INT DEFAULT 30,
								CONSTRAINT PK_Person PRIMARY KEY (ID)
							);
				""";
		createStatement.execute(createTableSQL);
		createStatement.close();
	}

    private static void insertFiveRows(Connection conn) throws SQLException {
        String[] firstNames = {"A","B","C","D","E"};
        String[] lastNames = {"a","b","c","d","e"};
        char[] sexEnums =   {'M','F','M','M','M'};
        int[] ages =   {10,20,30,40,50};
        String[] addresses = {"a","b","c","d","e"};
        int[] phoneNumbers =   {10,20,30,40,50};

        String employeeInsertSQL = "insert into EMPLOYEE (F_NAME, L_NAME, SEX, AGE, ADDRESS, PHONE_NUMBER)" +
                "values (?, ?, ?, ?, ?, ?);";
        PreparedStatement insertStatement = conn.prepareStatement(employeeInsertSQL);
        for (int i = 0; i < 5; i++) {
            insertStatement.setString(1, firstNames[i]);
            insertStatement.setString(2, lastNames[i]);
            insertStatement.setString(3, String.valueOf(sexEnums[i]));
            insertStatement.setInt(4, ages[i]);
            insertStatement.setString(5, addresses[i]);
            insertStatement.setInt(6, phoneNumbers[i]);
            insertStatement.executeUpdate();
        }
		insertStatement.close();
    }

	private static void updateUsingBatching(Connection conn) throws SQLException {
		PreparedStatement tableStatement = conn.prepareStatement("SELECT ID, F_NAME, SEX, AGE FROM EMPLOYEE");
		ResultSet table = tableStatement.executeQuery();
		PreparedStatement updateStatement =  conn.prepareStatement("UPDATE EMPLOYEE SET VACATION_BALANCE = ?, F_NAME= ? WHERE ID = ?");
		conn.setAutoCommit(false);
		while (table.next())
		{
			if (table.getInt("Age") > 45)
				updateStatement.setInt(1, 45);
			else
				updateStatement.setInt(1, table.getInt("Age"));

			String title = table.getString("SEX").equals("M") ? "MR" : "MRS";
			if (!table.getString("F_Name").startsWith("MR"))
				updateStatement.setString(2, title + " " +table.getString("F_NAME"));

			updateStatement.setInt(3, table.getInt("ID"));

			updateStatement.addBatch();
		}
		int[] count = updateStatement.executeBatch();

		conn.commit();
		conn.setAutoCommit(true);
		updateStatement.close();
	}

}
