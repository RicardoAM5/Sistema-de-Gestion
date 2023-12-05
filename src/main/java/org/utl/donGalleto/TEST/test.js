console.log("hola");

async function test() {
    let cantidad = '25'
    let total = '25'
    let idGalleta = '5'

    try {
        const response = await fetch(`http://localhost:8080/api/venta/save?cantidad=${cantidad}&total=${total}&idGalleta=${idGalleta}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
        });
        if (!response.ok) {
            console.log(response.text());
            throw new Error("Error in HTTP: " + response.status);
        }
        const data = await response.json();

        if (data.error) {
            console.log(data.error)
        } else {
            console.log(data);

        }
    } catch (error) {
        console.error("Error in response:", error);
    }

}
