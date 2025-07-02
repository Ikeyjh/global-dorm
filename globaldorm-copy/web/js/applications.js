// allow user to see their pending applications
document.addEventListener("DOMContentLoaded", function(){
    const userData = JSON.parse(localStorage.getItem("userDetails"));
    const userEmail = userData.email;
    const resultsContainer = document.getElementById("applied-rooms");
    resultsContainer.innerHTML = "<h3 style=\"text-align: center\">See Your Pending</h3>";

    const url = "api/orchestrator/pending?userEmail=" + userEmail;
    
    fetch(url)
    .then(response => response.json())
    .then(data => {
      
        data.forEach(application => {
            
            const appDiv = document.createElement("div");
            appDiv.classList.add("application-item");

            // display application details
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

            const delButton = document.createElement("button");
            delButton.textContent = "Delete";
            delButton.classList.add("delete-button");

            delButton.addEventListener("click", function() {
                alert("Delete button clicked for application ID: " + application.applicationId);
                const url = "api/orchestrator/delete/" + application.applicationId + "/cancelled";
                console.log(url);
                fetch(url, {
                method: "DELETE"
                })
                .then(response => response.json())
                .then(data => {
                    if (data.success) {
                        appDiv.remove();
                    } else {
                        alert("failed to delete application");
                    }
                })
                .catch(error => console.error('Error:', error));
                });
           
            appDiv.appendChild(delButton);
 
            resultsContainer.appendChild(appDiv); 
            
            });
   
        });
    });
    

