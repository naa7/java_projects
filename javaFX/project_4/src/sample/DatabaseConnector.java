package sample;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnector {
    //establishes the connection to the database and prints an
    // appropriate confirmation message.

    public static void main(String[] args) {
        try {
            Connection conn = null;
            // Loads the class object for the mysql driver into the DriverManager.

            Class.forName("com.mysql.cj.jdbc.Driver");

            // Attempts to establish a connection to the specified database via the
            // DriverManager
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?"
                    + "user=root&password=root");    //enter your mysql password there

            Statement stmt = null;
            stmt = conn.createStatement();

            String sql = "CREATE TABLE Students "
                    + "(emplID INTEGER not NULL, "
                    + " firstName VARCHAR(255), "
                    + " lastName VARCHAR(255), "
                    + " email VARCHAR(255), "
                    + " sex VARCHAR(1), "
                    + " PRIMARY KEY ( emplID ))";

            //stmt.executeUpdate(sql);

            sql = "CREATE TABLE Courses "
                    + "(courseID INTEGER not NULL, "
                    + " courseTitle VARCHAR(255), "
                    + " department VARCHAR(255), "
                    + " PRIMARY KEY ( courseID ))";

            //stmt.executeUpdate(sql);

            sql = "CREATE TABLE Classes "
                    + "(courseID INTEGER not NULL, "
                    + " studentID INTEGER not NULL, "
                    + " sectionNo INTEGER not NULL, "
                    + " year INTEGER, "
                    + " semester VARCHAR(255), "
                    + " grade VARCHAR(1) "
                    + " )";

            //stmt.executeUpdate(sql);

            //sql = "INSERT INTO Students values()"
            String insertStudent = " insert into Students (emplID, firstName, lastName, email, sex) values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(insertStudent);
            preparedStmt.setInt(1, 1);
            preparedStmt.setString(2, "Hesham");
            preparedStmt.setString(3, "Auda");
            preparedStmt.setString(4, "Hesham@mail.com");
            double run = (int)(Math.random()*3);
            if (run==0)
                preparedStmt.setString(5, "M");
            else if (run==1)
                preparedStmt.setString(5, "F");
            else if (run==2)
                preparedStmt.setString(5, "U");
            //preparedStmt.execute();

            String insertCourse = " insert into Courses (courseID, courseTitle, department) values (?, ?, ?)";
            preparedStmt = conn.prepareStatement(insertCourse);
            preparedStmt.setInt(1, 22000);
            preparedStmt.setString(2, "Algorithms");
            preparedStmt.setString(3, "Computer Science");
            //preparedStmt.execute();

            String insertClass = " insert into Classes (courseID, studentID, sectionNo, year, semester, grade) values (?, ?, ?, ?, ?, ?)";
            preparedStmt = conn.prepareStatement(insertClass);
            for (int i = 1;i<=25;i++){
            preparedStmt.setInt(1, 22000);
            preparedStmt.setInt(2, i);
            preparedStmt.setInt(3, 1001);
            preparedStmt.setInt(4, 2020);
            preparedStmt.setString(5, "Fall");
            preparedStmt.setString(6, "A");
            run = (int)(Math.random()*6);
                if (run==0)
                    preparedStmt.setString(6, "A");
                else if (run==1)
                    preparedStmt.setString(6, "B");
                else if (run==2)
                    preparedStmt.setString(6, "C");
                else if (run==3)
                    preparedStmt.setString(6, "D");
                else if (run==4)
                    preparedStmt.setString(6, "F");
                else if (run==5)
                    preparedStmt.setString(6, "W");
            //preparedStmt.execute();

            }

            if (conn != null) {
                stmt = conn.createStatement();
                System.out.println("We have connected to our database!");
                // Create the table and show the table structure
                //boolean result = stmt.execute("CREATE TABLE Students " +
                //        " (emplID INT UNSIGNED NOT NULL AUTO_INCREMENT, " + " PRIMARY KEY (emplID), firstName varchar(255), " +
                  //      " lastName varchar(255), email varchar(255), sex varchar(1))");
                //System.out.println("\tTable creation result: " + result);
                DatabaseConnector.showColumns(conn);
                // Insert the data into the database and show the values in the table
                Statement stmt2 = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
                //int rowCount = stmt2.executeUpdate("INSERT INTO Students " + "(emplID, firstName, lastName, email, sex) VALUES (26, \"Kevin\", \"Lee\", \"Kevin@gmail.com\", \"M\")");
                int rowCount = stmt2.executeUpdate("UPDATE Classes set grade = 'A' where studentID=2");
                DatabaseConnector.showValues(conn);
                //  Close the database
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }

    }
    public static void showValues(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT courseTitle,semester,year,grade,count(*) AS 'gradeFrequency' from Classes, Courses group by grade");
            DatabaseConnector.showResults("Class grades", rset);
            rset = stmt.executeQuery("SELECT * FROM Students");
            DatabaseConnector.showResults("Students", rset);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    /**
     * Displays the structure of the Student table.
     */
    public static void showColumns(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("SHOW COLUMNS FROM Students");
            DatabaseConnector.showResults("Students", rset);
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    /**
     * Displays the contents of the specified ResultSet.
     */
    public static void showResults(String tableName, ResultSet rSet) {
        try {
            ResultSetMetaData rsmd = rSet.getMetaData();
            int numColumns = rsmd.getColumnCount();
            String resultString = null;
            if (numColumns > 0) {
                resultString = "\nTable: " + tableName + "\n" +
                        "==============================================================\n";
                for (int colNum = 1; colNum <= numColumns; colNum++) resultString += rsmd.getColumnLabel(colNum) + "     ";
            }
            System.out.println(resultString);
            System.out.println(
                    "==============================================================");
            while (rSet.next()) {
                resultString = "";
                for (int colNum = 1; colNum <= numColumns; colNum++) {
                    String column = rSet.getString(colNum);
                    if (column != null)
                        resultString += column + "       ";
                }
                System.out.println(resultString + '\n' +
                        "--------------------------------------------------------------");
            }
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
