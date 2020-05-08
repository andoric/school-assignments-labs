<?php require_once('./dao/CustomerDAO.php');?> 
<!DOCTYPE php>
<html>
<!--header.php starts here-->

<?php include 'header.php';?>
<script type="text/javascript">
    function confirmDelete(id, customerName){
        return confirm("Do you wish to delete id#"+id+" "+ customerName + "?");
    }
</script>

    
			<!--header.php ends-->
            <div id="content" class="clearfix">
            
                <aside>
                <h2>Mailing Address</h2>
                        <h3>1385 Woodroffe Ave<br>
                            Ottawa, ON K4C1A4</h3>
                        <h2>Phone Number</h2>
                        <h3>(613)727-4723</h3>
                        <h2>Fax Number</h2>
                        <h3>(613)555-1212</h3>
                        <h2>Email Address</h2>
                        <h3>info@wpeatery.com</h3>
                </aside>
                <div class= "main">
                <h1>Mailing List</h1>
                <p>
                <?php session_start();
                try{
                    $customerDAO = new CustomerDAO();
                    $customers = $customerDAO->getCustomers('SELECT * FROM mailinglist where deletedCustomerNames="na"');
                    if($customers){
                        echo '<table>';
                        echo '<tr><th>Name</th><th>Email</th><th>Phone Number</th><th>Referrer</th><th>Delete</th></tr>';
                        foreach($customers as $customer){
                        echo '<tr>';
                        echo '<td>'. $customer->getCustomerName() . '</td>';
                        echo '<td>' . $customer->getEmailAddress() . '</td>';
                        echo '<td>' . $customer->getPhoneNumber() . '</td>';
                        echo '<td>' . $customer->getReferrer() . '</td>';
                        echo '<td>
                        <a onclick="return confirmDelete(\''.$customer->getId().'\',\''.$customer->getCustomerName().'\')"
                            href="removeCustomer.php?action=delete&_id='. $customer->getId() .'">
                            <input style=\'width:100%\' type=\'button\' value=\'Delete\'></a>
                        </td>';
                        echo '</tr>';
                        }
                        echo '</table>';

                    }

                }catch(Exception $e){
                    echo '<h3>Error on page.</h3>';
                    echo '<p>' . $e->getMessage() . '</p>';
                }



                ?>
                </p>
                <?php 
                    if(isset($_SESSION['deleted']) && $_SESSION['deleted'] != ''){
                        echo '<h3>'.$_SESSION['deleted'].'</h3>';
                        unset($_SESSION['deleted']);
                    }
                    
                    
                    ?>

               </div>
            </div><!-- End Content -->
            <?php include 'footer.php';?>
            <!-- End Wrapper  this dv is included in footer.php-->
    </body>
    
</html>