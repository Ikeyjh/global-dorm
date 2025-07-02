document.getElementById("details-form").addEventListener("submit", function(event){
    event.preventDefault();
    const fname = document.getElementById("fname").value;
    const lname = document.getElementById("lname").value;
    const phone = document.getElementById("phone").value;
    const email = document.getElementById("email").value;
    const postcode = document.getElementById("postcode").value;
    
    // format json data for database
    const url = "api/orchestrator/signup";
    const requestData = {
        first_name: fname,
        last_name: lname,
        phone: phone,
        email: email,
        postcode: postcode
    };
    
    fetch(url, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(requestData)
    })
        .then(response => {
            if(response.ok){
                return response;
            } else{
                throw new Error("failed to sign up");
            }
    })
        .then(data => {
            alert("user signup successful");
    })
        .catch(error => {
            alert("error during signup");
    });
    
    // save data locally
    localStorage.setItem("userDetails", JSON.stringify({
        email: email,
        postcode: postcode
    }));
});