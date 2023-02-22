var transaction = []    //Array that stores transaction amounts
var cnt = 0;    //Keep count of transactions 
var debCnt = 0; //Count the number of debit transactions
let history;//Variable to store inner html data

function limit(){
    let amt = document.forms['lim'].amount.value;
    document.forms['lim'].amount.value = "";
    transaction[cnt] = +amt;    //Pushing the amount to the array
    
    if(cnt==0){ //1st transaction
        alert(amt +" CREDIT.");
        history = "<tr class='bg-success-subtle'><td>"+amt+"</td><td>CREDIT</td></tr>";
    }
    if(cnt>0)
    {
        //Checking if the current transaction amount is less than the previous one
        if(transaction[cnt]<=transaction[cnt-1])
        {
            //Checking if the number of debit transactions have crossed 3
            if(debCnt>2)
            {
                if(confirm("Warning!!! DEBIT LIMIT reached\nEXTRA CHARGES now is Rs.20")==true)
                {
                    alert(amt+" DEBIT")
                    history = "<tr class='bg-danger-subtle'><td>"+amt+"</td><td>DEBIT</td></tr>";
                    debCnt += 1;
                }
                else
                {
                  alert("Transaction cancelled.")
                  history = "";
                  transac.pop();  //Removing the last transaction, since its cancelled
                }
            }
            else
            {
                alert(amt+" debited.")
                history = "<tr class='bg-danger-subtle'><td>"+amt+"</td><td>DEBIT</td></tr>";
                debCnt += 1;
            }   
        }
        else
        {
            alert(amt +" credited.")
            history = "<tr class='bg-success-subtle'><td>"+amt+"</td><td>CREDIT</td></tr>";
        }
    }
    //Writing the history to the html
    document.getElementById("thist").innerHTML += history;
    cnt += 1;
}