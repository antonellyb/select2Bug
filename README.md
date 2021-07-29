# select2Bug
This application demostrates a bug in org.wicketstuff.select2.Select2Choice component.<br>
Run it with<br>
mvn:jetty:run<br>
and open<br>
http://localhost:8080/<br>
You will see a page with three select2 components. The first and the third one do work correctly but the second one does not.
For example if you type 'F' to the first or the third one, a list of three choices appear:
First Choice
Fourth Choice
Firth Choice

If you type 'F' to the second one, nothing happends
