console.log("hola");

async function test() {
    let idMateriaPrima = '6'
    let ingrediente = '6'
    let peso = '5'

   let params = {
        idMateriaPrima,
        ingrediente,
            peso
            }


    try {
        const response = await fetch(`http://localhost:8080/api/materiaPrima/update`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
           body:JSON.stringify(params)
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
