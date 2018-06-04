<div>
<h1>System Requirements</h>
<h4>
Java 8<br>
Lombok<br>
Preferred Editor<br>
Maven
</h4>
</div>

<div>
<h1>Description</h2>
<h4>
<pre>
This project is about BBD testing using cucumber-java as 
client side(UserApiTesting) and
Spring Boot as Server side(UserApi).The purpose of the project 
is soley for education only.During the start up of
the application two users are created.Users are also added from
cucumber(client side) and deleted after the completion of test.
Couple of rest resources are added in controller of UserApi. 
Swagger is integrated as well. In the client side dependency
injection is maintained through picocontainer. Couple of examples
added like Datatable, Scenario Outline, custom tags which can
be seen in users.feature.
</pre>
</h4>
</div>

<div>
<h2>Swagger-URL</h2>
<h4>http://localhost:8080/swagger-ui.html</h4>
</div>
<div>
<h2>Running UserApi</h2>
<h4>mvn spring-boot:run</h4>
<h2>Running UserApiTesting</h2>
<h4>Open ApiTestRunner from runner package.Right click and Run</h4>
</div>


<div>
  <h2>Report After Running Cucumber</h2>
<h4>Report Location</h4>
  ../target/cucumber/api/index.html
<h4>Pass report</h4>

![passreport](https://user-images.githubusercontent.com/14364853/40896875-c0f11ad4-6785-11e8-9882-b35a9dfbaac1.png)
<h4>Actual Report index.html</h4>

![report-cucumber](https://user-images.githubusercontent.com/14364853/40896879-c392ec54-6785-11e8-9226-ab9ffebe369a.png)
</div>
