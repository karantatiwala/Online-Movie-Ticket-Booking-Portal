import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class book extends HttpServlet {
	static int cost=0;
	protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String showId = request.getParameter("id");
        String num = request.getParameter("num");
        String clss = request.getParameter("class");
         
        System.out.println(clss);
//        System.out.println("movie: " + movieId);
//        System.out.println("genere: " + screen+" "+slot);
 
        // do some processing here...
        try
        {
          // create a mysql database connection
          String myDriver = "com.mysql.jdbc.Driver";
          String myUrl = "jdbc:mysql://localhost:3306/UserDB";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl, "gaurav", "abhi1475");
          // the mysql insert statement
          Statement stmt = null;
          stmt = conn.createStatement();
          String query = " select screen, slot, booked from shows where id="+showId;
          System.out.println(showId);
          ResultSet rs = null, rs2=null;
          int screen=0, slot=0, booked=0;
          rs = stmt.executeQuery(query);
          PrintWriter writer = response.getWriter();
          String htmlRespone = "<html>";    
        
          
          if(rs==null){
        	  htmlRespone += "<h2>Wrong Entry</h2><br/>"; 
          }
          while(rs.next()){
        	  screen = rs.getInt("screen");
        	  slot = rs.getInt("slot");
        	  booked = rs.getInt("booked");
          }
          
         String htmlResponse2;
        // return response
          
          if(clss.equals("silver")){
        	  cost=100;
          }
          else if(clss.equals("gold")){
        	  cost=150;
          }
          else if(clss.equals("platinum")){
        	  cost=200;
          }
          
          
          int number =Integer.parseInt(num);
          cost*=number;
          System.out.println(cost);
          switch(screen){
          	case 1: if(slot==1)
          			{
          			showS1T1 m = new showS1T1();
          			m.booked=booked;
          			if(!m.bookNew(number)){
          				htmlRespone += "<h2>Show Full</h2><br/>"; 
          			}
          			else{
          				htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +clss+" tickets</p></div></center>"; 
  	          			query = " update shows set booked="+m.booked+" where id="+showId;
  	          		System.out.println(query);
  	          		PreparedStatement preparedStmt = conn.prepareStatement(query);
  	          	preparedStmt.execute();
          			}
          			}
          			else if(slot==2){
          				showS1T2 m=new showS1T2();
          				m.booked=booked;
          				if(!m.bookNew(number)){
              				htmlRespone += "<h2>Show Full</h2><br/>"; 
              			}
              			else{
              				htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +clss+" tickets</p></div></center>"; 
      	          		query = " update shows set booked="+m.booked+" where id="+showId;
      	          	System.out.println(query);
      	          		PreparedStatement preparedStmt = conn.prepareStatement(query);
      	  	          	preparedStmt.execute();
              			}
          			}
          			else{
          				showS1T3 m=new showS1T3();
          				m.booked=booked;
          				if(!m.bookNew(number)){
              				htmlRespone += "<h2>Show Full</h2><br/>"; 
              			}
              			else{
              				htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +clss+" tickets</p></div></center>"; 
      	          		query = " update shows set booked="+m.booked+" where id="+showId;
      	          	System.out.println(query);
      	          	PreparedStatement preparedStmt = conn.prepareStatement(query);
      	          	preparedStmt.execute();
              			}
          			}
          			break;
          			
          	case 2: if(slot==1){
          		showS2T1 m=new showS2T1();
          		m.booked=booked;
          		if(!m.bookNew(number)){
      				htmlRespone += "<h2>Show Full</h2><br/>"; 
      			}
      			else{
      				htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +clss+" tickets</p></div></center>"; 
	          			query = " update shows set booked="+m.booked+" where id="+showId;
	          			System.out.println(query);
	          			PreparedStatement preparedStmt = conn.prepareStatement(query);
	      	          	preparedStmt.execute();
      			}
          		}
  					else if(slot==2){
  						showS2T2 m=new showS2T2();
  						m.booked=booked;
  						if(!m.bookNew(number)){
  	          				htmlRespone += "<h2>Show Full</h2><br/>"; 
  	          			}
  	          			else{
              				htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +clss+" tickets</p></div></center>"; 
  	  	          		query = " update shows set booked="+m.booked+" where id="+showId;
  	  	          	System.out.println(query);
  	  	          	PreparedStatement preparedStmt = conn.prepareStatement(query);
  	  	          	preparedStmt.execute();
  	          			}
  					}
  					else{
  						showS2T3 m=new showS2T3();
  						m.booked=booked;
  						if(!m.bookNew(number)){
  	          				htmlRespone += "<h2>Show Full</h2><br/>"; 
  	          			}
  	          			else{
              				htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +clss+" tickets</p></div></center>"; 
  	  	          		query = " update shows set booked="+m.booked+" where id="+showId;
  	  	          	System.out.println(query);
  	  	          	PreparedStatement preparedStmt = conn.prepareStatement(query);
  	  	          	preparedStmt.execute();
  	          			}
  					}
  					break;
  					
          	case 3: if(slot==1){
          		showS3T1 m=new showS3T1();
          		m.booked=booked;
          		if(!m.bookNew(number)){
      				htmlRespone += "<h2>Show Full</h2><br/>"; 
      			}
      			else{
      				htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +clss+" tickets</p></div></center>"; 
	          			query = " update shows set booked="+m.booked+" where id="+showId;
	          			System.out.println(query);
	          			PreparedStatement preparedStmt = conn.prepareStatement(query);
	      	          	preparedStmt.execute();
      			}
          	}
  					else if(slot==2){
  						showS3T2 m=new showS3T2();
  						m.booked=booked;
  						if(!m.bookNew(number)){
  	          				htmlRespone += "<h2>Show Full</h2><br/>"; 
  	          			}
  	          			else{
              				htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +clss+" tickets</p></div></center>"; 
  	  	          		query = " update shows set booked="+m.booked+" where id="+showId;
  	  	          	System.out.println(query);
  	  	          	PreparedStatement preparedStmt = conn.prepareStatement(query);
  	  	          	preparedStmt.execute();
  	          			}
  					}
  					else{
  						showS3T3 m=new showS3T3();
  						m.booked=booked;
  						if(!m.bookNew(number)){
  	          				htmlRespone += "<h2>Show Full</h2><br/>"; 
  	          			}
  	          			else{
              				htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs." + cost + "</h3><br><hr><p>order: "+ number+" x " +clss+" tickets</p></div></center>"; 
  	          		query = " update shows set booked="+m.booked+" where id="+showId;
  	          		System.out.println(query);
  	          	PreparedStatement preparedStmt = conn.prepareStatement(query);
  	          	preparedStmt.execute();
  	          			}
  					}
  					break;
  					
  			default: htmlRespone += "<h2>Wrong Entry</h2><br/>"; 
          }
          
          conn.close();
          htmlRespone += "</html>";
          writer.println(htmlRespone);
          htmlRespone="<br><center><a href='food.jsp' style='font-size:30px;'>Order Meal</a><br><br><a href='user.jsp'><button>Back</button></a></center>";
          writer.println(htmlRespone);
          //response.sendRedirect("options.jsp");
        }
        catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }       
    }
}