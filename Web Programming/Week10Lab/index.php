<!DOCTYPE php>
<html> 
<!--header.php starts here-->

<?php include 'header.php';?>

			<!--header.php ends-->
            <div id="content" class="clearfix">
                <aside>
                        
                        <?php 
                        echo "<h2>" .date('l')."'s Specials</h2>";
                        function getDateIndex(){
                            $daysWeek = array ("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday");                           
                            for($i=0;$i<7;$i++){
                                if(date('l')===$daysWeek[$i])
                                return $i;
                            }
                        }
                        function writeSpecial(){
                            $todayIndex = getDateIndex();
                            include 'menuItem.php';
                            $i=0;
                            $menuItems=[];
                            $isOdd=$i&1;
                            while($i<6){
                                if(!$isOdd){
                                    $menuItems[$i]=new menuItem("The WP Burger", "Freshly made all-beef patty served up with homefries", "$14");
                                }else $menuItems[$i]=new menuItem("WP Kebobs", "Tender cuts of beef and chicken, served with your choice of side", "$17");
                            $i++;
                            }

                            $isEven = $todayIndex&0;
                            $specialName = $menuItems[$todayIndex]->getItemName();
                            $specialDesc = $menuItems[$todayIndex]->getDescription();
                            $specialPrice = $menuItems[$todayIndex]->getPrice();
                            if ($todayIndex === 6){
                                echo "<h3>We're Closed " .date('l')."s!</h3>";
                            }else{
                                if($isEven){
                                    echo "<img src='images/kebobs.jpg' alt='Kebobs' title='WP Kebobs'>";
                                                                        
                                }else{
                                    echo "<img src='images/burger_small.jpg' alt='Burger' title='WP Burger'>";
                                   
                                }
                                echo "<h3>" . $specialName ."</h3>";
                                echo "<p>". $specialDesc . " - ". $specialPrice ."</p>";

                            }
                           
                        }


                        echo "<hr>";
                        writeSpecial();?>

                </aside>
                <div class="main">
                    <h1>Welcome</h1>
                    <img src="images/dining_room.jpg" alt="Dining Room" title="The WP Eatery Dining Room" class="content_pic">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
                    <h2>Book your Christmas Party!</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
                </div><!-- End Main -->
            </div><!-- End Content -->
           <?php include 'footer.php';?>
            <!-- End Wrapper  this dv is included in footer.php-->
    </body>
</html>
