<%--
   Copyright 2015 Giorgio Consorti <g.consorti@lynxlab.com>
 
   This file is part of mongo-spring-mvc-skeleton.
 
   mongo-spring-mvc-skeleton is free software: you can redistribute it and/or
   modify it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.
 
   mongo-spring-mvc-skeleton is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
 
   You should have received a copy of the GNU General Public License along with
   mongo-spring-mvc-skeleton. If not, see <http://www.gnu.org/licenses/>.
   
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Employee Records</title>
</head>

<body>
	<h1 id='banner'>Employee List</h1>
	<hr/>
	${userList}
</body>
</html>