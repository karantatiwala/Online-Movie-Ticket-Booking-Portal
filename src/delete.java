import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/delete")
public class delete extends HttpServlet {
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String movieName = request.getParameter("movieName");
         
        System.out.println("movie: " + movieName);
 
        // do some processing here...
        try
        {
          // create a mysql database connection
          String myDriver = "com.mysql.jdbc.Driver";
          String myUrl = "jdbc:mysql://localhost:3306/UserDB";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl, "gaurav", "abhi1475");
          // the mysql insert statement
          String query = " delete from moviedatabase where title = ?";

          // create the mysql insert preparedvstatement
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setString (1, movieName);
          // execute the preparedstatement
          preparedStmt.execute();
          
          conn.close();
          response.sendRedirect("options.jsp");
        }
        catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }
            
//            //stmt.executeUpdate("insert into moviedatabase " + "values('"+ movieName +"','"+ genere + "',"+ duration +",'"+ director + "')");
//
//            
//        // get response writer
//        PrintWriter writer = response.getWriter();
//         
//       
//        // build HTML code
//        String htmlRespone = "<html>";
//        htmlRespone += "<h2>Movie " + movieName + " Deleted<br/>";    
//        htmlRespone += "</html>";
//         
//        // return response
//        writer.println(htmlRespone);
         
    }
 
}