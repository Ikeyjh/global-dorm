let map, autocomplete, marker;

function initMap(coords) {
    const defaultCoords = [51.5074, -0.1278];
    if (!coords || coords.length !== 2) {
        console.error("invalid coordinates provided, resulting to default: london", coords);
        coords = defaultCoords;
    }

    const center = { lat: coords[0], lng: coords[1] };  // Use the provided coordinates

    // Create the map
    map = new google.maps.Map(document.getElementById("maps"), {
        zoom: 14,
        center: center,
        zoomControl: true,
        zoomControlOptions: {
            position: google.maps.ControlPosition.TOP_RIGHT
        },
        streetViewControl: true,
        streetViewControlOptions: {
            position: google.maps.ControlPosition.TOP_RIGHT
        }
    });

    // place marker on map
    marker = new google.maps.Marker({
        position: center,
        map: map
    });

    // create autocomplete functionality
    autocomplete = new google.maps.places.Autocomplete(
        document.getElementById("location-input"), 
        {types: ["geocode"]}
    );  

    // listen to user input for suggestions
    autocomplete.addListener("place_changed", onPlaceChanged);
}

function onPlaceChanged() {
    const place = autocomplete.getPlace();
    
    // return message if no available place is found for input
    if (!place.geometry) {
        console.log("No details available for input: '" + place.name + "'");
        return;
    }

    // update map center
    map.setCenter(place.geometry.location);
    map.setZoom(14);

    // move marker when place changed
    marker.setPosition(place.geometry.location);
}

// toggle map view
document.addEventListener("DOMContentLoaded", function(){
    document.getElementById("maps-toggle").addEventListener("click", function(){
         const maps = document.getElementById("modalMapsDetails");

        if(maps.style.display === "" || maps.style.display === "none"){
            maps.style.display = "block";
        } else {
            maps.style.display = "none";
        } 
  }); 
});
