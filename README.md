# restassured
Go to the command prompt and run the command.
$ mvn clean install
OR with Profile
$mvn clean install -PDevTests


#Run with test-output result with environment
$mvn clean install -PDevTests -Denv=prod
Then copy dev/qa/prod properties files in paperless-restassured/*.properties
Also copy the paperless-restassured-jar-with-dependencies.jar from target file here.
Now run the command
$java -jar paperless-restassured-jar-with-dependencies.jar prod
