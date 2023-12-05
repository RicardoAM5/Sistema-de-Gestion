import { login } from "../apiUrls.js";

(() => {
  "use strict";

  const forms = document.querySelectorAll(".needs-validation");

  Array.from(forms).forEach((form) => {
    form.addEventListener(
      "submit",
      (event) => {
        event.preventDefault();
        event.stopPropagation();
        if (form.checkValidity()) {
          iniciarSesion();
        }

        form.classList.add("was-validated");
      },
      false
    );
  });
})();

export function iniciarSesion() {
  const nombre = document.getElementById("user").value;
  const contrasenia = document.getElementById("password").value;
  const user = document.getElementById("user");
  const password = document.getElementById("password");

  const apiRoute = login + "usuario=" + nombre + "&contrasenia=" + contrasenia;

  // Realizar la solicitud de inicio de sesión mediante fetch
  fetch(apiRoute, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => {
      if (!response.ok) {
        Swal.fire({
          icon: "error",
          title: "Denegado",
          text: "Credenciales incorrectas",
        });
        user.value = "";
        password.value = "";
      }
      return response.json();
    })
    .then((data) => {
      // Si la respuesta es exitosa, redirige al index u otra página

      if (data.error) {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: data.error,
        });
      } else {
        console.log("Inicio de sesión exitoso:", data);

        if (!data.token) {
          data.token = "jdhjdakjdakjdakjd";
        }

        const token = data.token;
        localStorage.setItem("token", token);

        window.location.href = "/index.html";
      }
      // Puedes redirigir a la página principal (index.html) o realizar otras acciones necesarias
    })
    .catch((error) => {
      Swal.fire({
        icon: "error",
        title: "Oops...",
        text: "Error en la solicitud de inicio de sesión",
      });
      password.value = "";
      console.error("Error en el inicio de sesión:", error);
      // Aquí puedes manejar el error de inicio de sesión, como mostrar un mensaje al usuario
    });
}

particlesJS("particles-js", {
  particles: {
    number: {
      value: 20,
      density: {
        enable: true,
        value_area: 400,
      },
    },
    color: {
      value: "#ffffff",
    },
    shape: {
      type: "image",
      stroke: {
        width: 0,
        color: "#000000",
      },
      polygon: {
        nb_sides: 8,
      },
      image: {
        src: "https://imgs.search.brave.com/f0AA5KMahbJBZxvvri8fmSvDGIoTS-qPIRZ1CbYAATc/rs:fit:860:0:0/g:ce/aHR0cHM6Ly9pbWFn/ZXMudmV4ZWxzLmNv/bS9tZWRpYS91c2Vy/cy8zLzMxMzkyOS9p/c29sYXRlZC9wcmV2/aWV3Lzk3YTY4M2Mz/MDZiNDFhOTViNjFh/ZTMwZmQ1MzgxMTEw/LWRpc2VhLW8tZGUt/dW5hLWdhbGxldGEt/Y3J1amllbnRlLnBu/Zw",
        width: 100,
        height: 100,
      },
    },
    opacity: {
      value: 0.5,
      random: false,
      anim: {
        enable: false,
        speed: 1,
        opacity_min: 0.1,
        sync: false,
      },
    },
    size: {
      value: 40,
      random: true,
      anim: {
        enable: false,
        speed: 40,
        size_min: 10,
        sync: false,
      },
    },
    line_linked: {
      enable: false,
      distance: 150,
      color: "#ffffff",
      opacity: 0.4,
      width: 1,
    },
    move: {
      enable: true,
      speed: 1,
      direction: "none",
      random: true,
      straight: false,
      out_mode: "out",
      bounce: true,
      attract: {
        enable: false,
        rotateX: 600,
        rotateY: 1200,
      },
    },
  },
  interactivity: {
    detect_on: "canvas",
    events: {
      onhover: {
        enable: true,
        mode: "grab",
      },
      onclick: {
        enable: true,
        mode: "push",
      },
      resize: true,
    },
    modes: {
      grab: {
        distance: 140,
        line_linked: {
          opacity: 0,
        },
      },
      bubble: {
        distance: 400,
        size: 40,
        duration: 2,
        opacity: 8,
        speed: 3,
      },
      repulse: {
        distance: 200,
        duration: 0.4,
      },
      push: {
        particles_nb: 1,
      },
      remove: {
        particles_nb: 1,
      },
    },
  },
});
