<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
  <head>
    <title>Register</title>
  </head>
  <body>
    <s:include value="Menu.jsp" />

    <main>
      <div style="margin: auto; width: 50%;">
      <h2>Account Registration</h2>

      <s:form action="AddUserToDB" namespace="/Pages">
        <s:textfield name="accountBean.username" label="Username" />
        <s:textfield name="accountBean.password" label="Password" />
        <s:textfield name="accountBean.firstName" label="First Name" />
        <s:textfield name="accountBean.lastName" label="Last Name" />
        <s:textfield name="accountBean.email" label="Email Address" />
        <s:submit key="submit"/>
      </s:form>	
      </div>
    </main>
  </body>
</html>