// allow admin to accept and reject applications
document.addEventListener("DOMContentLoaded", function(){
    const resultsContainer = document.getElementById("admin-rooms");
    resultsContainer.innerHTML = "<h3 style=\"text-align: center\">Accept or Reject</h3>";

    const url = "api/orchestrator/admin";

    fetch(url)
    .then(response => response.json())
    .then(data => {
      
        data.forEach(application => {
            const appDiv = document.createElement("div");
            appDiv.classList.add("application-item");

            // display application details
            const appId = document.createElement("p");
            const objectId = application._id.$oid;
            appId.textContent = "Application ID: " + objectId;
            appDiv.appendChild(appId);
            
            const userId = document.createElement("p");
            userId.textContent = "User ID: " + application.userId;
            appDiv.appendChild(userId);

            const dateApplied = document.createElement("p");
            dateApplied.textContent = "Date Applied: " + application.date;
            appDiv.appendChild(dateApplied);

            const status = document.createElement("p");
            status.textContent = "Status: " + application.status;
            appDiv.appendChild(status);

            const acceptButton = document.createElement("button");
            acceptButton.textContent = "Accept";
            acceptButton.classList.add("accept-button");
            
            const rejectButton = document.createElement("button");
            rejectButton.textContent = "Reject";
            rejectButton.classList.add("reject-button");
            
            acceptButton.addEventListener("click", function() {
                alert("Application ID: " + objectId + " has been accepted");
                fetch("api/orchestrator/delete/" + objectId + "/accepted", {
                method: "DELETE"
                })
                .then(response => response.json())
                .then(data => {
                    if (data.success) {
                        appDiv.remove();
                    } else {
                        alert("failed to accept application");
                    }
                })
                .catch(error => console.error('Error:', error));
                });
                
                appDiv.appendChild(acceptButton);
                
            rejectButton.addEventListener("click", function() {
                alert("application ID: " + objectId + " has been rejected");
                fetch("api/orchestrator/delete/" + objectId + "/rejected", {
                method: "DELETE"
                })
                .then(response => response.json())
                .then(data => {
                    if (data.success) {
                        appDiv.remove();
                    } else {
                        alert("failed to reject application");
                    }
                })
                .catch(error => console.error('Error:', error));
                });
                
                appDiv.appendChild(rejectButton);

                resultsContainer.appendChild(appDiv); 
            });
   
        });
    });
    

