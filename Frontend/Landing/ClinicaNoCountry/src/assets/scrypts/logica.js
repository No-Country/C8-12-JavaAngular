
function guardarDatos() {
    var nombre = document.querySelector('#nombres').value,
        apellido = document.querySelector('#apellidos').value,
        documento = document.querySelector('#DNI').value,
        mail = document.querySelector('#Email').value,
        pass = document.querySelector('#password').value;

    agregarDatos(nombre, apellido, documento, mail,pass);
    /* imprimirTabla(); */
}

function imprimirTabla() {
    var lista = obtenerDatos(),
    tbody = document.querySelector('#tabla tbody');

    tbody.innerHTML = '';

    for (var i = 0; i < lista.length; i++) {
        var row = tbody.insertRow(i),
            nombreCelda = row.insertCell(0),
            apellidoCelda = row.insertCell(1);
            documentoCelda = row.insertCell(2);
            mailCelda = row.insertCell(3);

        nombreCelda.innerHTML = lista[i].nombre;
        apellidoCelda.innerHTML = lista[i].apellido;
        documentoCelda.innerHTML = lista[i].documento;
        mailCelda.innerHTML = lista[i].mail;

        tbody.appendChild(row);
    }
}

