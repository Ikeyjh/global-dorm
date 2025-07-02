// get accommodation coordinates from postcode
function getCoords(postcode){
    const url = `api/orchestrator/geocoding?postcode=${postcode.replace(" ", "")}`;
    return fetch(url)
        .then(response => {
            if(!response.ok){
                throw new Error("bad network response");
            }
            return response.json();
        })
        .then(data => {

            const latStr = data.find(item => item.startsWith("lat"));
            const lngStr = data.find(item => item.startsWith("lng"));
            
            const lat = parseFloat(latStr.split(":")[1]);
            const lng = parseFloat(lngStr.split(":")[1]);
            
            return[lat, lng];
            
        });
}