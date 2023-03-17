### Key Points
- DataSource get a connection from the connection pool so that we can remove all context parameters fom `web.xml` but we need to create `context.xml` under `src\main\webapp\META-INF`.
- In `context.xml` add the following
	`<Context><Resource name="jdbc/studentweb" auth="Container" type="javax.sql.DataSource" maxActive="20" maxldle="5" maxWait="10000" username="root" password="root" driverClassName="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/studentweb?useSSl=false&amp;serverTimezone=UTC" /></Context>`
	
	