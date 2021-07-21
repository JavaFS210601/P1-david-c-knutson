const url ='http://localhost:8083/P1-david-c-knutson/' //I grabbed this base URL from postman
//http://localhost:8083/P1Demo/login
//it's also what shows up when you run as server and get your 404 page
 
 
  function previousFunction() {
    var x = document.getElementById("previous");
    var y = document.getElementById("newticket");
     
    if (x.style.display === "none") {
      x.style.display = "block";
      y.style.display = "none";
      
    } else {
      x.style.display = "none";
    }
  }

  function newFunction() {
    var x = document.getElementById("newticket");
    var y = document.getElementById("previous");
     
    if (x.style.display === "none") {
      x.style.display = "block";
      y.style.display = "none";
       

    } else {
      x.style.display = "none";
    }
  }
    

//add functionality to our button using an event listener
  
 
// -----------------------------------expense by emp--------------------------

document.getElementById("getExpenseButton").addEventListener('click', expenseFunc);
 
async function expenseFunc() { //async returns a promise (which fetch returns)
  var rem_nm;
  var loop=0;
  var prevbutton=0;
     
  
   

    let response2 = await fetch(url + 'users');
    if(response2.status === 200) { //if the request is successful...
      console.log("response",response2); //just to see what comes back for debug
       
      let data2 = await response2.json();
      let rem_id2 = document.getElementById("empid3").value;
      for(let usm of data2) { 
         if(rem_id2 == usm.ers_users_id){
           rem_nm = usm.ers_username;
            
           loop = 1;
         }
        
      }
       
      if(loop == 0) {
         
        document.getElementById("empwarn3").style.display = "block";
        document.getElementById("empwarn3").style="background-color:yellow";
        document.getElementById("empwarn3").innerHTML = "Invalid Employee ID please try again";
   
      }else { 
         
        document.getElementById("empwarn3").style.display = "none";
      }
    }
    
    let response = await fetch(url + 'expenses');

    if(response.status === 200) { //if the request is successful...
        console.log(response); //just to see what comes back for debug

        let data = await response.json(); //get the JSON data from the response, turn it into JS object
        

         
        for(let expense of data) {  

            

            let rem_id2 = document.getElementById("empid3").value; 
             

            if (expense.reimb_author == rem_id2){  // filter to user only
             
              console.log("113 id",expense.reimb_id2)
              console.log("114 author",expense.reimb_author)
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
              cell6.innerHTML = rem_nm; 
              //cell6.innerHTML = expense.reimb_author;  
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

}

//---------------------------------------new area--------------------------------------------------------------
 

 

  //get the user inputs for the login
  

  document.getElementById("getNewButton").addEventListener('click', newFunc);
 
async function newFunc() { //async returns a promise (which fetch returns)

  var rem_nm;
   
  var inloop = 0;
  var prevbutton=0;
    //we will send a fetch request to get our avenger data
    //await wmakes the async functions wait until the promise returns with the fetched data
  console.log("65 here");
   
  while(inloop == 0){
    let response2 = await fetch(url + 'users');
    if(response2.status === 200) { //if the request is successful...
      console.log("response",response2); //just to see what comes back for debug
      
      let data2 = await response2.json();
      let rem_id2 = document.getElementById("empid").value;
      for(let usm of data2) { 
         if(rem_id2 == usm.ers_users_id){
           rem_nm = usm.ers_username;
           console.log("78 somebody",rem_nm);
            
          inloop = 1;
         
        }
      } 
      if(inloop == 0) {
        console.log("84 user not found");
        document.getElementById("empwarn").style.display = "block";
        document.getElementById("empwarn").style="background-color:yellow";
        document.getElementById("empwarn").innerHTML = "Invalid Employee ID please try again";
        break;
      } else {
        console.log("id good")
        inloop = 1;
        document.getElementById("empwarn").style.display = "none";
      }
     
 
      let tstamt = document.getElementById("amount").value;
      if (isNaN(tstamt)) {
        console.dir("its not a number")
        inloop = 0;
        document.getElementById("amtwarn").style.display = "block";  
        document.getElementById("amtwarn").style="background-color:yellow";
        document.getElementById("amtwarn").innerHTML = "Invalid amount please try again";
          
        break;
      }else {
        console.log("number ok")
        inloop = 1;
        document.getElementById("amtwarn").style.display = "none";
      }
      document.getElementById("subbed").style.display = "block";
      document.getElementById("subbed").style="background-color:lightgreen";
      document.getElementById("subbed").innerHTML = "Expense Submitted";        
    }
  }
    let reimb_id = document.getElementById("empid").value; //gather the user's amount (the value)
    
    let reimb_amount = document.getElementById("amount").value; //gather the user's amount (the value)
    let reimb_submitted = "2021-07-14";
    let reimb_resolved = "2021-07-14";
    let reimb_description = document.getElementById("description").value; //gather the user's description (the value)
    let reimb_author = document.getElementById("empid").value;
    let reimb_resolver = "1";
    let reimb_status_id = "1";
    var reimb_type_id = "0";
    let tempv = document.getElementById("favourite").value;
    if(tempv == "Food"){
      reimb_type_id = "1";
    }else if(tempv == "Airfare"){
      reimb_type_id = "2";
    }else if(tempv == "Lodging"){
      reimb_type_id = "3";
    }else if(tempv == "Transportation"){
      reimb_type_id = "4";
    }else if(tempv == "Other"){
      reimb_type_id = "5";
    }else {reimb_type_id = "5"; }

    console.log("265 tempv",tempv);
    console.log("278 type",reimb_type_id);
    //reimb_type_id = document.getElementById("typeid").value; //gather the user's type (the value)
 
    
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

  console.log(response.status);  
     
  if(response.status === 200) {
     

        let data = await response.json(); //get the JSON data from the response, turn it into JS object
        
    
        document.getElementById("newticket").style.display = "block"; 
        
        let response = await fetch(url + 'expenses');
    
        if(response.status === 200) { //if the request is successful...
            console.log(response); //just to see what comes back for debug
    
            let data = await response.json(); //get the JSON data from the response, turn it into JS object
             
           for(let expense of data) { 
     
    
                let rem_id2 = document.getElementById("empid2").value; 
                 
    
                if (expense.reimb_author == rem_id2){  // filter to user only  362
                //if(expense.reimb_author == "janedoe") {  
                  console.log("113 id",expense.reimb_id2)
                  console.log("114 author",expense.reimb_author)
                  let row = document.createElement("tr"); //create a table row
    
                  let cell = document.createElement("td"); //create a cell for the field
                  //cell.innerHTML = rem_nm;
                  cell.innerHTML = reimb_id; //fill the cell with expense data
                  row.appendChild(cell); //this row now has the first cell (rem_id)
                   
                  let cell2 = document.createElement("td"); //create a cell for the field
                  cell2.innerHTML = reimb_amount; //fill the cell with expense data
                  row.appendChild(cell2); //this row now has the second cell (expense.reimb_amount)
    
                  let cell3 = document.createElement("td");  
                  cell3.innerHTML = reimb_submitted;  
                  row.appendChild(cell3);  
    
                  let cell4 = document.createElement("td");  
                  cell4.innerHTML = reimb_resolved;  
                  row.appendChild(cell4); 
    
                  let cell5 = document.createElement("td"); 
                  cell5.innerHTML = reimb_description;  
                  row.appendChild(cell5); 
    
                  let cell6 = document.createElement("td");
                  cell6.innerHTML = rem_nm; 
                  //cell6.innerHTML = expense.reimb_author;  
                  row.appendChild(cell6); 
    
                  let cell7 = document.createElement("td");
                  if(reimb_resolver== 1){
                    resolvername = "John Smith";
                    cell7.innerHTML = resolvername;
                  }else{
                    resolvername = "Not Reviewed";
                    cell7.innerHTML = resolvername;
                  }
                  
                  //cell7.innerHTML = expense.reimb_resolver;  
                  row.appendChild(cell7);
    
    
    
                  let cell8 = document.createElement("td"); 
                  if(reimb_status_id == 1){
                    
                    statusname = "Submitted";
                    cell8.innerHTML = statusname;
                  }else if(reimb_status_id == 2) {
                    statusname = "Under Review";
                    cell8.innerHTML = statusname;
                    //cell8.innerHTML = expense.reimb_status_id;
                  }else if(reimb_status_id == 3) {
                    statusname = "Accepted";
                    cell8.innerHTML = statusname;
                  }else{
                    statusname = "Declined";
                    cell8.innerHTML = statusname;
                  }
                  //cell8.innerHTML = expense.reimb_status_id;  
                  row.appendChild(cell8);
    
                  let cell9 = document.createElement("td"); 
                  if(reimb_type_id == 1){
                     
                    statusname = "Food";
                    cell9.innerHTML = statusname;
                  }else if(reimb_type_id == 2) {
                    statusname = "Airfare";
                    cell9.innerHTML = statusname;
                    //cell8.innerHTML = expense.reimb_status_id;
                  }else if(reimb_type_id == 3) {
                    statusname = "Lodging";
                    cell9.innerHTML = statusname;
                  }else if(reimb_type_id == 4) {
                    statusname = "Transportation";
                    cell9.innerHTML = statusname;
                  }else{
                    statusname = "Other";
                    cell9.innerHTML = statusname;
                  }
                  //cell8.innerHTML = expense.reimb_status_id;  
                  row.appendChild(cell9);
      
                  
    
               
    
    
                  document.getElementById("newBody").appendChild(row);
                   
                }
            }
            
             



        }
      }  
      
      } 
     
       
    