// script.js
function loadQuestions() {
    fetch("http://localhost:8000/purposeform")
    .then(response =>response.json())

    .then((data)=>{ 

        const form =  createForm();
        const div = document.getElementById("questionare");
        const table = createTable();
        
        data.forEach(function (question, index) {
            const element = document.createElement('tr');

            element.appendChild(createElementData('td', question));
            for (let i = 0; i < 5; i++) {
                const td = document.createElement('td');
                td.appendChild(createInput(index, i));
                element.appendChild(td);  
            }
            table.appendChild(element);
        });

        const input = document.createElement('input');
        input.type = "submit";
//        form.appendChild(createRoles());
        form.append(input);
        form.appendChild(table)
        div.appendChild(form);

    })
}

function createForm(url){
    const form = document.createElement('form');
    form.action = "/submitPurpose";
    form.method = "POST";
    return form;
}

function createTable(){

    table = document.createElement('table');

    let tableHtml = '<tr><th>Questions</th><th>Non-Existent</th><th>Minimal</th><th>Some Elements</th><th>Largely in Place</th><th>Fully in Place</th></tr>';
    table.appendChild(createElementData("thead",tableHtml));
    return table;
}

function createRoles(){

    const roles = ['CEO', 'the chair', 'trustees']
    const role = document.createElement("select");
    role.name = "role";

    for(let i=0; i <= 3; i++){
        let option = createElementData("option", roles[i]);
        option.value = roles[i];
        role.appendChild(option);
    }
    return role;
}

function createInput(index, i){
    const choices = ['Non-Existent', 'Minimal', 'Some Elements', 'Largely in Place', 'Fully in Place' ];
    const input = document.createElement('input');
    input.value = choices[i];
    input.type = "radio";
    input.required = true;
    input.name = index;

    return input;
}


function createElementData(elementType, innerhtml){
    const element = document.createElement(elementType);
    element.innerHTML = innerhtml;
    return element;
}

