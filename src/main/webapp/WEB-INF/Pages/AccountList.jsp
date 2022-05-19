<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
  <head>
    <title>Account List</title>
    <style>
      #verticalList {
        padding: 0px 50px;
        list-style-type: none;
      }

      #verticalList li {
        background-color: #eee;
        color: black;
        display: block;
        float: left;
        width: 100%;
        margin: 0px 0px 10px 0px;
        padding: 10px 0px;
      }

      #verticalList li span {
        padding: 10px;
      }
      
    </style>    
  </head>
  <body>
    <s:include value="Menu.jsp" />

    <main>
      <header class="center">
        <h2>All Basic User Details</h2>
      </header>
      <div>
        <ul id="verticalList">
          <s:if test='%{accounts.isEmpty() == true}'>
            <li class="center">No users found.</li>
          </s:if>
          <s:iterator  value="accounts">  
          <li><span>First Name: <s:property value="firstName"/></span></br>
            <span>Last Name: <s:property value="lastName"/></br>
            <span>Email Address: <s:property value="email"/>
          </li>
          </s:iterator>
        </ul>  
      </div>
    </main>
  </body>
</html>