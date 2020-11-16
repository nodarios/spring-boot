### `USAGE`

[schema url](http://localhost:8080/graphql/schema.json)

1 graphiql or postman:

mutation {
  addPerson(personId: "personId") {
    id
    personId
  }
}

{
  findPersons {
    id
  }
}

2 curl or postman:

curl \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -X POST \
  -d '{ "query": "mutation { addPerson(personId: \"personId\") {id personId} }" }' \
  http://localhost:8080/graphql

curl \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -X POST \
  -d '{ "query": "{ findPersons {id} }" }' \
  http://localhost:8080/graphql
