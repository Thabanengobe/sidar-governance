// script.js

function loadQuestions() {
    $.get("http://localhost:8000/purposeform", function (data) {
        var tableHtml = '<tr><th>Questions</th><th>Non-Existent</th><th>Minimal</th><th>Some Elements</th><th>Largely in Place</th><th>Fully in Place</th></tr>';
        data.forEach(function (question, index) {
            tableHtml += '<tr>';
            tableHtml += '<td>' + question + '</td>';
            // Add radio inputs for each level
            for (var i = 0; i < 5; i++) {
                tableHtml += '<td><input type="radio" name="grade_' + index + '" value="' + i + '"></td>';
            }
            tableHtml += '</tr>';
        });
        $("#questionTable").html(tableHtml);
    });
}

function submitForm() {
    var grades = {};
    // Loop through radio inputs and extract values
    $("input[type='radio']:checked").each(function () {
        var questionIndex = $(this).attr('name').split('_')[1];
        var level = $(this).val();
        grades[questionIndex] = level;
    });
    console.log(grades); // Replace this with your logic to handle the grades
}
