@tag
Feature:As admin user validate supplers and customers Functionlaities
@suppliers
Scenario Outline:
Validate suppler with multiple data
Given launch browser
When launch url in a browser
And Wait for username with "name" and "username"
And Enter Username with "name" and "username" and "admin"
And Enter password with "xpath" and "//input[@id='password']" and "master"
And click Login button with "xpath" and "//button[@id='btnsubmit']"
And Wait for logout link with "xpath" and "(//a[starts-with(text(),' Logout')])[2]"
Then Verify page title with "Dashboard « Stock Accounting"
When Wait  for suppliers link with "xpath" and "(//*[text()='Suppliers'])[2]"
When Click Suppliers link with "xpath" and "(//*[text()='Suppliers'])[2]"
When Wait for Add + icon with "xpath" and "(//span[@data-caption='Add'])[1]"
When Click Add + icon with "xpath" and "(//span[@data-caption='Add'])[1]"
When Wait for Supplier Number with "name" and "x_Supplier_Number"
When Capture Supplier number with "name" and "x_Supplier_Number"
When Enter in "<SupplierName>" with "id" and "x_Supplier_Name" 
When Enter in "<address>" with "xpath" and "//*[@id='x_Address']" 
When Enter in "<city>" with "xpath" and "//*[@id='x_City']" 
When Enter in "<country>" with "xpath" and "//*[@id='x_Country']" 
When Enter in "<cperson>" with "xpath" and "//*[@id='x_Contact_Person']" 
When Enter in "<pnumber>" with "xpath" and "//*[@id='x_Phone_Number']" 
When Enter in "<mail>" with "xpath" and "//*[@id='x__Email']" 
When Enter in "<mnumber>" with "xpath" and "//*[@id='x_Mobile_Number']" 
When Enter in "<note>" with "xpath" and "//*[@id='x_Notes']" 
When Click Add button with "id" and "btnAction"
When Wait for confirm Ok button with "xpath" and "//button[normalize-space()='OK!']"
When Click Confirm ok button with "xpath" and "//button[normalize-space()='OK!']"
When Wait for alert ok button with "xpath" and "(//button[starts-with(text(),'OK')])[6]"
When Click Alert ok button with "xpath" and "(//button[starts-with(text(),'OK')])[6]"
Then Verify Supplier Table
When Close App Browser
Examples:
|SupplierName|address|city|country|cperson|pnumber|mail|mnumber|note|
|tatasupplier1|Ammerpet1|Hyderbad|India|Qedge|234567895|Test@gmail.com|876543212|Iam new supplier|
|tatasupplier3|Ammerpet31|Hyderbad|India|Qedge|234567895|Test@gmail.com|876543212|Iam new supplier|
|tatasupplier51|Ammerpet61|Hyderbad|India|Qedge|234567895|Test@gmail.com|876543212|Iam new supplier|
|tatasupplier11|Ammerpet51|Hyderbad|India|Qedge|234567895|Test@gmail.com|876543212|Iam new supplier|
|tatasupplier31|Ammerpet21|Hyderbad|India|Qedge|234567895|Test@gmail.com|876543212|Iam new supplier|
|tatasupplier31|Ammerpet21|Hyderbad|India|Qedge|234567895|Test@gmail.com|876543212|Iam new supplier|
@Customers
Scenario Outline:
validate Customer with multiple data
Given launch browser
When launch url in a browser
And Wait for username with "name" and "username"
And Enter Username with "name" and "username" and "admin"
And Enter password with "xpath" and "//input[@id='password']" and "master"
And click Login button with "xpath" and "//button[@id='btnsubmit']"
And Wait for logout link with "xpath" and "(//a[starts-with(text(),' Logout')])[2]"
Then Verify page title with "Dashboard « Stock Accounting"
When Wait  for Customers link with "xpath" and "(//a[contains(text(),'Customers')])[2]"
When Click Customers link with "xpath" and "(//a[contains(text(),'Customers')])[2]"
When Wait for Add + icon with "xpath" and "(//span[@data-caption='Add'])[1]"
When Click Add + icon with "xpath" and "(//span[@data-caption='Add'])[1]"
When Wait for Customer Number with "name" and "x_Customer_Number"
When Capture Customer number with "name" and "x_Customer_Number"
When Enter in "<CustomerName>" with "xpath" and "//input[@id='x_Customer_Name']" 
When Enter in "<address>" with "xpath" and "//*[@id='x_Address']" 
When Enter in "<city>" with "xpath" and "//*[@id='x_City']" 
When Enter in "<country>" with "xpath" and "//*[@id='x_Country']" 
When Enter in "<cperson>" with "xpath" and "//*[@id='x_Contact_Person']" 
When Enter in "<pnumber>" with "xpath" and "//*[@id='x_Phone_Number']" 
When Enter in "<mail>" with "xpath" and "//*[@id='x__Email']" 
When Enter in "<mnumber>" with "xpath" and "//*[@id='x_Mobile_Number']" 
When Enter in "<note>" with "xpath" and "//*[@id='x_Notes']" 
When Click Add button with "id" and "btnAction"
When Wait for confirm Ok button with "xpath" and "//button[normalize-space()='OK!']"
When Click Confirm ok button with "xpath" and "//button[normalize-space()='OK!']"
When Wait for alert ok button with "xpath" and "(//button[starts-with(text(),'OK')])[6]"
When Click Alert ok button with "xpath" and "(//button[starts-with(text(),'OK')])[6]"
Then Verify Customer Table
When Close App Browser
Examples:
|CustomerName|address|city|country|cperson|pnumber|mail|mnumber|note|
|regularcustomer1|Ammerpet1|Hyderbad|India|Qedge|234567895|Test@gmail.com|876543212|Iam new supplier|
|regularcustomer17|Ammerpet31|Hyderbad|India|Qedge|234567895|Test@gmail.com|876543212|Iam new supplier|
|regularcustomer14|Ammerpet61|Hyderbad|India|Qedge|234567895|Test@gmail.com|876543212|Iam new supplier|
|regularcustomer165|Ammerpet51|Hyderbad|India|Qedge|234567895|Test@gmail.com|876543212|Iam new supplier|
|regularcustomer143|Ammerpet21|Hyderbad|India|Qedge|234567895|Test@gmail.com|876543212|Iam new supplier|
|regularcustomer14|Ammerpet21|Hyderbad|India|Qedge|234567895|Test@gmail.com|876543212|Iam new supplier|

