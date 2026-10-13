# Postman API testing

Base URL: `http://localhost:8080/api`.

Create an employee with `POST /employees`, header `Content-Type: application/json`, body:

```json
{
  "fullName": "Priya Sharma",
  "email": "priya@example.com",
  "department": "Engineering",
  "jobTitle": "Software Engineer",
  "status": "ACTIVE"
}
```

Other requests:
- `GET /employees`
- `GET /employees?search=priya`
- `GET /employees/{id}`
- `PUT /employees/{id}` with an employee JSON body
- `DELETE /employees/{id}`
- `GET /health`

Create an employee before testing get/update/delete. Use the ID returned by the API. The collection is in `postman/Nexora-Workforce-Postman-Collection.json`.
