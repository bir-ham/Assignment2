Assignment2
===========

Multihtreaded java application managing identical instances’ task

Tools: Eclipse, MySQL, EGit/github

This is a multithreaded java project implemented using java SDK and mysql-connector.jar libraries. An MVC paradigm has been followed when structuring and designing project components. The service retrieves available task from a database and assigns it to the instance object running at the current thread. Multiple threads are started in no-particular-order from the ‘main’ method block to demo the behavior of identical service instances in a scalable application server.  

Database configuration 
----------------------
An Ant Build file is created under a folder called ‘database’ called 'build.xml' for the purpose of creating database table called 'instance' and inserting values to the table. Here is an instruction for configuration.

•	Install MySQL database if not already has.

• Run the ant build file called build1.xml file first as an ant to create a database called ‘instance’ and database user called ‘instance@localhost’. (P.S. remember to change to change your own MySQL server ‘username’ and ‘password’ in this file instead of the ‘root’ value used as a username and password in my database)
•	Run the other ant build file called build2.xml file to create a table called ‘instace’ and insert dummy(test) values. 

Then you are ready to run the ‘Main’ class.

