const url ='http://localhost:8083/P1-david-c-knutson/' //I grabbed this base URL from postman
//http://localhost:8083/P1Demo/login
//it's also what shows up when you run as server and get your 404 page
 

  function previousFunction() {
    var x = document.getElementById("previous");
    var y = document.getElementById("statusticket");
    var z = document.getElementById("approveticket");
    var aa = document.getElementById("exit");

    if (x.style.display === "none") {
      x.style.display = "block";
      y.style.display = "none";
      z.style.display = "none";
      aa.style.display = "none";

    } else {
      x.style.display = "none";
    }
  }

  function statusFunction() {
    var x = document.getElementById("statusticket");
    var y = document.getElementById("previous");
    var z = document.getElementById("approveticket");
    var aa = document.getElementById("exit");

    if (x.style.display === "none") {
      x.style.display = "block";
      y.style.display = "none";
      z.style.display = "none";
      aa.style.display = "none";
    } else {
      x.style.display = "none";
    }
  }

  function approveFunction() {
    var x = document.getElementById("approveticket");
    var y = document.getElementById("previous");
    var z = document.getElementById("statusticket");
    var aa = document.getElementById("exit");

    if (x.style.display === "none") {
      x.style.display = "block";
      y.style.display = "none";
      z.style.display = "none";
      aa.style.display = "none";
    } else {
      x.style.display = "none";
    }
  }

   
  function exitFunction() {
    var x = document.getElementById("exit");
    var y = document.getElementById("previous");
    var z = document.getElementById("statusticket");
    var aa = document.getElementById("approveticket");

    if (x.style.display === "none") {
      x.style.display = "block";
      y.style.display = "none";
      z.style.display = "none";
      aa.style.display = "none";
    } else {
      x.style.display = "none";
    }
  }

 
 //------------------------------------Get all expenses section-------------------------------------
 

document.getElementById("getExpenseButton").addEventListener('click', expenseFunc);
 
async function expenseFunc() { //async returns a promise (which fetch returns)

  var rem_nm;
  let response2 = await fetch(url + 'users');
  if(response2.status === 200) { //if the request is successful...
    console.log("response",response2); //just to see what comes back for debug
     
    var data2 = await response2.json();
     
    
     
  }
 
     
    let response = await fetch(url + 'expenses');

    if(response.status === 200) { //if the request is successful...
        console.log(response); //just to see what comes back for debug

        let data = await response.json(); //get the JSON data from the response, turn it into JS object


        
        for(let expense of data) { 

          for(let usm of data2) { 
             
            if(expense.reimb_author == usm.ers_users_id){
               rem_nm = usm.ers_username;
               
             } 
          }





            console.log(expense); 

            let row = document.createElement("tr"); //create a table row

            let cell = document.createElement("td"); //create a cell for the field
            cell.innerHTML = expense.reimb_id; //fill the cell with expense data
            row.appendChild(cell); //this row now has the first cell (rem_id)
             
            let cell2 = document.createElement("td"); //create a cell for the field
            cell2.innerHTML = expense.reimb_amount; //fill the cell with expense data
            row.appendChild(cell2); //this row now has the second cell (expense.reimb_amount)

            let cell3 = document.createElement("td");  
            cell3.innerHTML = expense.reimb_submitted;  
            row.appendChild(cell3);  

            let cell4 = document.createElement("td");  
            cell4.innerHTML = expense.reimb_resolved;  
            row.appendChild(cell4); 

            let cell5 = document.createElement("td"); 
            cell5.innerHTML = expense.reimb_description;  
            row.appendChild(cell5); 

            let cell6 = document.createElement("td"); 
            //cell6.innerHTML = expense.reimb_author;
            cell6.innerHTML = rem_nm; 
            row.appendChild(cell6); 

            
            let cell7 = document.createElement("td");
            if(expense.reimb_resolver== 1){
              resolvername = "John Smith";
              cell7.innerHTML = resolvername;
            }else{
              resolvername = "Not Reviewed";
              cell7.innerHTML = resolvername;
            }
            
            //cell7.innerHTML = expense.reimb_resolver;  
            row.appendChild(cell7);



            let cell8 = document.createElement("td"); 
            if(expense.reimb_status_id == 1){
              //console.log("im here")
              statusname = "Submitted";
              cell8.innerHTML = statusname;
            }else if(expense.reimb_status_id == 2) {
              statusname = "Under Review";
              cell8.innerHTML = statusname;
              //cell8.innerHTML = expense.reimb_status_id;
            }else if(expense.reimb_status_id == 3) {
              statusname = "Accepted";
              cell8.innerHTML = statusname;
            }else{
              statusname = "Declined";
              cell8.innerHTML = statusname;
            }
            //cell8.innerHTML = expense.reimb_status_id;  
            row.appendChild(cell8);
             

            let cell9 = document.createElement("td"); 
            if(expense.reimb_type_id == 1){
              
              statusname = "Food";
              cell9.innerHTML = statusname;
            }else if(expense.reimb_type_id == 2) {
              statusname = "Airfare";
              cell9.innerHTML = statusname;
              //cell8.innerHTML = expense.reimb_status_id;
            }else if(expense.reimb_type_id == 3) {
              statusname = "Lodging";
              cell9.innerHTML = statusname;
            }else if(expense.reimb_type_id == 4) {
              statusname = "Transportation";
              cell9.innerHTML = statusname;
            }else{
              statusname = "Other";
              cell9.innerHTML = statusname;
            }
            //cell8.innerHTML = expense.reimb_status_id;  
            row.appendChild(cell9);
 

        document.getElementById("expenseBody").appendChild(row);
        

        }

    }

}



