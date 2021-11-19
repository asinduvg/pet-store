### How to build and/or deploy the API

i. Build the project

    ./gradlew build 

ii. Deploy and run the project

    java -jar build/petstore-runner.jar

### How to Run test suite

    ./gradlew test

### How to run a CURL/WGET command to test the APIs once deployed

###### Get all pets
curl --location --request GET 'http://localhost:8080/v1/pets'

###### Add a pet
curl --location --request POST 'http://localhost:8080/v1/pets' \
--header 'Content-Type: application/json' \
--data-raw '{
"petAge": 4,
"petId": 5,
"petName": "Bijitha",
"petType": "Bird"
}'

###### Update a pet
curl --location --request PUT 'http://localhost:8080/v1/pets/5' \
--header 'Content-Type: application/json' \
--data-raw '{
"petAge": 4,
"petId": 5,
"petName": "Biji",
"petType": "Bird"
}'

###### Get a pet type
curl --location --request GET 'http://localhost:8080/v1/pets/1/type'

###### Update a pet type
curl --location --request PATCH 'http://localhost:8080/v1/pets/1/type' \
--header 'Content-Type: application/json' \
--data-raw '{
"petType": "Fish"
}'

