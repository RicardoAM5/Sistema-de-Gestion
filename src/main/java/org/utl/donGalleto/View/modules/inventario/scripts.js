import {
    galletasApiUrl,
    galletasUpdateApiUrl,
    galletasDeleteApiUrl,
    galletasInsertApiUrl,
  } from "./modules/apiUrls.js";
  

  const listaGalletas = async () => {
    try {
      const response = await fetch(galletasApiUrl);
      const data = await response.json();
  console.log(data)
      let content = "";
      data.forEach((data, index) => {
        content += `
              <tr>
              <td>${index + 1}</td>
              <td>${data.nombre}</td>
              <td>${data.cantidad}</td>
              <td>
                  <div class="d-flex">
                  <button
                      type="button"
                      class="btn btn-success"
                      
            data-bs-toggle="modal"
            data-bs-target="#addMaterial" 
                      onclick="editarInventario('${data.idGalleta}','${
          data.cantidad
        }','${data.precioKilo}')"
                      ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                      <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                      <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                    </svg>
                      </button>
                  
                  </div>
              </td>
          </tr>
          `;
      });
      tableBody_inventario.innerHTML = content;
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


async function editarInventario() {
    try {
        const response = await fetch("`http://localhost:8080/api/venta/updateInventario?nombre=${cantidad}&cantidad=${total}`", {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
        });
        if (!response.ok) {
            console.log(response.text());
            throw new Error("Error in HTTP: " + response.status);
        }
        const data = await response.json();

        if (data.error) {
            console.log(data.error)
        } else {
            console.log(data)
        }
    } catch (error) {
        console.error("Error in response:", error);
    }

}
