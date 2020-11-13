### `USAGE`

[schema url](http://localhost:8080/graphql/schema.json)

1 graphiql or postman:

mutation {  
  newApplication(name: "name", owner: "owner", description: "desc") {  
    id  
    name  
  }  
}

{  
  findAllApplications {  
    id  
    name  
  }  
}

2 curl or postman:

curl \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -X POST \
  -d '{ "query": "mutation { newApplication(name: \"name\", owner: \"owner\", description: \"desc\") {id name} }" }' \
  http://localhost:8080/graphql

curl \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -X POST \
  -d '{ "query": "{ findAllApplications {id name} }" }' \
  http://localhost:8080/graphql
