<jsp:useBean id="u" class="Bean.BeanDevelopment"/>  
<jsp:setProperty property="*" name="u"/>  
  
Record is:<br>  
<jsp:getProperty property="name" name="u"/><br>  
<jsp:getProperty property="password" name="u"/><br>