//------------------------status change-------------------------------------------



document.getElementById("getstatusButton").addEventListener('click', statusFunc);
 
async function statusFunc() { //async returns a promise (which fetch returns)


  var rem_nm;
  let response2 = await fetch(url + 'users');
  if(response2.status === 200) { //if the request is successful...
    console.log("response",response2); //just to see what comes back for debug
     
    var data2 = await response2.json();
     
    
     
  }

    
    let response = await fetch(url + 'expenses');

    if(response.status === 200) { //if the request is successful...
        console.log(response); //just to see what comes back for debug

        let data = await response.json(); //get the JSON data from the response, turn it into JS object


         
        for(let expense of data) {  

          for(let usm of data2) { 
             
            if(expense.reimb_author == usm.ers_users_id){
               rem_nm = usm.ers_username;
               
             } 
          }


          var num;
          let tempv1 = document.getElementById("favourite1").value;
          if(tempv1 == "Submitted"){
            num = "1";
          }else if(tempv1 == "Under Review"){
            num = "2";
          }else if(tempv1 == "Accepted"){
            num = "3";
          }else if(tempv1 == "Declined"){
            num = "4";
          }else {num = "4"; }
      
          console.log("265 tempv1",tempv1);
          console.log("266 status",num);




            console.log(expense); //just for debug, print the avenger in the console
            let input_status_id = document.getElementById("statusid").value;
            
             
             





            if (expense.reimb_status_id == num){   
            let row = document.createElement("tr"); //create a table row

            let cell = document.createElement("td"); //create a cell for the field
            cell.innerHTML = expense.reimb_id; //fill the cell with expense data
            row.appendChild(cell); //this row now has the first cell (rem_id)
             
            let cell2 = document.createElement("td"); //create a cell for the field
            cell2.innerHTML = expense.reimb_amount; //fill the cell with expense data
            row.appendChild(cell2); //this row now has the second cell (expense.reimb_amount)

            let cell3 = document.createElement("td");  
            cell3.innerHTML = expense.reimb_submitted;  
            row.appendChild(cell3);  

            let cell4 = document.createElement("td");  
            cell4.innerHTML = expense.reimb_resolved;  
            row.appendChild(cell4); 

            let cell5 = document.createElement("td"); 
            cell5.innerHTML = expense.reimb_description;  
            row.appendChild(cell5); 

            let cell6 = document.createElement("td"); 
            cell6.innerHTML = expense.reimb_author;
            
            cell6.innerHTML = rem_nm; 
            row.appendChild(cell6); 

           
            let cell7 = document.createElement("td");
            if(expense.reimb_resolver== 1){
              resolvername = "John Smith";
              cell7.innerHTML = resolvername;
            }else{
              resolvername = "Not Reviewed";
              cell7.innerHTML = resolvername;
            }
            
            //cell7.innerHTML = expense.reimb_resolver;  
            row.appendChild(cell7);

            

            let cell8 = document.createElement("td"); 
            cell8.innerHTML = tempv1;  
            row.appendChild(cell8);
 

            let cell9 = document.createElement("td"); 
            if(expense.reimb_type_id == 1){
              //console.log("im here")
              statusname = "Food";
              cell9.innerHTML = statusname;
            }else if(expense.reimb_type_id == 2) {
              statusname = "Airfare";
              cell9.innerHTML = statusname;
              //cell8.innerHTML = expense.reimb_status_id;
            }else if(expense.reimb_type_id == 3) {
              statusname = "Lodging";
              cell9.innerHTML = statusname;
            }else if(expense.reimb_type_id == 4) {
              statusname = "Transportation";
              cell9.innerHTML = statusname;
            }else{
              statusname = "Other";
              cell9.innerHTML = statusname;
            }
            //cell8.innerHTML = expense.reimb_status_id;  
            row.appendChild(cell9);



         
 


        document.getElementById("statusBody").appendChild(row);
         

        }
      }

    }

}
 
