function editarGalleta(
  nombre,
  precioUnitario,
  precioKilo,
  descripcion,
  idGalleta,
  imagenBase64
) {
  document.getElementById("agregarProductoModalLabel").value = "Editar";
  document.getElementById("btn_agregar_galleta").value = "Editar";

  document.getElementById("nombre").value = nombre;
  document.getElementById("id").value = idGalleta;
  document.getElementById("cantidad").value = cantidad;
  document.getElementById("precio_unitario").value = precioUnitario;
  document.getElementById("precio_kilo").value = precioKilo;
  document.getElementById("descripcion").value = descripcion;
  const img = document.getElementById("imagen-previa");
  img.src = "data:image/png;base64," + imagenBase64;
}

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
      nombre: nombre,
      cantidad: cantidad,
      precioUnitario: precioUnitario,
      precioKilo: precioKilo,
      descripcion: descripcion,
      imagenBase64: imagenBase64,
    };
    // Hacer la solicitud Fetch
    fetch("http://localhost:8080/api/galleta/save", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(params),
    })
      .then((response) => response.json())
      .then((data) => {
        // Lógica para manejar la respuesta del servidor
        console.log("Respuesta del servidor:", data);
        //
        // // Cerrar el modal si es necesario
        const modal = new bootstrap.Modal(document.getElementById("addCookie"));
        modal.hide();
        alert("se agregó la galleta");
        location.reload();
      })
      .catch((error) => {
        // Lógica para manejar errores
        console.error("Error en la solicitud:", error);
      });
  };
}

function editarGalletaCommit() {
  const nombre = document.getElementById("nombre").value;
  const id = document.getElementById("id").value;
  const cantidad = document.getElementById("cantidad").value;
  const precioUnitario = document.getElementById("precio_unitario").value;
  const precioKilo = document.getElementById("precio_kilo").value;
  const descripcion = document.getElementById("descripcion").value;

  // Obtener el archivo de imagen y convertirlo a base64
  const imagenInput = document.getElementById("imagen");
  const imagenFile = imagenInput.files[0];
  let imagenBase64 = "";
  if (!imagenFile) {
    const img = document.getElementById("imagen-previa");
    imagenFile = img.src;
    imagenBase64 = imagenFile.split(",")[1];
  } else {
    const reader = new FileReader();
    reader.readAsDataURL(imagenFile);
    reader.onloadend = function () {
      imagenBase64 = reader.result.split(",")[1]; // Obtener el contenido en base64
    };
  }

  // Construir el objeto JSON
  const params = {
    idGalleta: id,
    nombre: nombre,
    cantidad: cantidad,
    precioUnitario: precioUnitario,
    precioKilo: precioKilo,
    descripcion: descripcion,
    imagenBase64: imagenBase64,
  };

  // Hacer la solicitud Fetch
  fetch("http://localhost:8080/api/galleta/update", {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(params),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log("Respuesta del servidor:", data);
      const modal = new bootstrap.Modal(document.getElementById("editCookie"));
      modal.hide();
      alert("Se actualizó la galleta");
      location.reload();
    })
    .catch((error) => {
      // Lógica para manejar errores
      console.error("Error en la solicitud:", error);
    });
  document.getElementById("agregarProductoModalLabel").value = "Agregar";
  document.getElementById("btn_agregar_galleta").value = "Agregar";

  document.getElementById("nombre").value = "";
  document.getElementById("id").value = "";
  document.getElementById("cantidad").value = "";
  document.getElementById("precio_unitario").value = "";
  document.getElementById("precio_kilo").value = "";
  document.getElementById("descripcion").value = "";
}

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
        alert("La página se recargará para mostrar cambios");
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
