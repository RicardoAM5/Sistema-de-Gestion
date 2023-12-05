const ctx = document.getElementById('grafico_galletas');
const ctx2 = document.getElementById('grafico_inventario');
var graficoGalletas;
var graficoInventario;
graficoGalletas = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Chispas de chocolate', 'Orejas', 'Orejas con chocolate', 'Nuez', 'Arandanos', 'Polvorones de naranja'],
        datasets: [{
            label: 'Galletas Vendidas',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgba(255, 159, 64, 0.2)'
              ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
graficoInventario = new Chart(ctx2, {
    type: 'bar',
    data: {
        labels: ['Chispas de chocolate', 'Orejas', 'Orejas con chocolate', 'Nuez', 'Arandanos', 'Polvorones de naranja'],
        datasets: [{
            label: 'Galletas Vendidas',
            data: [12, 19, 3, 5, 2, 3],
            backgroundColor: [
                'rgba(255, 159, 64, 0.2)'
              ],
            borderWidth: 1
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});

$(document).ready(function () {
    $('.btn-check').on('change', function () {
        var filtro = $('input[name="filters"]:checked').val();
        console.log('Valor seleccionado:', filtro);

        $.ajax({
            url : "http://localhost:8080/api/dashboard/ventasFecha",
            type : "GET",
            data:{"filtro": filtro},
            success : function(resp) {
                console.log(resp);
                var nombres = [];
                var valores = [];
                resp.forEach(function(item) {
                    nombres.push(item.nombreGalleta);
                    valores.push(item.cantidadVendida);
                });
                render_grafico_venta(nombres, valores);
            },
            error: function(error) {
                console.error(error);
            }
        });
    });
});

function render_grafico_venta(nombres, valores){
    graficoGalletas.destroy();
    const ctx = document.getElementById('grafico_galletas');
    graficoGalletas = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: nombres,
            datasets: [{
                label: 'Galletas Vendidas',
                data: valores,
                backgroundColor: [
                    'rgba(255, 159, 64, 0.2)'
                  ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

function render_grafico_inventario(nombres, valores){
    graficoInventario.destroy();
    const ctx2 = document.getElementById('grafico_inventario');
    graficoInventario = new Chart(ctx2, {
        type: 'bar',
        data: {
            labels: nombres,
            datasets: [{
                label: 'Inventario de Galletas',
                data: valores,
                backgroundColor: [
                    'rgba(255, 159, 64, 0.2)'
                  ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

        // Función para generar datos aleatorios
        function generarDatosAleatorios() {
            const nombresGalletas = ['Chispas', 'Trigo', 'Menta', 'Oreo', 'Chocolate Blanco', 'Nuez', 'Arándanos', 'Polvorones', 'Canela', 'Vainilla'];
            const cantidadMinima = 1;
            const cantidadMaxima = 20;
            const precioMinimo = 1.5;
            const precioMaximo = 3.5;

            const datos = [];

            for (let i = 1; i <= 30; i++) {
                const nombre = nombresGalletas[Math.floor(Math.random() * nombresGalletas.length)];
                const cantidad = Math.floor(Math.random() * (cantidadMaxima - cantidadMinima + 1)) + cantidadMinima;
                const precioUnitario = (Math.random() * (precioMaximo - precioMinimo) + precioMinimo).toFixed(2);
                const total = (cantidad * precioUnitario).toFixed(2);
                const fecha = obtenerFechaAleatoria();

                datos.push({
                    numero: i,
                    nombre: nombre,
                    cantidad: cantidad,
                    precioUnitario: precioUnitario,
                    total: total,
                    fecha: fecha
                });
            }

            return datos;
        }

        // Función para obtener una fecha aleatoria en formato YYYY-MM-DD
        function obtenerFechaAleatoria() {
            const fecha = new Date(2023, 0, 1 + Math.floor(Math.random() * 365));
            const year = fecha.getFullYear();
            const month = (fecha.getMonth() + 1).toString().padStart(2, '0');
            const day = fecha.getDate().toString().padStart(2, '0');

            return `${year}-${month}-${day}`;
        }

        // Función para llenar la tabla con datos aleatorios
        function llenarTabla() {
            const datosAleatorios = generarDatosAleatorios();
            const tableBody = document.getElementById('tableBody_ventas_reporte');

            datosAleatorios.forEach((dato) => {
                const row = document.createElement('tr');
                row.innerHTML = `<td>${dato.numero}</td>
                                 <td>${dato.nombre}</td>
                                 <td>${dato.cantidad}</td>
                                 <td>${dato.precioUnitario}</td>
                                 <td>${dato.total}</td>
                                 <td>${dato.fecha}</td>`;
                tableBody.appendChild(row);
            });
        }
$(document).ready(function () {
    $('#mes').click();
    llenarTabla();
    $.ajax({
        url : "http://localhost:8080/api/inventario/getAll",
        type : "GET",
        success : function(resp) {
            console.log(resp);
            var nombres = [];
            var valores = [];
            resp.forEach(function(item) {
                nombres.push(item.nombre);
                valores.push(item.cantidad);
            });
            render_grafico_inventario(nombres, valores);
        },
        error: function(error) {
            console.error(error);
        }
    });
});
