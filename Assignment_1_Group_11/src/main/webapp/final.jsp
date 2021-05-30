<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report</title>
<link rel="stylesheet" href="final.css" />
</head>
<body>
	<% 
		String fullName = (String)session.getAttribute("fullName");
		String maxMarks = (String)session.getAttribute("maxMarks");
		String maxSubject = (String)session.getAttribute("maxSubject");
		String minMarks = (String)session.getAttribute("minMarks");
		String minSubject = (String)session.getAttribute("minSubject");
		String average = (String)session.getAttribute("average");
		String []subjects = (String[])session.getAttribute("subjects");
	%>
	<div class="container">
		<header><img class="logo" src="https://www.lambtoncollege.ca/images/header/Logo-Brand.png" /><h2>Group 11 Assignment 1</h2></header>
		<section class="names">
			<h3 class="center">We are</h3>
			<p>Dalveer Singh</p> <p>Parneet Kaur</p> <p>Ravneet Kaur</p> <p>Amandeep Kaur</p>
			<div class="clearfix"></div>
		</section>
		
		<section class="names"><h3>Subjects</h3><br>
			<% 
				out.print(subjects[0]);
				for(int i=1;i<subjects.length;i++){
					out.print(" , "+subjects[i]);
				} 
			%></section>
		<br><br>
		<section class="report">
			<h3 class="center"><% out.print(fullName); %>'s Report</h3>
			<p><% out.print(maxSubject); %> (Max.)</p>
			<p>Average for all Subjects</p>
			<p><% out.print(minSubject); %> (Min.)</p>
			<p><% out.print(maxMarks); %>%</p>
			<p><% out.print(average); %>%</p>
			<p><% out.print(minMarks); %>%</p>
			<div class="clearfix"></div>
		</section>
		
	</div>
</body>
</html>