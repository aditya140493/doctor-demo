<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<head>
 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="save_patientinsert" method="post" id="Pt_data" name="pt_data"> 
<fieldset>
    <legend>Patient Information:</legend><br><br>
    <table>
			 <tr>
                <td>Patient's Name:</td>
                <td><input type="text" name="name" id="name" value="${details.name}" readonly></td>
            </tr>
             <tr>
                <td>Patient's Age:</td>
                <td><input type="text" name="age" id="age" value="${details.age}" readonly></td>
            </tr>
                          
            <tr>
                <td>Date of Birth</td>
                <td><input type="text" id="dob" name="dob" value="${details.dob}" readonly>
                </td>
            </tr>
             <tr>
                <td>Patient's BloodGroup:</td>
                <td><input type="text" name="bloodgroup" id="bloodgroup" value="${details.bloodgroup}" readonly></td>
            </tr>
             <tr>
                <td>Patient's Address:</td>
                <td><input type="text" name="address" id="address" value="${details.address}" readonly></td>
            </tr>
             <tr>
                <td>Patient's Email:</td>
                <td><input type="text" name="email" id="email" value="${details.email}" readonly></td>
            </tr>
                        
            <tr>
                <td>Mobile No.:</td>
                <td><input type="text" name="phone" id="phone" value="${details.phone}" readonly>
                </td>
            </tr>
                  <td>                                         
            <tr>
                <td>Date of Appointment:</td>
                <td><input type="text" id="doa" name="doa" value="${details.doa}" readonly>
                </td>
                
   </table>    
   <p>Your request saved successfully. please confirm your appointment.</p>
</fieldset>
</form>
</body>
<script>
function checkDate()
{
	var ap_date = document.getElementById("doa").value;
	var name = document.getElementById("name").value;
	var age = document.getElementById("age").value;
	var bloodgroup = document.getElementById("bloodgroup").value;
	var dob = document.getElementById("dob").value;
	var address = document.getElementById("address").value;
	var email = document.getElementById("email").value;
	var phone = document.getElementById("phone").value;
	var mydate = new Date(ap_date);
	var x = new Date('2021-01-05');
	var y = new Date('2021-01-10');
	if(name == "")
		{
		alert("Please fill your name");
		}
	else if(age == "")
		{
		alert("age can not be null");
		}
	else if(bloodgroup == "")
		{
		alert("Please fill bloodgroop");
		}
	else if(dob == "")
		{
		alert("please fill Date of Birth");
		}
	else if(address == "")
		{
		alert("Please fill address");
		}
	else if(phone == "")
		{
		alert("Please fill Phone number");
		}
	else if(ap_date == "")
		{
		alert("Please fill appointment Date");
		}
	else if(mydate < x || mydate > y)
		{
		alert("docter is not available");
		}
	else
		{
		document.getElementById("Pt_data").submit();
		}
}
</script>
</html>