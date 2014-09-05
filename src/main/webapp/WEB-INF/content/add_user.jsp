<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang='en'>
   <head>
      <meta name='viewport' content='width=device-width, initial-scale=1'>
      <link href='css/add_user.css' rel='stylesheet'>
   </head>
   <body>
      <s:form action='#' method='post' theme='simple'>
         <div id='form'>
            <h1 class='hedinh-tag'>Add User</h1>
            <table class='main-table'>
               <tr>
                  <td><b>Name</b></td>
                  <td colspan='3'>
                    <s:textfield cssClass='input_class' type='text' name='name' id='name'/>
                  </td>
               </tr>
               <tr>
                  <td><b>UserName</b></td>
                  <td colspan='3'>
                     <s:textfield cssClass='input_class' type='text' name='userName' id='userName'/>
                  </td>
               </tr>
               <tr>
                  <td><b>Email</b></td>
                  <td colspan='3'>
                     <s:textfield cssClass='input_class' type='text' name='email' id='email'/>
                  </td>
               </tr>
               <tr>
                  <td><b>NIC</b></td>
                  <td>
                     <s:textfield cssClass='input_class' type='text' name='nic' id='nic'/>
                  </td>
                  <td style="padding:5px;"><b>Phone</b></td>
                  <td>
                     <s:textfield cssClass='input_class' type='text' name='phone' id='phone'/>
                  </td>
               </tr>
               <tr>
                  <td><b>Designation</b></td>
                  <td>
                     <s:textfield cssClass='input_class' type='text' name='designation' id='designation'/>
                  </td>
                  <td style="padding:5px;"><b>Role</b></td>
                  <td>
                     <s:textfield cssClass='input_class' type='text' name='role' id='role'/>
                  </td>
               </tr>
               <tr>
                  <td><b>Shed</b></td>
                  <td>
                     <s:textfield cssClass='input_class' type='text' name='shed' id='shed'/>
                  </td>
                  <td style="padding:5px;"><b>Sub Dept.</b></td>
                  <td>
                     <s:textfield cssClass='input_class' type='text' name='sub_dept' id='sub_dept'/>
                  </td>
               </tr>
               <tr>
                  <td><b>Station</b></td>
                  <td>
                     <select class='input_class' name='station' id='station'></select>
                  </td>
               </tr>
            </table>
            <br/>
            <p><b>User Privileges</b></p>
            <table style="width:85%; margin-left:10px;">
               <tr>
                  <td><input type='checkbox' name='add_user' value='value'> Add user</td>
                  <td><input type='checkbox' name='remove_user' value='value'> Add/Remove user</td>
                  <td><input type='checkbox' name='add_train' value='value'> Add train</td>
                  <td><input type='checkbox' name='remove_train' value='value'> Add/Remove train</td>
               </tr>
               <tr>
                  <td><input type='checkbox' name='add_station' value='value'> Add station</td>
                  <td><input type='checkbox' name='remove_station' value='value'> Add/Remove station</td>
                  <td><input type='checkbox' name='add_category' value='value'>Add category</td>
                  <td><input type='checkbox' name='remove_category' value='value'>Add/Remove category</td>
               </tr>
               <tr>
                   <td><input type='checkbox' name='add_device' value='value'>Add device</td>
                  <td><input type='checkbox' name='remove_device' value='value'>Add/Remove device</td>
                  <td><input type='checkbox' name='' value='value'> Add customer</td>
                  <td><input type='checkbox' name='' value='value'>Add parcel</td>
               </tr>
               <tr>
                  <td><input type='checkbox' name='' value='value'>Release parcel</td>
                  <td><input type='checkbox' name='' value='value'> Confirm arrival</td>
                  <td><input type='checkbox' name='' value='value'> Check upcoming parcels &nbsp;&nbsp;</td>
                  <td><input type='checkbox' name=''value='value'> Select train</td>
               </tr>
            </table>
            <br/>
            <div class='wrapper'>
                     <input type='submit' name='create' value='Create User'>
                  </td>
            </div>
            <br>
            </tr>
         </div>
      </s:form>
   </body>
</html>
