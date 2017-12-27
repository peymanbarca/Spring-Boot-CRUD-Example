open your browser and enjoy the world

![alt text](http://www.tech-ab.net/wp-content/uploads/2015/11/Spring-Logo.png)
.........

Simple CRUD App Example with Spring Boot

Endpoints :

/hotels  (get)
#return all hotles objects in DB


/hotels/id  (get)
return hotel(id) object in DB

/hotels (post)

Example via postman:
{
"name" : "wewfdq",
"description" : "wqwefdx",
"city" : "tehran",
"rating" : 56
}

Example via curl:
curl -H "Content-Type: application/json" -X POST 
-d "{"""name""":"""xyz""","""description""":"""d""","""city""":"""mancity""","""rating""" : 1}" http://localhost:8080/hotels


Simple controller with jquery has been applied to serve the data and update view pages...
You can easily improve this project as conventional sites and use larger and more tables!!

note that This is a good bootstrap for whoever not familiar with SpringBoot!!!!



 