// calculate distance from selected accommodation and user university postcode
function calculateDistance(accomCoords, uniCoords) {
    const accomLat = accomCoords[0];
    const accomLng = accomCoords[1];
    const uniLat = uniCoords[0];
    const uniLng = uniCoords[1];

    const url = `api/orchestrator/distance?coordinates=${uniLng},${uniLat};${accomLng},${accomLat}`;

    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error("Bad network response");
            }
            return response.json();
        })
        .then(data => {

            if (data && data.Distance && data.walkingTime) {
                const distance = data.Distance;
                const walkingTime = data.walkingTime;
                
                // display results
                document.getElementById("distance-result").innerHTML = `
                    <p>Distance From Your University: ${distance} meters</p>
                    <p>Estimated Walking Time: ${walkingTime} minutes</p>
                `;
            } else {
                console.error("Expected data format not found:", data);
            }
        })
        .catch(error => {
            console.error("Error calculating distance:", error);
        });
}
