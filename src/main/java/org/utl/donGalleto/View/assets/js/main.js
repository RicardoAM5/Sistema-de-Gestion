document.addEventListener("DOMContentLoaded", function () {
    // Obtener el token del almacenamiento local
    const token = localStorage.getItem("token");

    // Verificar si el token está presente para determinar si se ha iniciado sesión
    if (!token) {
		/* window.location.href = "./modules/login/login.html"; */
    }
});

function cargarContenido() {
    // Realizar la petición fetch para obtener el HTML de la página
    fetch("./modules/bienvenida/bienvenida.html")
        .then(response => response.text())
        .then(data => {
            // Insertar el HTML en el contenedor principal
            document.getElementById('contenido').innerHTML = data;

            // Obtener los enlaces CSS de la página cargada
            const estilos = document.querySelectorAll('#contenido link[rel="stylesheet"]');
            estilos.forEach(enlace => {
                // Crear un nuevo elemento link y agregarlo al head
                const nuevoEnlace = document.createElement('link');
                nuevoEnlace.rel = 'stylesheet';
                nuevoEnlace.href = enlace.href;
                document.head.appendChild(nuevoEnlace);
            });

            // Obtener los scripts de la página cargada
            const scripts = document.querySelectorAll('#contenido script');
            scripts.forEach(script => {
                // Crear un nuevo elemento script y agregarlo al body
                const nuevoScript = document.createElement('script');
                nuevoScript.src = script.src;
                document.body.appendChild(nuevoScript);
            });

			cargarAnimacion();

        })
        .catch(error => console.error('Error al cargar la página:', error));
}

cargarContenido()

// Lógica principal de la aplicación
function cargarAnimacion(){
	particlesJS("particles-js", {
		"particles": {
			"number": {
				"value": 20,
				"density": {
					"enable": true,
					"value_area": 400
				}
			},
			"color": {
				"value": "#ffffff"
			},
			"shape": {
				"type": "image",
				"stroke": {
					"width": 0,
					"color": "#000000"
				},
				"polygon": {
					"nb_sides": 8
				},
				"image": {
					"src": "https://imgs.search.brave.com/f0AA5KMahbJBZxvvri8fmSvDGIoTS-qPIRZ1CbYAATc/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZXMudmV4ZWxzLmNv/bS9tZWRpYS91c2Vy/cy8zLzMxMzkyOS9p/c29sYXRlZC9wcmV2/aWV3Lzk3YTY4M2Mz/MDZiNDFhOTViNjFh/ZTMwZmQ1MzgxMTEw/LWRpc2VhLW8tZGUt/dW5hLWdhbGxldGEt/Y3J1amllbnRlLnBu/Zw",
					"width": 100,
					"height": 100
				}
			},
			"opacity": {
				"value": 0.5,
				"random": false,
				"anim": {
					"enable": false,
					"speed": 1,
					"opacity_min": 0.1,
					"sync": false
				}
			},
			"size": {
				"value": 40,
				"random": true,
				"anim": {
					"enable": false,
					"speed": 40,
					"size_min": 10,
					"sync": false
				}
			},
			"line_linked": {
				"enable": false,
				"distance": 150,
				"color": "#ffffff",
				"opacity": 0.4,
				"width": 1
			},
			"move": {
				"enable": true,
				"speed": 1,
				"direction": "none",
				"random": true,
				"straight": false,
				"out_mode": "out",
				"bounce": true,
				"attract": {
					"enable": false,
					"rotateX": 600,
					"rotateY": 1200
				}
			}
		},
		"interactivity": {
			"detect_on": "canvas",
			"events": {
				"onhover": {
					"enable": true,
					"mode": "grab"
				},
				"onclick": {
					"enable": true,
					"mode": "push"
				},
				"resize": true
			},
			"modes": {
				"grab": {
					"distance": 140,
					"line_linked": {
						"opacity": 0
					}
				},
				"bubble": {
					"distance": 400,
					"size": 40,
					"duration": 2,
					"opacity": 8,
					"speed": 3
				},
				"repulse": {
					"distance": 200,
					"duration": 0.4
				},
				"push": {
					"particles_nb": 1
				},
				"remove": {
					"particles_nb": 1
				}
			}
		}
	}); 
}
