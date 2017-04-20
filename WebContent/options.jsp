
<%@ page import="com.mysql.*" %>
<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html lang="en">
<head>
  <title>LNM Talkies</title>
  <meta charset="utf-8">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
  <link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
</head>

<nav class="navbar navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <a class="navbar-brand" href="user.jsp" style="font-size: 40px;"><b>LNM Talkies</b></a>
    </div>
  </div>
</nav>

<center>
	<div style="float: left; margin-left: 350px;">
		<div class="testbox1">
		  <h1>Add Movie</h1>
		  <form action="userinput" method="POST">
		  <input type="text" name="movieName" placeholder="Movie Name" required/>
		  <input type="text" name="genere" placeholder="Genere" required/>
		  <input type="text" name="duration" placeholder="Duration" required/>
		  <input type="text" name="director" placeholder="Direction" required/>
		  <br />
		  <br />
		   <input class="btn btn-primary" type="submit" value="ADD" >
		  </form>
		</div>
	</div>

	<div style="float: right; margin-right: 350px;">
		<div style="float: left; margin-right: 150px;">
			<div class="testbox2">
			  <h1>Schedule Movie</h1>
			  <form action="schedule" method="POST">
			  <input type="text" name="movieId" placeholder="Movie ID">
	          <input type="text" name="screen" placeholder="Screen No.">
	          <input type="text" name="slot" placeholder="Slot No.">
	          <br />
	          <br />
			   <input class="btn btn-primary" type="submit" value="SCHEDULE">
			  </form>
			</div>
		</div>

		<div style="float: right;">
			<div class="testbox3">
			  <h1>Delete Movie</h1>
			  <form action="delete" method="POST">
	        	<input type="text" name="movieName" placeholder="Movie Name">
	        	<br />
	        	<br />
			    <input class="btn btn-primary" type="submit" value="DELETE">
			  </form>
			</div>
		</div>
	</div>
</center>



<div>
    <div class="container">
    <br />
	        	<br />
	    <table class="table table-hover" style="margin-top: 350px;">
	        <thead>
	            <tr>
	            	<th><b>ID</b></th>
	                <th><b>Title</b></th>
	                <th><b>Genere</b></th>
	            </tr>
	        </thead>
	        <tbody>


	            <%
	                Class.forName("com.mysql.jdbc.Driver");
	                Connection conn = null;
	                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserDB", "gaurav", "abhi1475");
	                Statement stmt = null;
	                stmt = conn.createStatement();
	                String query = "select * from moviedatabase";
	                ResultSet rs = null;
	                rs = stmt.executeQuery(query);
	                while(rs.next()){
	            %>
	            <tr>
	                <%
	                	int id = rs.getInt("id");
	                    String title = rs.getString("title");
	                    String genere = rs.getString("genere");
	                
	                %>
	                <td><%=id %></td>
	                <td><%=title %></td>
	                <td><%=genere %></td>
	            </tr>               

	            <%      
	                }
	            %>

	        </tbody>
	    </table>
    </div>
</div>

<style>
      /* NOTE: The styles were added inline because Prefixfree needs access to your styles and they must be inlined if they are on local disk! */
body, div, dl, dt, dd, ul, ol, li, h1, h2, h3, h4, h5, h6, pre, form, fieldset, input, textarea, p, blockquote, th, td { 
  padding:0;
  margin:0;}

body,
input,
textarea,
select {
  font-family: 'Open Sans', sans-serif;
  font-size: 16px;
  color: #4c4c4c;
}

h1 {
  font-size: 32px;
  font-weight: 300;
  color: #4c4c4c;
  text-align: center;
  padding-top: 10px;
  margin-bottom: 10px;
}

.testbox1, .testbox2, .testbox3 {
  /*margin: 20px auto;*/
  width: 300px; 
  /*height: 330px;*/ 
  -webkit-border-radius: 8px/7px; 
  -moz-border-radius: 8px/7px; 
  border-radius: 8px/7px; 
  background-color: #ebebeb; 
  -webkit-box-shadow: 1px 2px 5px rgba(0,0,0,.31); 
  -moz-box-shadow: 1px 2px 5px rgba(0,0,0,.31); 
  box-shadow: 1px 2px 5px rgba(0,0,0,.31); 
  border: solid 1px #cbc9c9;
}

.testbox1{
	height: 330px; 
}
.testbox2{
	height: 290px; 
}
.testbox3{
	height: 185px; 
}
form{
  margin: 0 30px;
}

input[type=text],input[type=password]{
  width: 200px; 
  height: 39px; 
  -webkit-border-radius: 0px 4px 4px 0px/5px 5px 4px 4px; 
  -moz-border-radius: 0px 4px 4px 0px/0px 0px 4px 4px; 
  border-radius: 0px 4px 4px 0px/5px 5px 4px 4px; 
  background-color: #fff; 
  -webkit-box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  -moz-box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  box-shadow: 1px 2px 5px rgba(0,0,0,.09); 
  border: solid 1px #cbc9c9;
  margin-left: -5px;
  margin-top: 13px; 
  padding-left: 10px;
}

input[type=password]{
  margin-bottom: 25px;
}

</style>

</html>