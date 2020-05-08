<?php require_once('./dao/CustomerDAO.php');?> 
<!DOCTYPE php>
<html>
<!--header.php starts here-->

<?php include 'header.php';?>


    
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
                <h1>Removed Customers List</h1>
                <p>
                <?php session_start();
                try{
                    $CustomerDAO = new CustomerDAO();
                    $customers = $CustomerDAO->getCustomers('SELECT * FROM mailinglist where deletedCustomerNames!="na"');
                    if($customers){
                        echo '<table>';
                        echo '<tr><th>Name</th><th>Email</th><th>Phone Number</th></tr>';
                        foreach($customers as $customer){
                            $values = explode(",",$customer->getDeletedCustomerNames());
                        echo '<tr>';
                        echo '<td>'. $values[0] . '</td>';
                        echo '<td>' . $values[1] . '</td>';
                        echo '<td>' . $values[2] . '</td>';
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
               

               </div>
            </div><!-- End Content -->
            <?php include 'footer.php';?>
            <!-- End Wrapper  this dv is included in footer.php-->
    </body>
    
</html>