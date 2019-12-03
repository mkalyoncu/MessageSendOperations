# Message Send Operations

Message Send Operations is a simple message publishing system.  
There is a text file that includes 1000 usernames of a Linux system in the project.The app bring out packages in Json format for each username in the file.

### Contents

User.java and UserId.java classes were written to make convertion process between String/Json easier. 

UserService.java reads 1000.usernames.txt file and placed all of the usernames in a list called 'usernames'. Usernames list was used to create User objects.

ProducerService.java converts every User objects to Json strings with Gson library. After that, the class publishes the Json strings with some parameters taken from properties file.

EndPoint.java class has written to make channel and connection of message queue effortlessly reachable.  

Properties file externalizes the configuration and store the key-value pairs of message queue such as IP address, queue name, exchange name, username, password, etc. It can be accessable by getProperty() method from PropertiesReader.java class.



### Requirements  

* Java version 8 or higher.  
* RabbitMQ 3.8.x
* Apache Maven 3.6.3

### Installation

1. Download the repository files (project) from the download section or clone this project by typing in the bash the following command:  
``
git clone https://github.com/mkalyoncu/MessageSendOperations.git
``
2. Import it in Intellij IDEA.  
3. Find 'rabbitmq.properties' file under the resources directory and modify it with your information
4. Run the app or make an executable jar from the project with command below  
``
mvn install
``    
5. ``` cd target ```  
6. ``` java -jar MessageSendOperations-jar-with-dependencies.jar ```

