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

	/hotels/id  (put)

	/hotels/id (delete)

-------------------------------

	/passengers  (get)
		#return all passengers objects in DB


	/passengers/id  (get)
	return passenger(id) object in DB

	/passengers (post)

	/passengers/id  (put)

	/passengers/id (delete)


Example via postman:
	{
	"name" : "wewfdq",
	"description" : "wqwefdx",
	"city" : "tehran",
	"rating" : 56
	}

Example via curl:

	curl -H "Content-Type: application/json" -X POST

	For Example : 
	-d "{"""name""":"""xyz""","""description""":"""d""","""city""":"""mancity""","""rating""" : 1}" http://localhost:8080/hotels


Simple controller with jquery has been applied to serve the data and update view pages...
You can easily improve this project as conventional sites and use larger and more tables!!

note that This is a good bootstrap for whoever not familiar with SpringBoot!!!!


Very Thanks TO MR Khoobyari 
[Sites Using React](https://github.com/khoubyari)



 