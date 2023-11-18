// script.js

function loadQuestions() {
    $.get("http://localhost:8000/purposeform", function (data) {
        var tableHtml = '<form name="form1" id="gradingForm" action="/submitForm" method="post">';
        tableHtml += '<table id="questionTable">';
        tableHtml += '<tr><th>Questions</th><th>Non-Existent</th><th>Minimal</th><th>Some Elements</th><th>Largely in Place</th><th>Fully in Place</th></tr>';
        data.forEach(function (question, index) {
            tableHtml += '<tr>';
            tableHtml += '<td name="questions">' + question + '</td>';
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

        // Add submit event to the form
        $("#gradingForm").submit(function (event) {
            event.preventDefault();
            var formData = $(this).serialize();
            $.post("http://localhost:8000/submitForm", formData, function (response) {
                // Handle the server response, e.g., render charts and recommendations
                renderDashboard(response);
            });
        });
    });
}


function renderDashboard(response) {
    // Replace the form with charts and recommendations
    $("#questionTable").html('<div id="charts"><canvas id="scoreChart"></canvas><canvas id="varianceChart"></canvas><canvas id="mixChart"></canvas></div><div id="recommendations"></div>');

    // Use the response data to render charts and recommendations
    var questionCount = 10; // Replace with the actual number of questions
    renderCharts(questionCount);
    renderRecommendations(response);
}


function renderCharts(questionCount) {
    // Example: Create a bar chart for average score
    var ctxScore = document.getElementById('scoreChart').getContext('2d');
    var scoreChart = new Chart(ctxScore, {
        type: 'bar',
        data: {
            labels: Array.from({ length: questionCount }, (_, i) => 'Question ' + (i + 1)),
            datasets: [{
                label: 'Average Score',
                data: Array(questionCount).fill(3), // Example: Average score for each question
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                    max: 4
                }
            },
//            responsive: true,
//            maintainAspectRatio: false, // Set to false to allow chart resizing
        }
    });

    // Example: Create a line chart for percentage variance
    var ctxVariance = document.getElementById('varianceChart').getContext('2d');
    var varianceChart = new Chart(ctxVariance, {
        type: 'line',
        data: {
            labels: Array.from({ length: questionCount }, (_, i) => 'Question ' + (i + 1)),
            datasets: [{
                label: 'Percentage Variance',
                data: Array(questionCount).fill(20), // Example: Percentage variance for each question
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 2,
                fill: false
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                    max: 100
                }
            },
//            responsive: true,
//            maintainAspectRatio: false, // Set to false to allow chart resizing
        }
    });

    // Example: Create a pie chart for mix of opinions
    var ctxMix = document.getElementById('mixChart').getContext('2d');
    var mixChart = new Chart(ctxMix, {
        type: 'pie',
        data: {
            labels: ['Agree', 'Neutral', 'Disagree'],
            datasets: [{
                data: [60, 20, 20], // Example: Mix of opinions data
                backgroundColor: ['rgba(75, 192, 192, 0.7)', 'rgba(255, 206, 86, 0.7)', 'rgba(255, 99, 132, 0.7)'],
            }],
//            responsive: true,
//            maintainAspectRatio: false, // Set to false to allow chart resizing
        }
    });
}

function renderRecommendations(response) {
    // Use the response data to dynamically generate recommendation text
    var recommendations = '<h2>Recommendations</h2><p>Your governance analysis shows...</p>';
    $("#recommendations").html(recommendations);
}


//function submitForm() {
//    $.post("http://localhost:8000/submitForm", $("#gradingForm").serialize(), function (response) {
//        console.log(response); // Log the server response
//    });
//}
