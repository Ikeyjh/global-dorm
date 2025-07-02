// view history of room applications
document.addEventListener("DOMContentLoaded", function(){
    // get locally stored user email
    const userData = JSON.parse(localStorage.getItem("userDetails"));
    const userEmail = userData.email;

    const url = "api/orchestrator/history?userEmail=" + userEmail;

    fetch(url)
    .then(response => response.json())
    .then(data => {
        const resultsContainer = document.getElementById("application-history");
        resultsContainer.innerHTML = "<h3 style=\"text-align: center\">See Your History</h3>";

        // loop through each application document and display details
        data.forEach(application => {
            const appDiv = document.createElement("div");
            appDiv.classList.add("application-item");

            const appId = document.createElement("p");
            appId.textContent = "Application ID: " + application.applicationId;
            appDiv.appendChild(appId);

            const roomName = document.createElement("h3");
            roomName.textContent = "Room: " + application.roomName;
            appDiv.appendChild(roomName);

            const dateApplied = document.createElement("p");
            dateApplied.textContent = "Date Applied: " + application.date;
            appDiv.appendChild(dateApplied);

            const status = document.createElement("p");
            status.textContent = "Status: " + application.status;
            appDiv.appendChild(status);

            resultsContainer.appendChild(appDiv); 
            });
        });
    });
    

