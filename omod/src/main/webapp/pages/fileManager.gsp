<%
	ui.decorateWith("appui", "standardEmrPage")
%>

<script type="text/javascript">
	var breadcrumbs = [
		{ icon: "icon-home", link: '/' + OPENMRS_CONTEXT_PATH + '/index.htm' },
		{ label: "${ ui.message("filemanager.label")}"}
	];
</script>

<h3>${ui.message("filemanager.upload.title")}</h3>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>filemanager.upload.title</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
<form method="POST" action="upload.page" enctype="multipart/form-data">
	${ui.message("filemanager.upload.file")}:
	<input type="file" name="file" id="file"/>
</br>
	<input type="submit" value="Upload" name="upload" id="upload"/>
</form>
<br/>
<table>
	<thead>
	<tr>
		<th>${ui.message("filemanager.upload.date")}</th>
		<th>${ui.message("filemanager.upload.type")}</th>
		<th>${ui.message("filemanager.upload.file")}</th>
	</tr>
	</thead>
	<tbody>
	<% if (files.size() == 0) { %>
	<tr>
		<td colspan="4">${ui.message("coreapps.none")}</td>
	</tr>
	<% } %>
	<% files.each { f ->
		def date = f.birthdate
		def type = f.gender
		def link = f.personVoidReason
	%>
	<tr id="visit-${f.personId}">
		<td>${ui.format(date)}</td>
		<td>${ui.format(type)}</td>
		<td>${ui.format(link)}</td>
	</tr>
	<% } %>
	</tbody>
</table>
</body>
</html>