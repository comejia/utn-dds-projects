1) Como usuarie de QueMePongo quiero ver todas las prendas que tengo en mi guardarropas desde el navegador para poder administrarlas
```
Request:
GET /guardarropas/<GUARDARROPA_ID>/prendas

Body: no tiene

Response:
[
 {tipo: "camisa", talle: "S"},
 {tipo: "camisa", talle: "L"},
 {tipo: "pantalon", talle: "chupin"}
]

Response: status code 200
```
2) Como usuario de QueMePongo, quiero crear una prenda desde el navegador
```
Request:
POST /guardarropas/<GUARDARROPA_ID>/prendas

Body:
{
 tipo: "camisa",
 talle: "S"
}

Response: status code 200
```
3) Como usuarie de QueMePongo quiero ver una prenda en particular que tengo en mi guardarropas para poder editarla
```
Request:
GET /guardarropas/<GUARDARROPA_ID>/prendas/<PRENDA_ID>

Body: no tiene

Response:
{
 tipo: "camisa",
 talle: "S"
}

Request:
PUT /guardarropas/<GUARDARROPA_ID>/prendas/<PRENDA_ID>

Body:
{
 tipo: "camisa",
 talle: "M"
}

Response: status code 200
```

4) Como usuarie de QueMePongo, quiero poder eliminar una prenda de mi guardarropas
```
Request:
DELETE /guardarropas/<GUARDARROPA_ID>/prendas/<PRENDA_ID>

Body: no tiene

Response: status code 200
```

5) Como usuarie de QueMePongo, quiero poder ver mis eventos para administrarlos
```
Request:
GET /usuarios/<USER_ID>/eventos

Body: no tiene

Response: status code 200
```
6) Como usuarie de QueMePongo, quiero poder abrir las sugerencias de prendas para un evento en mi navegador
```
Request:
GET /eventos/<EVENTO_ID>/sugerencias

Response: status code 200
```