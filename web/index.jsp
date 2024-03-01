
<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Student" import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>student</title>
        <style>
            .errorColor{
                color: red;
            }
        </style>
    </head>
    <body>
        <%
          ArrayList<Student>studentList=(ArrayList<Student>)session.getAttribute("studentList");
          String error=request.getAttribute("error")+"";
          if(error.equalsIgnoreCase("null"))error="";
          String numberStudent=(String)request.getParameter("numberStudent");
          if(numberStudent==null)numberStudent="";
          
        %>
        <form action="createstudent">
            <label for="numberStudent">Number of student</label>
            <input type="number" name="numberStudent" id="numberStudent" value=<%=numberStudent%>><span class="errorColor"><%=error%></span>
            <input type="submit" value="generate"/>
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>STT</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>DOB</th>
                </tr>
            </thead>
            <tbody>
                <%if(studentList!=null){
                    for(int i = 0; i < studentList.size(); i++){
                        int index=i;
                %>
            <form action="updatestudent" method="post">
                <tr>                  
                    <td style="width:30px"><input type="text" name="index" value=<%=i+1%> readonly style="width: 29px"></td>
                    <td><%=studentList.get(i).getName()%></td>
                    <td><%=studentList.get(i).isGender()%></td>
                    <td><%=studentList.get(i).getDob()%></td>
                    <td><input type="submit" value="update"></td>
                </tr>
            </form>
            <%}}%>
        </tbody>
    </table>


</body>
</html>
