# API Spec

## Authentication

All API requests require an API key.

Request:
- Header:
  - X-API-Key: <api-key>

## Create Product

Request:

- Method: POST
- Endpoint: `/api/products`
- Headers:
    - `Content-Type: application/json`
    - `Accept: application/json`

Body:

```json
{
  "id": "string, unique",
  "name": "string",
  "price": "long",
  "quantity": "integer"
}
```

Response:

```json
{
  "code": "integer",
  "message": "string",
  "data": {
    "id": "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## Get Product

Request:

- Method: GET
- Endpoint: `/api/products/{id}`
- Headers:
    - `Content-Type: application/json`

Response:

```json
{
  "code": "integer",
  "message": "string",
  "data": {
    "id": "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## Update Product

Request:

- Method: PUT
- Endpoint: `/api/products/{id}`
- Headers:
    - `Content-Type: application/json`
    - `Accept: application/json`

Body:

```json
{
  "name": "string",
  "price": "long",
  "quantity": "integer"
}
```

Response:

```json
{
  "code": "integer",
  "message": "string",
  "data": {
    "id": "string, unique",
    "name": "string",
    "price": "long",
    "quantity": "integer",
    "createdAt": "date",
    "updatedAt": "date"
  }
}
```

## List Product

Request:

- Method: GET
- Endpoint: `/api/products`
- Headers:
    - `Accept: application/json`
- Query Parameters:
    - limit: integer
    - offset: integer

Response:

```json
{
  "code": "integer",
  "message": "string",
  "data": [
    {
      "id": "string, unique",
      "name": "string",
      "price": "long",
      "quantity": "integer",
      "createdAt": "date",
      "updatedAt": "date"
    },
    {
      "id": "string, unique",
      "name": "string",
      "price": "long",
      "quantity": "integer",
      "createdAt": "date",
      "updatedAt": "date"
    }
  ]
}
```

## Delete Product

Request:

- Method: DELETE
- Endpoint: `/api/products/{id}`
- Headers:
    - `Accept: application/json`

Response:

```json
{
  "code": "integer",
  "message": "string"
}
```