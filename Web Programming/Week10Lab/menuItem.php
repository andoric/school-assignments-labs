<?php
class menuItem{
    private $itemName;
    private $description;
    private $price;
    function __construct($itemName, $description, $price){
        $this->itemName = $itemName;
        $this->description = $description;
        $this->price = $price;
    }
    function getItemName(){
        return $this->itemName;
    }
    function getDescription(){
        return $this->description;
    }
    function getPrice(){
        return $this->price;
    }
}
?>
