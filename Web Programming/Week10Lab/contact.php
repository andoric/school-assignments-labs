<!DOCTYPE php>
<html>
    <body>
    <?php session_start();
     include 'header.php';?>
   
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
                <div class="main">
                    <h1>Sign up for our newsletter</h1>
                    <p>Please fill out the following form to be kept up to date with news, specials, and promotions from the WP eatery!</p>
                    <form name="frmNewsletter" id="frmNewsletter" method="post" action="newsletterSignup.php">
                        <table>
                            <tr>
                                <td>Name:</td>
                                <td><input type="text" name="customerName" id="customerName" size='40'>
                                <?php
                                if(isset($_SESSION['nameErr']) && $_SESSION['nameErr'] != ''){
                                    echo '<span style=\'color:red\'>'.$_SESSION['nameErr'].'</span>';
                                    unset($_SESSION['nameErr']);
                                } ?>
                                </td>
                            </tr>
                            <tr>
                                <td>Phone Number:</td>
                                <td><input type="text" name="phoneNumber" id="phoneNumber" size='40'>
                                <?php
                                if(isset($_SESSION['phoneErr']) && $_SESSION['phoneErr'] != ''){
                                    echo '<span style=\'color:red\'>'.$_SESSION['phoneErr'].'</span>';
                                    unset($_SESSION['phoneErr']);
                                } ?>
                                </td>
                            </tr>
                            <tr>
                                <td>Email Address:</td>
                                <td><input type="text" name="emailAddress" id="emailAddress" size='40'>
                                <?php
                                if(isset($_SESSION['emailErr']) && $_SESSION['emailErr'] != ''){
                                    echo '<span style=\'color:red\'>'.$_SESSION['emailErr'].'</span>';
                                    unset($_SESSION['emailErr']);
                                } ?>
                                </td>
                            </tr>
                            <tr>
                                <td>How did you hear<br> about us?</td>
                                <td>Newspaper<input type="radio" name="referral" id="referralNewspaper" value="newspaper">
                                    Radio<input type="radio" name='referral' id='referralRadio' value='radio'>
                                    TV<input type='radio' name='referral' id='referralTV' value='TV'>
                                    Other<input type='radio' name='referral' id='referralOther' value='other'>
                                <?php
                                if(isset($_SESSION['referErr']) && $_SESSION['referErr'] != ''){
                                    echo '<span style=\'color:red\'>'.$_SESSION['referErr'].'</span>';
                                    unset($_SESSION['referErr']);
                                } ?>    
                                </td>
                            </tr>
                            <tr>
                                <td colspan='2'><input type='submit' name='btnSubmit' id='btnSubmit' value='Sign up!'>&nbsp;&nbsp;<input type='reset' name="btnReset" id="btnReset" value="Reset Form"></td>
                            </tr>
                        </table>
                    </form>
                    <?php 
                    if(isset($_SESSION['success']) && $_SESSION['success'] != ''){
                        echo '<h3>'.$_SESSION['success'].'</h3>';
                        unset($_SESSION['success']);
                    }
                    
                    
                    ?>

                </div><!-- End Main -->
            </div><!-- End Content -->
            <?php include 'footer.php';?>
            <!-- End Wrapper -->
    </body>
</html>
