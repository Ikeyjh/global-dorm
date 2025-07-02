// allow users to apply for rooms
document.addEventListener("DOMContentLoaded", function(){
    
    document.getElementById("apply-button").addEventListener("click", function(){
       // get user email
       const userData = JSON.parse(localStorage.getItem("userDetails"));
       const userEmail = userData.email;
       
       // send data
       const postData = {
           userEmail: userEmail,
           roomId: room_id
       };
       console.log(JSON.stringify(postData));
       fetch("api/orchestrator/apply", {
           method: "POST",
           headers: {
               "Content-Type": "application/json"
           },
           body: JSON.stringify(postData)
       })
           .then((response) => {
               if(!response.ok){
                   throw new Error("bad network response: " + response.statusText);
               }
               return response.json();
       })
           .then((data) => {
               console.log("application submitted successfully:", data);
       })
           .catch((error) => {
               console.error("error submitting application:", error);
       });
    });
    
    // toggle room application button
     document.getElementById("application-toggle").addEventListener("click", function(){
         const apply = document.getElementById("modalApplyDetails");
         
         
         if(apply.style.display === "" || apply.style.display === "none")
         {
             apply.style.display = "block";
             
         } else{
             apply.style.display = "none";
         }
    }); 
});