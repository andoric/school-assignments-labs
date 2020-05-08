<?php require_once("./dao/CustomerDAO.php");?>
<!DOCTYPE php>
<html>
<?php include 'header.php';?>
    <?php session_start();
    try{
        $emailPattern = "/^[\w\.]+@[\w]+\.[a-zA-Z]{2,5}$/";
        $phonePattern = "/^\(?[\d]{3}\)?[- ]?[\d]{3}[- ]?[\d]{4}$/";
        $CustomerDAO = new CustomerDAO();
        $error = false;
        if (isset($_POST['customerName']) ||
            isset($_POST['emailAddress']) ||
            isset($_POST['phoneNumber']) ||
            isset($_POST['referral'])  ){
                if(!$CustomerDAO->checkEmail($_POST['emailAddress'])){
                    $error=true;
                    $_SESSION['emailErr'] = 'This email address already exists';
                }
                if($_POST['customerName']===""){
                    $error=true;
                    $_SESSION['nameErr'] = 'Please enter a name';
                }
                if ($_POST['emailAddress']===""||preg_match($emailPattern, $_POST['emailAddress'])===0){
                    $error=true;
                    $_SESSION['emailErr'] = 'Please enter an appropriate email address';
                }
                if ($_POST['phoneNumber']===""||preg_match($phonePattern, $_POST['phoneNumber'])===0){
                    $error=true;
                    $_SESSION['phoneErr'] = 'Please enter an appropriate phone number';
                }
                if(!isset($_POST['referral'])){
                    $error=true;
                    $_SESSION['referErr'] = 'Please select referral type';
                
                }
                if(!$error){
                    $customer = new Customer($row['id'], $_POST['customerName'], $_POST['emailAddress'], $_POST['phoneNumber'], $_POST['referral'], "na");
                    $dbAddSuccess = $CustomerDAO->addCustomer($customer);
                    $_SESSION['success'] = $dbAddSuccess;
                }
                header("location: ./contact.php");
                
                
            }
    }catch(Exception $e){
        
        $_SESSION['success']=$e->getMessage();
    }
    
    ?>
    <?php include 'footer.php'?>
    </html>