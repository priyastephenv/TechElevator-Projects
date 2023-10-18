### http://localhost:8080 -- BASE URL

- /login POST -- allows the user to login **PROVIDED**
- /register POST -- able to register a new user **PROVIDED**

        1) Load the java_messaging_db database
        2) run server code
        3) use postman to register 2 new users

- /message POST -- creates a new message object and saves it to the database

        1) build message model(s) based off db
        2) build MessageDAO -> addNewMessage(Message message)
        3) build JDBCMessageDAO -> addNewMessage(Message message)
        4) build MessageController POST request to createNewMessage
        5) Test in Postman POSTing a message and seeing it added to the database

### Additional features:
- /messages GET -- returns a list of all public messages
- /user/messages GET -- returns list of private messages associated with a user
- Add a service to get a random quote from https://api.quotable.io/random

