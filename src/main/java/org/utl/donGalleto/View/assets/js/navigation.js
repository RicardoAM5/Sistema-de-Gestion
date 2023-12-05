window.cargarModuloGalletas = function cargarModuloGalletas() {
  // Ruta del archivo CSS a importar
  const rutaStylesCSS = "./modules/galletas/styles.css";

  // Realizar la petición fetch para obtener el HTML de la página
  fetch("./modules/galletas/galletas.html")
    .then((response) => response.text())
    .then((data) => {
      // Insertar el HTML en el contenedor principal
      document.getElementById("contenido").innerHTML = data;

      // Crear un nuevo elemento link para el archivo CSS y agregarlo al head
      const nuevoEnlace = document.createElement("link");
      nuevoEnlace.rel = "stylesheet";
      nuevoEnlace.href = rutaStylesCSS;
      document.head.appendChild(nuevoEnlace);
    })
    .catch((error) => console.error("Error al cargar la página:", error));
}
window.cargarModuloMateriales = function cargarModuloMateriales() {
  // Realizar la petición fetch para obtener el HTML de la página
  fetch("./modules/materiales/materiales.html")
    .then((response) => response.text())
    .then((data) => {
      // Insertar el HTML en el contenedor principal
      document.getElementById("contenido").innerHTML = data;

      // Obtener los enlaces CSS de la página cargada
      const estilos = document.querySelectorAll(
        '#contenido link[rel="stylesheet"]'
      );
      estilos.forEach((enlace) => {
        // Crear un nuevo elemento link y agregarlo al head
        const nuevoEnlace = document.createElement("link");
        nuevoEnlace.rel = "stylesheet";
        nuevoEnlace.href = enlace.href;
        document.head.appendChild(nuevoEnlace);
      });
    })
    .catch((error) => console.error("Error al cargar la página:", error));
}
window.cargarModuloCuentas = function cargarModuloCuentas() {
  // Realizar la petición fetch para obtener el HTML de la página
  fetch("modules/cuentas/cuentas.html")
    .then((response) => response.text())
    .then((data) => {
      // Insertar el HTML en el contenedor principal
      document.getElementById("contenido").innerHTML = data;

      // Obtener los enlaces CSS de la página cargada
      const estilos = document.querySelectorAll(
        '#contenido link[rel="stylesheet"]'
      );
      estilos.forEach((enlace) => {
        // Crear un nuevo elemento link y agregarlo al head
        const nuevoEnlace = document.createElement("link");
        nuevoEnlace.rel = "stylesheet";
        nuevoEnlace.href = enlace.href;
        document.head.appendChild(nuevoEnlace);
      });
      fetch("modules/cuentas/scripts.js")
      .then((response) => response.text())
      .then((data) => {
        const script = document.createElement("script");
        script.type= "module";
        script.textContent = data;
        document.body.appendChild(script);
      })
      .catch((error) => console.error("Error al cargar el script:", error));
    })
    .catch((error) => console.error("Error al cargar la página:", error));
}
window.cargarModuloInventario = function cargarModuloInventario() {
  // Ruta del archivo CSS a importar
  const rutaStylesCSS = "./modules/inventario/styles.css";

  // Realizar la petición fetch para obtener el HTML de la página
  fetch("./modules/inventario/inventario.html")
    .then((response) => response.text())
    .then((data) => {
      // Insertar el HTML en el contenedor principal
      document.getElementById("contenido").innerHTML = data;

      // Crear un nuevo elemento link para el archivo CSS y agregarlo al head
      const nuevoEnlace = document.createElement("link");
      nuevoEnlace.rel = "stylesheet";
      nuevoEnlace.href = rutaStylesCSS;
      document.head.appendChild(nuevoEnlace);
    })
    .catch((error) => console.error("Error al cargar la página:", error));
}
window.cargarModuloVentas = function cargarModuloVentas() {
  // Ruta del archivo CSS a importar
  const rutaStylesCSS = "./modules/ventas/styles.css";

  // Realizar la petición fetch para obtener el HTML de la página
  fetch("./modules/ventas/ventas.html")
    .then((response) => response.text())
    .then((data) => {
      // Insertar el HTML en el contenedor principal
      document.getElementById("contenido").innerHTML = data;

      // Crear un nuevo elemento link para el archivo CSS y agregarlo al head
      const nuevoEnlace = document.createElement("link");
      nuevoEnlace.rel = "stylesheet";
      nuevoEnlace.href = rutaStylesCSS;
      document.head.appendChild(nuevoEnlace);
    })
    .catch((error) => console.error("Error al cargar la página:", error));
}

window.cerrarSesion = function cerrarSesion() {
  localStorage.clear();

  window.location.href = "/modules/login/login.html";
}
