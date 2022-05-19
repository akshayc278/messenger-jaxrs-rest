# messenger-jaxrs-rest
messeging applicattion 
user -> massege plus likes 
uri are made from verbs 
instance  resource url are URLS like /profile/{profilename}
collecion uri masseges 

till now we get messages for id 20 with name /comments/20
but what if we get commenturl , likesur,authorurl like api/commens/20/message
that is called HATEOAS
HATEOAS : Hipermedia as the engine of application state (bad choice but no option)

scenario: 
/messages gives{id,message,created, author}

updated vaue  /message/1 {id,message,created,auher, comments( messages/1/comment/1

so best way is {
	id:1;,
	author:x,
	links[ 
		{
		href: /messages/1
		rel:self
		},
		{
		href:messages/1/likes
		rel:likes    ..... thats more information given abou uri
		}
	     ]
	}

Richardson marity model level 3 is hateoas 0 is plain xml communication
various libraries : Reseasy,jersey etc.
we can do withou library u it is asy to write with library.


This course : 
	JAX-RS (javax.ws.rs.*) are interfaces for better communication 
	JAX-RS -> jersey /RESTEasy (implementation classes) both goes hand in hand in tomcat
	
now Jersey comes with copy of JAX-RS so no need to do separate things.
