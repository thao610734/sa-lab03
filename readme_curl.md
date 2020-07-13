```
curl http://localhost:8080/catalog  -H "Content-Type: application/json" -d "{\"productNumber\": \"p001\", \"description\": \"product 1\", \"price\": 12.3}"

curl -X PUT -H "Content-Type: application/json" -d "{\"quantity\": 12, \"locationCode\":\"loc001\"}" http://localhost:8080/catalog/p001 

curl -X PUT http://localhost:8080/cart/0001/p001/3 
```