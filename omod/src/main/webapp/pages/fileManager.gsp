<%
ui.decorateWith("appui", "standardEmrPage")
%>

${ ui.includeFragment("coreapps", "patientHeader", [ patient: patient.patient ]) }

<div id="content" class="container">
    <h1>There will be files</h1>
    <fieldset>
        <legend>Upload file</legend>
        <form class="simple-form-ui" id="uploadFile" method="post"
        enctype="multipart/form-data">
            <input type="file" id="fileInput" multiple="true">
        </form>
    </fieldset>
</div>
