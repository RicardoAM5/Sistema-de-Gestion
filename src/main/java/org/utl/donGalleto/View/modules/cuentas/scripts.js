const ctx = document.getElementById('grafico_galletas');
var graficoGalletas;
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
                    render_grafico(nombres, valores);
                });
            },
            error: function(error) {
                console.error(error);
            }
        });
    });
});

function render_grafico(nombres, valores){
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

$(document).ready(function () {
    $('#mes').click();
});
