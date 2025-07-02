function callCrimeAPI(){
    
    const lat = accCoords[0];
    const lng = accCoords[1];
    
    const url = `api/orchestrator/crime?lng=${lng}&lat=${lat}`;
    
    fetch(url)
        .then(response => {
            if(!response.ok){
                throw new Error("bad network response");
            }
            return response.json();    
        })
        .then(data => {
            const modalCrimeDetails = document.getElementById("modalCrimeDetails");
            modalCrimeDetails.innerHTML = "";
            
            data.forEach((crime, index) => {
                
                const crimeDiv = document.createElement("div");
                crimeDiv.classList.add("crime");
                
                crimeDiv.innerHTML = `
                    <p>${index + 1}. ${crime.category}: ${crime.count}</p>
                `;
            
                modalCrimeDetails.appendChild(crimeDiv);
            });
        });
}

// toggle crime details visibility
document.addEventListener("DOMContentLoaded", function(){
    document.getElementById("crime-toggle").addEventListener("click", function (){
        const crime = document.getElementById("modalCrimeDetails");

        if(crime.style.display === "" || crime.style.display === "none"){
            crime.style.display = "block";
        } else {
            crime.style.display = "none";
        }
    });
});
