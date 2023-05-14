package sample;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class HistogramGrade {
    public HistogramGrade() {
    }

    // Count repeated number of each letter grade

    public Map<String, Integer> getData() {

        Map<String, Integer> data = new HashMap<>();
        try {
            // create our mysql database connection
            Connection conn = null;

            // Loads the class object for the mysql driver into the DriverManager.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Attempts to establish a connection to the specified database via the
            // DriverManage
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student?"
                    + "user=root&password=root");

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM Classes";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java result set
            ResultSet rs = st.executeQuery(query);
            //System.out.println("grade");
            // iterate through the java result set
            while (rs.next()) {
                String grade = rs.getString("Grade");
                //System.out.println(grade);
                incrementFrequency(data, grade);
            }
            st.close();
            return data;
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return data;
    }

    //increments of each letter frequency
    private void incrementFrequency(Map<String, Integer> map, String key) {

        //get the value of the specified key
        Integer count = map.get(key);

        //if the map contains no mapping for the key, then map the key with value of 0
        if (count == null) {
            map.put(key, 0);
        }

        //else increment the found value by one
        else {
            map.put(key, count + 1);
        }
    }
}
