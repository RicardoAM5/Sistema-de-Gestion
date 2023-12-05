function editarGalleta(data, ruta) {}

function agregarGalleta() {
  const nombre = document.getElementById("nombre").value;
  const cantidad = document.getElementById("cantidad").value;
  const precioUnitario = document.getElementById("precio_unitario").value;
  const precioKilo = document.getElementById("precio_kilo").value;
  const descripcion = document.getElementById("descripcion").value;

  // Obtener el archivo de imagen y convertirlo a base64
  const imagenInput = document.getElementById("imagen");
  const imagenFile = imagenInput.files[0];

  if (!imagenFile) {
    console.error("Debes seleccionar una imagen");
    return;
  }

  const reader = new FileReader();
  reader.readAsDataURL(imagenFile);
  reader.onloadend = function () {
    const imagenBase64 = reader.result.split(",")[1]; // Obtener el contenido en base64

    // Construir el objeto JSON
    const params = {
      "nombre": nombre,
      "cantidad": cantidad,
      "precioUnitario": precioUnitario,
      "precioKilo": precioKilo,
      "descripcion": descripcion,
      "imagenBase64": imagenBase64,
    };
    // Hacer la solicitud Fetch
    fetch("http://localhost:8080/api/galleta/save", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(params),
    })
      .then((response) => response.json())
      .then((data) => {
        // Lógica para manejar la respuesta del servidor
        console.log("Respuesta del servidor:", data);
        //alert("se agregó la galleta");
        console.log(params)
        // // Cerrar el modal si es necesario
        // const modal = new bootstrap.Modal(document.getElementById("addCookie"));
        // modal.hide();
      })
      .catch((error) => {
        // Lógica para manejar errores
        console.error("Error en la solicitud:", error);
      });
  };
}

function editarGalletaCommit() {}

const eliminarGalleta = async (ruta, id) => {
  const swalWithBootstrapButtons = Swal.mixin({
    customClass: {
      confirmButton: "btn btn-success",
      cancelButton: "btn btn-danger",
    },
    buttonsStyling: false,
  });
  swalWithBootstrapButtons
    .fire({
      title: "Confirmar",
      text: "Esta acción no se puede revertir",
      icon: "warning",
      showCancelButton: true,
      confirmButtonText: "Borrar",
      cancelButtonText: "Cancelar",
      reverseButtons: true,
    })
    .then(async (result) => {
      if (result.isConfirmed) {
        const eliminarRuta = ruta + id;

        const response = await fetch(eliminarRuta, {
          method: "DELETE",
          headers: {
            "Content-Type": "application/json",
          },
        });

        const data = await response.json();

        swalWithBootstrapButtons.fire({
          title: "Galleta eliminada",
          icon: "success",
        });
        location.reload();
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire({
          title: "Cancelado",
          text: "No se ha borrado la galleta",
          icon: "error",
        });
      }
    });
};
