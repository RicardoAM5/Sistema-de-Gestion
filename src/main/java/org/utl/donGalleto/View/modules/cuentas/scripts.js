const ctx = document.getElementById('grafico_galletas');
new Chart(ctx, {
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
        var valorSeleccionado = $('input[name="filters"]:checked').val();
        console.log('Valor seleccionado:', valorSeleccionado);
    });
});