## Key points
- If you want to add other class in the main domine class then add `@Embeddable` in sub class and `@Embedded` above declaration of that class in main class.
- If you are using same class for more than variable then manually give the column name above the declaration of that class using `@AttributeOverrides` and `@AttributeOverride`.
- `<property name="hbm2ddl.auto">update</property>` if tabele is not present it will create if already present then it will update or alter the table account to the class.
- `<property name="hbm2ddl.auto">create</property>` when every time it execute it drop the old table and create new table every time.