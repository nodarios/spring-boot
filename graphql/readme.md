### Usage

* graphiql or postman:
```
mutation {
  addDepartment(name: "hr") {
    id
    name
  }
}

{
  getDepartments {
    id
    name
  }
}

mutation {
  addEmployee(employee: {firstName: "asd", lastName: "asdasd", salary: 10, department: {id: "60003529-8d42-4a8e-a29d-414ca24442f3", name: "hr"}}) {
    id
  }
}

{
  getEmployees {
    id
    firstName
    lastName
    salary
    department {
      id
      name
    }
    anotherLazyField
  }
}
```

* curl or postman:
```
curl \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -X POST \
  -d '{ "query": "mutation { addDepartment(name: \"hr\") {id name} }" }' \
  http://localhost:8080/graphql

curl \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -X POST \
  -d '{ "query": "{ getDepartments {id name} }" }' \
  http://localhost:8080/graphql
```

---

### Links
[api](http://localhost:8080/graphql)  
[schema](http://localhost:8080/graphql/schema.json)  
[client](http://localhost:8080/graphiql)  

---

### GRAPHQL Advantages

* get many resources in a single request (no multiple round trips for data)
* get exactly what you need (no over-fetching and Under-fetching of data)

to match the same logic on server side: 
* jpa entity relationship is used (Employee and Department) 
* when requesting Employee without department and anotherLazyField, the last two are not loaded because of laziness

---

### Research

* data fetcher
* data loader (batching, cashing)
* multithreading
* subscription
