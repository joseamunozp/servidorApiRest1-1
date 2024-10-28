
addEventListener("load", (event) => {
    
    const btnSubmit = document.querySelector('.submit');
    const tableAlumnos = document.querySelector('.lista-alumnos');

    const url = "http://localhost:8080/api/v1/alumno";

    // load alumnos
    loadAlumnos();

    btnSubmit.addEventListener('click', e => {
        e.preventDefault()

        var formData = new FormData(document.forms.createAlumno);
        var entries = formData.entries();
        var data = Object.fromEntries(entries);
      
        fetch(
          url + '/insert', 
          {
            'method': "POST",
            'body': JSON.stringify({
              nombre: data.Nombre,
              apellidos: data.Apellidos,
              infoContacto: {
                direccion: data.Direccion,
                telefono: data.Telefono
              }
            }),
            headers: {
                'Content-Type': 'application/json; charset=utf-8'
              }
          }
        )
          .then(response => {
            loadAlumnos();
          })
          .catch(err => console.error(err));
      });

      function loadAlumnos()
      {
        fetch(
            url
          )
            .then(response => response.json())
            .then(response => {
                empty(tableAlumnos);
                
                // Headers
                let rowHeaders = tableAlumnos.insertRow();

                createHeader(rowHeaders, "Nombre");
                createHeader(rowHeaders, "Apellidos");
                createHeader(rowHeaders, "Direccion");
                createHeader(rowHeaders, "Telefono");

                let thOpciones = document.createElement("th");
                rowHeaders.appendChild(thOpciones);

                // Rows
                for (let element of response) {
                    let row = tableAlumnos.insertRow();

                    createCell(row, element.nombre);
                    createCell(row, element.apellidos);
                    createCell(row, element.infoContacto.direccion);
                    createCell(row, element.infoContacto.telefono);
                    createDeleteButton(row, element.alumnoId);
                  }
                

            })
            .catch(err => console.error(err))
      }

      function createHeader(row, headerName)
      {
        let th = document.createElement("th");
        let text = document.createTextNode(headerName);
        th.appendChild(text);
        row.appendChild(th);
      }

      function createCell(row, textContent)
      {
        let cell = row.insertCell();
        let text = document.createTextNode(textContent);
        cell.appendChild(text);
      }

      function createDeleteButton(row, alumnoId)
      {
        let cell = row.insertCell();
        let btn = document.createElement("button");
        let text = document.createTextNode("Eliminar alumno");
        
        btn.appendChild(text);
        cell.appendChild(btn);

        btn.addEventListener('click', function(e)
        {
            fetch(
                url + '/delete/' + alumnoId.toString(), 
                {
                  'method': "DELETE"
                }
              )
                .then(response => {
                  loadAlumnos();
                })
                .catch(err => console.error(err));
        });
      }
      
      function empty(element) {
        while(element.firstElementChild) {
           element.firstElementChild.remove();
        }
      }
});