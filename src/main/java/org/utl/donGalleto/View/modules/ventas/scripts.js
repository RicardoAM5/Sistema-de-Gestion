import { galletasApiUrl,ventasApiUrl } from "../../modules/apiUrls.js"

function mostrarDetalles(nombre, precioUnitario, precioKilo, imagenBase64, descripcion) {
    // Puedes realizar acciones con los datos de la galleta, por ejemplo, mostrar en una ventana modal
    console.log(`Detalles de la galleta:
        Nombre: ${nombre}
        Precio Unitario: ${precioUnitario}
        Precio por Kilo: ${precioKilo}
        Descripción: ${descripcion}`);
}

const listaGalletas_ventas = async ()=>{
    try {
        
        const response = await fetch(galletasApiUrl)
        const data = await response.json()


        let content=''
        data.forEach((data,index)=>{

            content+=`
            <div class="col-lg-6 col-md-12 col-sm-6 caja">
            <div class="card text-center my-3" onclick="mostrarDetalles('${data.nombre}', ${data.precioUnitario}, ${data.precioKilo}, '${data.imagenBase64}', '${data.descripcion}')" data-bs-toggle="modal" data-bs-target="#addProduct">
              <img
                src="data:image/png;base64,${data.imagenBase64}"
                class="card-img-top mx-auto d-block"
                style="width: 50%"
                alt="Imagen de la galleta"
              />
              <div class="card-body">
                <p class="card-text">${data.nombre}</p>
              </div>
            </div>
          </div>
            `;
        });
        lista_galletas_ventas.innerHTML=content

    } catch (error) {
        console.log(error)
    }
}


async function initialize(){
    const galletas = await listaGalletas_ventas()
    console.log(galletas)
}

initialize()