//-------------------------------------------approve section------------------------------------

 

 
 
  document.getElementById("getApproveButton").addEventListener('click', approveFunc);

  async function approveFunc() { //async returns a promise (which fetch returns)
     

    var statnum;
      
     
    let response = await fetch(url + 'expenses');

    if(response.status === 200) { //if the request is successful...
      console.log(response); //just to see what comes back for debug

      let data = await response.json(); //get the JSON data from the response, turn it into JS object
      
       
       
      var inloop = 0;
      
      while(inloop == 0){




      for(let expense of data) {  
         


        var num2;
        let tempv3 = document.getElementById("approvaldecision").value;
        if(tempv3 == "Submitted"){
          num2 = "1";
        }else if(tempv3 == "Under Review"){
          num2 = "2";
        }else if(tempv3 == "Accepted"){
          num2 = "3";
        }else if(tempv3 == "Declined"){
          num2 = "4";
        }else {num2 = "4"; }
    
        console.log("265 tempv1",tempv3);
        console.log("266 status",num2);

         
        let reimb_id3 = document.getElementById("recordid").value;

 

          console.log(expense);
          if(expense.reimb_id == reimb_id3 ){
            inloop = 1;
            console.log("418 we find the record")
            let reimb_id =  expense.reimb_id;
            let reimb_amount = expense.reimb_amount;
            let reimb_submitted = expense.reimb_submitted; 
            let reimb_resolved =  expense.reimb_resolved;
            let reimb_description =  expense.reimb_description;
            let reimb_author = expense.reimb_author;
            let reimb_resolver = expense.reimb_resolver;
 
            let reimb_status_id =  num2;
              
            let reimb_type_id = expense.reimb_type_id;

            let expen = {
              reimb_id:reimb_id,
              reimb_amount:reimb_amount, 
              reimb_submitted:reimb_submitted,
              reimb_resolved:reimb_resolved,
              reimb_description:reimb_description,
              reimb_author:reimb_author,
              reimb_resolver:reimb_resolver,
              reimb_status_id:reimb_status_id,
              reimb_type_id:reimb_type_id
              
            }
 
            console.log(expen); 

            let response = await fetch(url + "addExpense", {
             
            method: "POST", //send as a POST request
            body: JSON.stringify(expen), //turn into JSON
            credentials: "include" //this will ensure that the cookie is captured
                                  //future fetches will also require this value to send the cookie back
            
            });

            console.log(response.status); //the user input (the num variable) to the base URL
            
          } 

      }


      if(inloop == 0) {
        console.log("84 user not found");
        document.getElementById("empwarn3").style.display = "block";
        document.getElementById("empwarn3").style="background-color:yellow";
        document.getElementById("empwarn3").innerHTML = "Invalid Record please try again";
        break;
      } else {
        console.log("id good")
        inloop = 1;
        document.getElementById("empwarn3").style.display = "none";
      }
      document.getElementById("decided").style.display = "block";
      document.getElementById("decided").style="background-color:lightgreen";
      document.getElementById("decided").innerHTML = "Status Changed"; 
    }
     

    }

  }

