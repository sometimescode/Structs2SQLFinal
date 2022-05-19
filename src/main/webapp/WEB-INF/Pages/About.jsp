<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
  <head>
    <title>About</title>
    <style>
      .column {
        float: left;
        width: 50%;
      }

      /* Clear floats after the columns */
      .row:after {
        content: "";
        display: table;
        clear: both;
      }

      #aboutMeImg {
        width: 100%;
        height: auto;
      }
    </style>
  </head>
  <body>
    <s:include value="Menu.jsp" />

    <main>
      <header class="center">
        <h2>Get to know John Doe</h2>
      </header>
      <div class="row">
        <div class="column">
          <img id="aboutMeImg" src="https://cdn.pixabay.com/photo/2018/08/28/13/29/avatar-3637561_960_720.png" alt="" />
        </div>
        <div class="column">
          <p class="textPadding"><s:property value="sentence"/></p>
        </div>
      </div>
    </main>
  </body>
</html>