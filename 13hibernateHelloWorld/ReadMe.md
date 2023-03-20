# Hibernate
- Comes under ORM (Object Relation Mapping)
- Which means it helps to convert relation model to object model or Hibernate is the tool which helps in mapping Relation model with object model
- And for this no need of SQL Statement we can deal with object model directly
- Hibernate work in the session

### Steps to add jar fils to project
- Download jar files from https://hibernate.org/orm/releases/5.3/
- Copy the jars from `\hibernate-release-5.3.26.Final\lib\required`
- Create a `lib` folder in project and paste the jars here
- add all jars from classpath and done

- Creating object mapping file ,Example file is below `message.hmb.xml`:


	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE hibernate-mapping PUBLIC 
	 "-//HIBERNATE/HIBERNATE MAPPING DTD 3.0//EN"
	 "http://www.hibernate.org/dtd/hibernate-mapping-3.0.dtd">
	 
	<hibernate-mapping>
	 <class name="Message" table="message">
	  <id name="id" column="id">
	   <generator class="native" />
	  </id>
	  <property name="text" column="text" type="string" />
	 </class>
	</hibernate-mapping>

- Creating Hibernate configuration file, Example file is below `hibernate-config.xml`:


	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE hibernate-configuration PUBLIC 
	 "-//HIBERNATE/HIBERNATE Configuration DTD 3.0//EN"
	 "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
	 
	<hibernate-configuration>
	 <session-factory>
	  <!--  Database connection settings -->
	  <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
	  <property name="connection.url">jdbc:mysql://localhost:3306/mydb</property>
	  <property name="connection.username">root</property>
	  <property name="connection.password">***</property>
	 
	  <property name="dialect">org.hibernate.dialect.MySQLDialect</property>
	 
	  <mapping resource="../domain/message.hbm.xml"/>
	 
	 </session-factory>
	
	</hibernate-configuration>
	
### Key points
- Hibernate works on session so 