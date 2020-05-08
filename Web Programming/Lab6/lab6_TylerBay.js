  
var calculatedTotal=0

document.getElementById("orderForm").addEventListener("submit", function(e){
    if(!validateForm()){
        e.preventDefault()
    }else{
        window.alert(`Your order total is $${calculatedTotal}. \nYour order has been successfully submitted.`)
        document.forms["orderForm"].submit()
    }    
})

function validateForm(){
    calculatedTotal=0
    var error = false
    var inputArray=document.getElementsByTagName("input")  

    for (var i=0;i<6;i++){

        if (inputArray[i].value === ""){
             error =true
            window.alert(`Please enter a value for ${inputArray[i].name}`)
                                                
        }                            

    }
    for(var i =5;i<11;i++){
                    
        if(parseInt(inputArray[i].value)<0||isNaN(parseInt(inputArray[i].value))){
            error=true
            window.alert(`value for ${inputArray[i].name} must be a whole number greater than or equal to zero.`)
        }

    }
    for(var i=5;i<11;i+=2){
        if(parseInt(inputArray[i].value)<1||isNaN(parseInt(inputArray[i].value))){
            error=true
            window.alert(`You must order at least one of ${inputArray[i].name}`)
        }
                

    }
            

    if(!error){
        calculatedTotal+=(parseInt(inputArray[5].value))*5.00
        calculatedTotal+=(parseInt(inputArray[6].value))*15.00
            for(var i =7;i<11;i++){

                calculatedTotal+=(parseInt(inputArray[i].value))*25.00
            }
        if(inputArray[11].checked){
            calculatedTotal+=5.00
        }else if(inputArray[12].checked){
            calculatedTotal+=10.00
        }else if(inputArray[13].checked){
            calculatedTotal+=20.00
        }    
        console.log(calculatedTotal)

        return true

    }else 
        return false    
}