// script.js

function loadQuestions() {
    fetch("http://localhost:8000/purposeform")
    .then(response =>response.json())
    .then((data)=>{ 
        const choices = ['Non-Existent', 'Minimal', 'Some Elements', 'Largely in Place', 'Fully in Place' ]
        const roles = ['CEO', 'the chair', 'trustees']
        const form = document.createElement('form');
        form.action = "/submitPurpose";
        form.method = "POST";
        const div = document.getElementById("questionare");
        const role = document.createElement("select");
        role.name = "role";
        for(let i=0; i <= 3; i++){
            let option = createTableHeader("option", roles[i]);
            option.value = roles[i];
            role.appendChild(option);
        }
        const table = document.createElement('table');
        form.appendChild(role);
    
        var tableHtml = '<tr><th>Questions</th><th>Non-Existent</th><th>Minimal</th><th>Some Elements</th><th>Largely in Place</th><th>Fully in Place</th></tr>';
        table.appendChild(createTableHeader("thead",tableHtml));
        
        data.forEach(function (question, index) {
            const element = document.createElement('tr');
            element.appendChild(createTableHeader('td', question));
            for (let i = 0; i < 5; i++) {
                const td = document.createElement('td');
                const input = document.createElement('input');
                input.value = choices[i];
                input.type = "radio";
                input.required = true;
                input.name = index;
                td.appendChild(input);
                element.appendChild(td);
                
            }
            
            table.appendChild(element);
        });

        const input = document.createElement('input');
        input.type = "submit";
        form.append(input);
        // table.appendChild(body);
        form.appendChild(table)
        div.appendChild(form);
    })
}

function createTableHeader(elementType, innerhtml){
    const element = document.createElement(elementType);
    element.innerHTML = innerhtml;
    return element;
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
