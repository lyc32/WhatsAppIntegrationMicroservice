<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
  <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="header.jsp" %>

<div class="container mt-4 mb-4" style="min-height: 800px;">
  <div class="row justify-content-center">
    <div class="card" style="max-width: 600px; height: 250px;">
      <div class="row g-0 mb-2">
        <div class="card-body">
          <p class="card-text pt-2 pb-2">
            <h2>${returnMessage}</h2>
            <div id='message'></div>
          </p>
        </div>
      </div>
    </div>
  </div>
</div>

<script language="javascript">
  var num = 4;
  var URL = '${url}';
  window.setTimeout("doUpdate()", 1000);
  function doUpdate()
  {
    if(num != 0)
    {
      document.getElementById('message').innerHTML = '<h2>Jump after '+num+' seconds</h2>';
      num --;
      window.setTimeout("doUpdate()", 1000);
    }
    else
    {
      num = 4;
      window.location = URL;
    }
  }
</script>
<%@ include file="footer.jsp" %>
</body>
</html>

