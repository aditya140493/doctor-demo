<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
                <td><input type="text" name="name" id="name"></td>
            </tr>
             <tr>
                <td>Patient's Age:</td>
                <td><input type="text" name="age" id="age"></td>
            </tr>
                          
            <tr>
                <td>Date of Birth</td>
                <td><input type="date" id="dob" name="dob">
                </td>
            </tr>
             <tr>
                <td>Patient's BloodGroup:</td>
                <td><input type="text" name="bloodgroup" id="bloodgroup"></td>
            </tr>
             <tr>
                <td>Patient's Address:</td>
                <td><input type="text" name="address" id="address"></td>
            </tr>
             <tr>
                <td>Patient's Email:</td>
                <td><input type="text" name="email" id="email"></td>
            </tr>
                        
            <tr>
                <td>Mobile No.:</td>
                <td><input type="text" name="phone" id="phone">
                </td>
            </tr>
                  <td>                                         
            <tr>
                <td>Date of Appointment:</td>
                <td><input type="date" id="doa" name="doa" id="doa">
                </td>
                
   </table>    
   <button type="button" value="go" onclick="checkDate()">GO</button>
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