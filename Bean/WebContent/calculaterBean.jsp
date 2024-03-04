<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bn" class="Bean.calculatorBean"/>
<%
int m = bn.cube(5);
out.print("cube of 5 is "+m);
%>
