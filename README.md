# ConditionalValidator
Showcase Spring Boot project for custom conditional validation.

The main purpose of this repository is provide a solution for a conditional validation example in spring boot.
The object to validate is the ExportLocationDTO POJO class , depending on it's field locationOption's value 
different additional fields are validated.

case EMAIL :
- emailAddress field cannot be null or empty and any other non annotated fields are optional

case FTP or SFTP :
- host, port, user and password fields cannot be null or empty and any other non annotated fields are optional.

Take a look at the test folder as well to have a working proof of the concept.
