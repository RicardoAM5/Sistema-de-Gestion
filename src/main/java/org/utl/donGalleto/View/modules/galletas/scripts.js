import {
  galletasApiUrl,
  galletasUpdateApiUrl,
  galletasDeleteApiUrl,
  galletasInsertApiUrl,
} from "./modules/apiUrls.js";

function mostrarDetalles(
  nombre,
  precioUnitario,
  precioKilo,
  imagenBase64,
  descripcion
) {
  // Puedes realizar acciones con los datos de la galleta, por ejemplo, mostrar en una ventana modal
  console.log(`Detalles de la galleta:
        Nombre: ${nombre}
        Precio Unitario: ${precioUnitario}
        Precio por Kilo: ${precioKilo}
        Descripción: ${descripcion}`);
}

const listaGalletas = async () => {
  try {
    const response = await fetch(galletasApiUrl);
    const data = await response.json();

    let content = "";
    data.forEach((data, index) => {
      content += `
            <tr>
            <td>${index + 1}</td>
            <td>
                <img
                src="data:image/png;base64,${data.imagenBase64}"
                class="card-img-top mx-auto d-block"
                style="max-width: 50%; max-height:30px"
                alt="Imagen de la galleta"
            />
            </td>
            <td>${data.nombre}</td>
            <td>${data.precioUnitario}</td>
            <td>${data.precioKilo}</td>
            <td>${data.descripcion}</td>
            <td>
                <div class="d-flex">
                <button
                    type="button"
                    class="btn btn-success"
                    
          data-bs-toggle="modal"
          data-bs-target="#addCookie" 
                    onclick="editarGalleta('${data.nombre}','${
        data.precioUnitario
      }','${data.precioKilo}','${data.descripcion}','${data.idGalleta}','${
        data.imagenBase64
      }')"
                    ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                    <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                    <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                  </svg>
                    </button>
                <button
                    type="button"
                    class="btn btn-danger mx-2"
                    onclick="eliminarGalleta('${galletasDeleteApiUrl}','${
        data.idGalleta
      }')"
                    >
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
  <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8z"/>
</svg>
</button>
                </div>
            </td>
        </tr>
        `;
    });
    tableBody_ventas.innerHTML = content;
  } catch (error) {
    console.log(error);
  }
};

async function initialize() {
  const galletas = await listaGalletas();
  console.log(galletas);
}

initialize();

(() => {
  "use strict";

  const forms = document.querySelectorAll(".valid-addcookie");

  Array.from(forms).forEach((form) => {
    form.addEventListener(
      "submit",
      (event) => {
        event.preventDefault();
        event.stopPropagation();
        if (form.checkValidity()) {
          agregarGalleta();
        }
        form.classList.add("was-validated");
      },
      false
    );
  });
})();
(() => {
  "use strict";

  const forms = document.querySelectorAll(".valid-editcookie");

  Array.from(forms).forEach((form) => {
    form.addEventListener(
      "submit",
      (event) => {
        event.preventDefault();
        event.stopPropagation();
        if (form.checkValidity()) {
          editarGalletaCommit();
        }
        form.classList.add("was-validated");
      },
      false
    );
  });
})();
