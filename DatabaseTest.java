package Dbtest;
import org.junit.Assert;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTest {
    @Test
    public void verify_first_last_name() {
        int id = 2;
        String fname = "priya";
        String lname = "rijal";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest", "root", "Root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from employee where id=" + id);
            rs.next();
            String actualFName = rs.getString("first_name");
            String actuallName = rs.getString("last_name");
            Assert.assertEquals(fname, actualFName);
            Assert.assertEquals(lname, actuallName);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

        @Test
         public void update_first_last_name() {
        int id = 2;
        String fname = "priya";
        String lname = "rijal";
        String ufname ="priy";
        String ulname ="rijal";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbtest", "root", "Root");
            Statement stmt = con.createStatement();
            String sql = "update employee set first_name=" + "\"" + ufname + "\"" + ",last_name=" + "\"" + ulname + "\"" + " where id=2;";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            //now verify the record
            ResultSet rs = stmt.executeQuery("select * from employee where id =" + id);
            rs.next();
            String actualFName = rs.getString("first_name"); //column first_name
            String actualLName = rs.getString("last_name"); //cloumn last_name
            Assert.assertEquals(ufname, actualFName);
            Assert.assertEquals(ulname, actualLName);
            //Assert.assertEquals(fname,actualFName); //fail
            //Assert.assertEquals(lname,actualLName); //fail
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        }
    }
