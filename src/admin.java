
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class admin extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
//        String duration = request.getParameter("duration");
//        String director = request.getParameter("director");
         
        System.out.println("Username admin: " + Username);
        System.out.println("Password admin: " + Password);
        PrintWriter writer = response.getWriter();
         
        if(Username.equals("admin") && Password.equals("admin")){
            response.sendRedirect("options.jsp");
        }
        else{
               String htmlResponse = "<html>";
               htmlResponse += "<h2>Invalid Credentials</h2>";        
               htmlResponse += "</html>";
               writer.println(htmlResponse);
        }
         
        // return response
        
         
    }
}