# ams-product-api

Deployable REST API application using SpringBoot, Jersey and Swagger UI <br />
<br />
Contains 2 Products API endpoints <br />
<br />
    get /products  Gets all Product Resource in the database <br />
    get /products/{code}  Gets a Product Resource by Product Code. <br />

# Note
update pom.xml packaging as war for AWS deployment in Tomcat <br />

<packaging>war</packaging>
