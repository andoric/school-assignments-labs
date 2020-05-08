<?php require_once("./dao/CustomerDAO.php");?>
<!DOCTYPE php>

    <?php session_start();
    try{
        if($_GET['action']=='delete'){
            if(isset($_GET['_id'])){
                $CustomerDAO = new CustomerDAO();
                $result = $CustomerDAO->deleteCustomer($_GET['_id']);
                echo $result;
                if($result){
                    $_SESSION['deleted'] = "Deletion Successful";            

                    header('location:mailing_list.php?deleted=true');
                }else{
                    $_SESSION['deleted'] = "Deletion was not successful";
                    header('location:mailing_list.php?deleted=false');
                } 

            }
        }
        




    }catch(Exception $e){
        //If there were any database connection/sql issues,
        //an error message will be displayed to the user.
        echo '<h3>Error on page.</h3>';
        echo '<p>' . $e->getMessage() . '</p>';            
    }
    ?>