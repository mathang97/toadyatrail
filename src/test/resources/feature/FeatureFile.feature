Feature: Test the adactin page
  
  Scenario Outline: check whether page is login or not
    Given user is on adactin page
    When user should enter "<username>" and "<password>"
     Then user should click the login button
     And serach select hotel"<location>","<hotel>","<roomtype>","<roomnum>","<indate>","<outdate>","<adult>","<child>" and search the hotel
     Then  select hotel select and click
     Then book the hotel"<Fname>","<lname>","<address>","<cardno>","<cardtype>","<expdate>","<expyear>","<cvvnum>" and click
     And  get the order id 


Examples:
|username|password|location|hotel|roomtype|roomnum|indate|outdate|adult|child|Fname|lname|address|cardno|cardtype|expdate|expyear|cvvnum|
|karthi007|Karthi@1989|Melbourne|Hotel Creek|Double|2 - Two|08/05/2021|10/05/2021|2 - Two|0 - None|Mathan|g|chennai|1234567891234567|VISA|March|2022|1234|
|karthi007|Karthi@1989|Melbourne|Hotel Creek|Double|2 - Two|08/05/2021|10/05/2021|2 - Two|0 - None|Mathan|g|chennai|1234567891234567|VISA|March|2022|1234|    
