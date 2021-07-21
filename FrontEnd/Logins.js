const url ='http://localhost:8083/P1-david-c-knutson/' //I grabbed this base URL from postman


document.getElementById("loginButton").addEventListener('click', loginFunc);
console.log("am i here 5")

async function loginFunc(){
    console.log("am i here 8")
    let response2 = await fetch(url + 'users');
    if(response2.status === 200) { 
        console.log(response2); 
         
        let data2 = await response2.json();
        
        let unamevalid = "no";
        let upassvalid = "no";
        let notlogged = true;
         
        while(notlogged = true){
            uname = document.getElementById("username").value;
            pwrd = document.getElementById("password").value;
            rolid = 1;
            for(let usm of data2) {  
                console.log(usm.ers_username);
                if(uname == usm.ers_username){
                    let usr_nam = usm.ers_username;
                    console.log(usr_nam);
                    unamevalid = "yes";
                
            
                    for(let usm of data2) {   
                        if(pwrd == usm.ers_password){
                            usr_pas = usm.ers_password;
                            console.log(usr_pas);
                            upassvalid = "yes";
                            rolid = usm.user_role_id;
                        }
                    
                    }
                    break;
                }

            }
            console.log(unamevalid,upassvalid);
            if (unamevalid == "yes" & upassvalid == "yes"){
                document.getElementById("msg2").style.display = "none";
                console.log("login success");
                console.log(rolid);
                
                if(rolid == 1){
                    console.log("fin mgr");
 
                    
                    document.getElementById("scheduler").style.display = "block";
                    document.getElementById("scheduler").innerHTML = "Do you want to submit or review expenses?";

                    document.getElementById("opt1").style.display = "block";
                    
                   const btn = document.querySelector('#btn');
                    // handle button click
                    btn.onclick = function () {
                        
                        var button1 = document.getElementById("navRadio01");
                        var button2 = document.getElementById("navRadio02");
                    
                        

                        if (button1=true){
                            window.location.href = "http://127.0.0.1:5500/DKP1Front/empnew.html";
                            
                        }
                        if (button2.checked){
                            window.location.href = "http://127.0.0.1:5500/DKP1Front/mannew.html"
                        }
                    }
                     
                }else {
                     
                    document.getElementById("scheduler").style.display = "block";
                    document.getElementById("scheduler").innerHTML = "Click submit";
                    document.getElementById("opt2").style.display = "block";
                    
                    const btn = document.querySelector('#btn');
                    // handle button click
                    btn.onclick = function () {
                         
                        var button1 = document.getElementById("navRadio01");
                         
                    
                        

                        if (button1=true){
                            window.location.href = "http://127.0.0.1:5500/DKP1Front/empnew.html";
                            
                        }
                         
                    }
                    console.log("emp");
                    window.location.href = "http://127.0.0.1:5500/DKP1Front/empnew.html";
                }
                
                //break;

            }else{
                console.log("login failed")
                document.getElementById("msg2").style.display = "block";
                 
                document.getElementById("msg2").style="background-color:yellow";
                
                document.getElementById("msg2").innerHTML = "Invalid User Id please try again";
                 
                break;
            }
    }
        }
         
       
         

    }
 





