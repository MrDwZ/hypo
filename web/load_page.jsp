<%@ page import="java.io.File" %>
<%@ page import="java.nio.file.Files" %><%--
  Created by IntelliJ IDEA.
  User: eiyasushiki
  Date: 15/11/11
  Time: 下午1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = application.getRealPath("");
    path = path.concat("pages/README.md.html");
    System.out.println(path);
    File f = new File(path);
    byte[] bytes = Files.readAllBytes(f.toPath());
    String s  = new String(bytes,"UTF-8");
    response.getWriter().println(s);
%>
