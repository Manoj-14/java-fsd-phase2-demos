## For using TagLib need to add jar files from:
- url("https://mvnrepository.com/artifact/org.glassfish.web/javax.servlet.jsp.jstl/1.2.1")
- url("https://mvnrepository.com/artifact/javax.servlet.jsp.jstl/javax.servlet.jsp.jstl-api/1.2.1")

### Key Points
- for using tags need to import library: `<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>`
- For using variables or objects you need to add it for `pageContext` 
- you can access the private variables of the class by there name because JSP converts it to getters and setters(getters and setters should decleared in class)