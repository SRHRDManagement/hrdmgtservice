<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
  <head>
  	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="UTF-8">
    <title>API Access</title>  
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dist/css/stylels.css">
  </head>
  <body>
    <div id="boxForm">
  <h2 id="title">KSHRD Center, Data Access</h2>
<form action="login" id="frmLogin" method="POST">
    <input class='text' type='text' name='username' placeholder='username' required>
    <br>
    <input class='text' id='pwd'  type='password' placeholder='Password' required>
    <br>
    <input class='button' type='submit' value='Login'>
  </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
        
        $(function() {
        	
        	$("#frmLogin").submit(function(e){
       		
       		  e.preventDefault();
       			
       		  $.ajax({
  	            url: "${pageContext.request.contextPath}/login",
  	            type: "POST",
  	            data: $("#frmLogin").serialize(),
//   	            beforeSend: function (xhr) {
//   	                xhr.setRequestHeader("X-Ajax-call", "true");
//   	            },
  	            success: function(data) {
  	            	if(data == "User account is locked"){
  	            		alert(data);
  	            	}else if(data == "User is disabled"){
  	            		alert(data);
  	            	}else if(data == "Bad credentials"){
  	            		alert(data);
  	            	}else{
  	            		alert("Logined success.");
  	            		location.href = "${pageContext.request.contextPath}/"+data;
  	            	}
  	            	
  	            },
  	         	error: function(data){
  	         		console.log(data);
  				}
  	        });
       			
       		});
	      
        	
        	
        	$.ajax({ 
			    url: "http://localhost:9999/api/user?page=3&limit=5", 
			    type: 'GET', 
			    beforeSend: function(xhr) {
                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-Type", "application/json");
//                     xhr.setRequestHeader("Authorization" , "Basic ZGV2OiFAI2FwaQ==");
                },
			    success: function(data) { 
					console.log(data);
				  
					
			    },
			    error:function(data,status,er) { 
			        console.log("error: "+data+" status: "+status+" er:"+er);
			    }
			});
        	
        
        });
        </script>
  </body>
</html>
