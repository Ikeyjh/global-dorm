// get results from weather api
function getWeatherAPI(){
    
    const lng = accCoords[0];
    const lat = accCoords[1];
    const url = `api/orchestrator/weather?lon=${lng}&lat=${lat}`;
    
    fetch(url)
    .then(response => {
        if (!response.ok) {
            throw new Error("bad network response");
        }
        return response.json();
    })
    .then(data => {
        const modalWeatherDetails = document.getElementById("modalWeatherDetails");
        modalWeatherDetails.innerHTML = "";

        // check if the first element is redundant, if yes, format the redundant api results
        if (data[0]?.type === "redundant") {
            data.forEach(day => {
                const dayDiv = document.createElement("div");
                dayDiv.classList.add("weather-day");

                dayDiv.innerHTML = `
                    <p>Date: ${day.date}</p>
                    <p>Temp: ${day.temperature}°C</p>
                `;

                modalWeatherDetails.appendChild(dayDiv);
            });
            return;
        }

        // process standard weather api
        data.forEach(day => {
            const dayDiv = document.createElement("div");
            dayDiv.classList.add("weather-day");

            dayDiv.innerHTML = `
                <p>Date: ${day.date}</p>
                <p>Weather: ${day.weather}</p>
                <p>Temperature: Min: ${day.temperature.min}°C, Max: ${day.temperature.max}°C</p>
                <p>Wind: ${day.wind10MMax}km/h</p>
            `;
            modalWeatherDetails.appendChild(dayDiv);
        });
    })
    .catch(error => {
        console.error("Error fetching data:", error);
    });

}

// toggle weather details
document.addEventListener("DOMContentLoaded", function(){
    document.getElementById("weather-toggle").addEventListener("click", function (){
        const weather = document.getElementById("modalWeatherDetails");

        if(weather.style.display === "" || weather.style.display === "none"){
            weather.style.display = "block";
        } else {
            weather.style.display = "none";
        }
    });
});
