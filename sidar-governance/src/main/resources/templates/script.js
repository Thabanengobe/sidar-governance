// script.js

function loadQuestions() {
    $.get("http://localhost:8000/purposeform", function (data) {
        var tableHtml = '<form name= "form1" id="gradingForm" action="/submitForm" method="post">';
        tableHtml += '<table id="questionTable">';
        tableHtml += '<tr><th>Questions</th><th>Non-Existent</th><th>Minimal</th><th>Some Elements</th><th>Largely in Place</th><th>Fully in Place</th></tr>';
        data.forEach(function (question, index) {
            tableHtml += '<tr>';
            tableHtml += '<td>' + question + '</td>';
            // Add radio inputs for each level
            for (var i = 0; i < 5; i++) {
                tableHtml += '<td><input type="radio" name="grade_' + index + '" value="' + i + '"></td>';
            }
            tableHtml += '</tr>';
        });
        tableHtml += '</table>';
        tableHtml += '<button type="submit">Submit</button>';
        tableHtml += '</form>';

        $("#questionTable").html(tableHtml);
    });
}

//function submitForm() {
//    $.post("http://localhost:8000/submitForm", $("#gradingForm").serialize(), function (response) {
//        console.log(response); // Log the server response
//    });
//}
