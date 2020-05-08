<?php
function findOddEven(){
    $evenString="";
    $oddString="";
    $inputNum= $_POST['num'];
    if (!ctype_digit($inputNum)){ //checks to see if all values in $inputNum are digits
        echo "Error: please enter a whole number.";
    }else if($inputNum<4||$inputNum>100){
        echo "Error: number must be between 4 and 100";

    }else{
   
    for($i=0;$i<=$inputNum;$i++){
        $is_odd=$i&1; //bitwise and operator to check end bit, returns true if bit is 1.
        

        if ($is_odd&&$inputNum-$i>1){
            $oddString.= $i . ", ";
        }else if($is_odd&&$i<=$inputNum){
            $oddString.= $i;
            

        }else if (!$is_odd&&$inputNum-$i>1){
            $evenString.=$i . ", ";
        }else if(!$is_odd&&$i<=$inputNum){
            $evenString.= $i;
    }
 }
 echo "The number you entered was " . $inputNum;
 echo "<br />";
 echo "The even number are: ";
 echo $evenString;
 echo "<br />";
 echo "The Odd numbers are: ";
 echo $oddString;

}
}

?>


<!DOCTYPE html>
<html>
    <head>
        <title>PHP to find Odd or Even number!</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
    </head>
    <body>
			<form action="" method="post">
	        <div style="margin-top: 10px;" id="result">
             <h2>PHP to find Odd or Even number!</h2>
				Enter a number:  <input type="text" id="num" name="num" value="0" />
			<input type="submit" name="btn" value="find Odd or Even number">
            </div>
			
			
<?php
if(isset($_POST['btn']))
{    
    findOddEven();
}  

?>
    </form>    
    </body>
</html>