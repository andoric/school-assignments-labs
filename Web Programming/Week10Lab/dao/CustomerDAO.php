<?php
require_once('abstractDAO.php');
require_once('./model/Customer.php');
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Description of CustomerDAO
 *
 * @author Tyler
 */
class CustomerDAO extends abstractDAO {
        
    function __construct() {
        try{
            parent::__construct();
        } catch(mysqli_sql_exception $e){
            throw $e;
        }
    }
    
    /*
     * This is an example of how to use the query() method of a mysqli object.
     * 
     * Returns an array of <code>Customer</code> objects. If no list exist, returns false.
     */
    public function getCustomers($queryValue){
        //The query method returns a mysqli_result object
        $result = $this->mysqli->query($queryValue);
        $customers = Array();
        
        if($result->num_rows >= 1){
            while($row = $result->fetch_assoc()){
                //Create a new customer object, and add it to the array.
                $customer = new Customer($row['_id'], $row['customerName'], $row['emailAddress'], $row['phoneNumber'], $row['referrer'], $row['deletedCustomerNames']);
                $customers[] = $customer;
            }
            $result->free();
            return $customers;
        }
        $result->free();
        return false;
    }
    
    /*
     * This is an example of how to use a prepared statement
     * with a select query.
     */
    public function getCustomer($id){
        $query = 'SELECT * FROM mailinglist WHERE _id = ?';
        $stmt = $this->mysqli->prepare($query);
        $stmt->bind_param('i', $id);
        $stmt->execute();
        $result = $stmt->get_result();
        if($result->num_rows == 1){
            $temp = $result->fetch_assoc();
            $customer = new Customer($temp['_id'], $temp['customerName'], $temp['emailAddress'], $temp['phoneNumber'], $temp['referrer'], $temp['deletedCustomerNames']);
            $result->free();
            return $customer;
        }
        $result->free();
        return false;
    }

    public function checkEmail($email){
        $query = 'SELECT * FROM mailinglist WHERE emailAddress = ? AND deletedCustomerNames = "na"';
        $stmt = $this->mysqli->prepare($query);
        $stmt->bind_param('s', $email);
        $stmt->execute();
        $result = $stmt->get_result();
        if($result->num_rows == 0){
            $result->free();
            return true;
        }
        $result->free();
        return false;
    }

    public function addCustomer($customer){
        if(!$this->mysqli->connect_errno){
            //The query uses the question mark (?) as a
            //placeholder for the parameters to be used
            //in the query.
            $query = 'INSERT INTO mailinglist(_id, customerName, emailAddress, phoneNumber, referrer, deletedCustomerNames) VALUES (?,?,?,?,?,?)';
            //The prepare method of the mysqli object returns
            //a mysqli_stmt object. It takes a parameterized 
            //query as a parameter.
            $stmt = $this->mysqli->prepare($query);
            //The first parameter of bind_param takes a string
            //describing the data.
            //The string contains a one-letter datatype description
            //for each parameter. 'i' is used for integers, and 's'
            //is used for strings.
            $stmt->bind_param('isssss', 
                    $customer->getId(),
                    $customer->getCustomerName(), 
                    $customer->getEmailAddress(), 
                    $customer->getPhoneNumber(),
                    $customer->getReferrer(),
                    $customer->getDeletedCustomerNames());
            //Execute the statement
            $stmt->execute();
            //If there are errors, they will be in the error property of the
            //mysqli_stmt object.
            if($stmt->error){
                return $stmt->error;
            } else {
                return $customer->getCustomerName() . ' added successfully!';
            }
        } else {
            return 'Could not connect to Database.';
        }
    }
    
    public function deleteCustomer($id){
        if(!$this->mysqli->connect_errno){
            $old = $this->getCustomer($id);
            $old->setDeletedCustomerNames($old->getCustomerName().','.$old->getEmailAddress().','.$old->getPhoneNumber());
            $old->setId(0);
            $this->addCustomer($old);

            $query = 'DELETE FROM mailinglist WHERE _id = ?';
            $stmt = $this->mysqli->prepare($query);
            $stmt->bind_param('i', $id);
            $stmt->execute();
            if($stmt->error){
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    
}

?>
