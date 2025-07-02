let room_id;
let uniCoords; 
let accCoords;

window.onload = function () {
    fetch('api/orchestrator/rooms')
        .then(response => {
            if (!response.ok) {
                throw new Error("Network Error");
            }
            return response.json();
        })
        .then(data => {
            roomDisplay(data);
         })
        .catch(error => {
            console.error("Failed to Fetch Data", error);
        });
};

// filter results from user room search
function roomFilter(){
    const query = document.getElementById("search-rooms").value;
    
    const url = "api/orchestrator/filter?query=" + query;
    
    fetch(url)
        .then(response => response.json())
        .then(data => {
            roomDisplay(data);  
    });
}

// listen for when user presses enter on search bar
document.getElementById("search-rooms").addEventListener("keydown", function(){
    if(event.key === "Enter"){
       roomFilter();
    }
});

// open the modal with room details
function openModal(detailedRoom) {
    const modalRoomName = document.getElementById("modalRoomName");
    const modalRoomImage = document.getElementById("modalRoomImage");
    modalRoomName.textContent = detailedRoom.name;
    modalRoomImage.src = "images/cover.jpg";

    const detailsContainer = document.getElementById("modalRoomDetails");
    detailsContainer.innerHTML = `
        <p>Location: ${detailedRoom.location.city}, ${detailedRoom.location.county}, ${detailedRoom.location.postcode}</p>
        <p>Monthly Price: ${detailedRoom.price_per_month_gbp}</p>
        <p>Amenities: ${detailedRoom.details.amenities.join(", ")}</p>
        <p>Bathroom: ${detailedRoom.details.bathroom_shared ? "Shared" : "Private"}</p>
        <p>Shared With: ${detailedRoom.details.shared_with} people</p>
        <p>Languages Spoken: ${detailedRoom.spoken_languages.join(", ")}</p>
        <p>Live-in Landlord: ${detailedRoom.details.live_in_landlord ? "Yes" : "No"}</p>
        <p>Bills Included: ${detailedRoom.details.bills_included ? "Yes" : "No"}</p>
    `;

    // display room
    document.getElementById("roomModal").style.display = "block";
}

// close room display
function closeModal() {
    document.getElementById("roomModal").style.display = "none";
}

// close modal when clicking outside of container
window.addEventListener("click", function (event) {
    const modal = document.getElementById("roomModal");
    if (event.target === modal) {
        closeModal();
    }
});

// toggle room details
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("room-toggle").addEventListener("click", function () {
        const details = document.getElementById("modalRoomDetails", "distance");
        const distance = document.getElementById("distance");

        if ((details.style.display === "" || details.style.display === "none") &&
            (distance.style.display === "" || distance.style.display === "none")) {
            distance.style.display = "block";
            details.style.display = "block";

        } else {
            distance.style.display = "none";
            details.style.display = "none";
        }
    });
});

// display rooms in nice format
function roomDisplay(data){
    const resultsContainer = document.querySelector(".results");
    resultsContainer.innerHTML = "";

    data.forEach(room => {
        const roomDiv = document.createElement("div");
        roomDiv.classList.add("result-item");

        // placeholder images
        const roomImage = document.createElement("img");
        roomImage.src = "images/cover.jpg";
        roomDiv.appendChild(roomImage);

        const roomName = document.createElement("h3");
        roomName.textContent = room.name;
        roomDiv.appendChild(roomName);

        const roomAvailability = document.createElement("p");
        roomAvailability.textContent = `
                Location: 
                ${room.location.city},
                ${room.location.county},
                ${room.location.postcode}
            `;
        roomDiv.appendChild(roomAvailability);

        const roomPrice = document.createElement("p");
        roomPrice.textContent = `Monthly Price: £${room.price_per_month_gbp}`;
        roomDiv.appendChild(roomPrice);

        if (room.details?.bills_included) {
            const billsContainer = document.createElement('div');
            billsContainer.classList.add('bills-container');

            const billsDiv = document.createElement('div');
            billsDiv.classList.add('bills');
            billsDiv.textContent = 'Bills Included';

            billsContainer.appendChild(billsDiv);
            roomDiv.appendChild(billsContainer);
        }

        roomDiv.addEventListener("click", function () {
            const detailedRoom = data.find(r => r._id.$oid === room._id.$oid);
            if (detailedRoom) {
                room_id = room._id.$oid;

                getCoords(detailedRoom.location.postcode).then(accomCoordsFetched => {
                    accCoords = accomCoordsFetched;
                    
                    // get student university postcode
                    const uniPostcode = JSON.parse(localStorage.getItem("userDetails")).postcode;
                    getCoords(uniPostcode).then(uniCoordsFetched => {
                        uniCoords = uniCoordsFetched;

                        // calculate distance between accommodation and university
                        calculateDistance(accCoords, uniCoords);

                        // initialise google maps with accommodation coordinates
                        initMap(accCoords);  

                        // process weather api results
                        getWeatherAPI(accCoords);

                        // process crime api results
                        callCrimeAPI(accCoords);

                        // open more room details
                        openModal(detailedRoom);
                    }).catch(error => {
                        console.error("error fetching university coordinates:", error);
                    });
                }).catch(error => {
                    console.error("error fetching accommodation coordinates:", error);
                });

            } else {
                console.error("room data not found");
            }
        });
        resultsContainer.appendChild(roomDiv);
    });
}
