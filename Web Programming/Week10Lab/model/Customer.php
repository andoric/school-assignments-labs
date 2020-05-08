<?php
	class Customer{
		private $customerName;
		private $emailAddress;
        private $phoneNumber;
		private $referrer;
		private $id;
		private $deletedCustomerNames;
		
		function __construct($id, $customerName, $emailAddress, $phoneNumber, $referrer, $deletedCustomerNames){
			$this->setId($id);
			$this->setCustomerName($customerName);
			$this->setEmailAddress($emailAddress);
            $this->setPhoneNumber($phoneNumber);
			$this->setReferrer($referrer);
			$this->setDeletedCustomerNames($deletedCustomerNames);
		}

		public function getId(){
			return $this->id;
		}
		public function setId($id){
			$this->id = $id;
		}

		
		public function getCustomerName(){
			return $this->customerName;
		}
		
		public function setCustomerName($customerName){
			$this->customerName = $customerName;
		}
		
		public function getEmailAddress(){
			return $this->emailAddress;
		}
		
		public function setEmailAddress($emailAddress){
			$this->emailAddress = $emailAddress;
		}
		
		public function getPhoneNumber(){
			return $this->phoneNumber;
		}
		
		public function setPhoneNumber($phoneNumber){
			$this->phoneNumber = $phoneNumber;
        }
        public function getReferrer(){
			return $this->referrer;
		}
		
		public function setReferrer($referrer){
			$this->referrer = $referrer;
		}
		public function getDeletedCustomerNames(){
			return $this->deletedCustomerNames;
		}
		public function setDeletedCustomerNames($deletedCustomerNames){
			$this->deletedCustomerNames=$deletedCustomerNames;
		}
		
	}
?>