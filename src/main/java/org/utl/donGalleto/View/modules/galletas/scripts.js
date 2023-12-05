import { galletasApiUrl } from "../../modules/apiUrls.js"

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
                    >./</button>
                <button
                    type="button"
                    class="btn btn-danger ml-2"
                    >X</button>
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
