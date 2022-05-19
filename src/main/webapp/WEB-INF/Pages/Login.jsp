<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
    <s:include value="Menu.jsp" />

    <main>
      <div style="margin: auto; width: 50%;">
      <h2>Member Login</h2>

      <s:form action="CheckUserCredentials" namespace="/Pages">
        <s:textfield key="accountBean.username" label="Username"/>
        <s:password key="accountBean.password" label="Password"/>
        <s:submit/>
      </s:form>
      <h4><s:property value="validationString"/></h4>
      </div>
    </main>
  </body>
</html>