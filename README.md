projeto - forum hub

## CRUD

C - POST (OK): -- endpoint: http://localhost:8080/topicos

```json
{
    "id": 1,
    "titulo": "Estou com problemas",
    "mensagem": "Não consigo enviar a atividade",
    "autor": "Árlisson Diôgo",
    "curso": "Computação"
}
```

R - GET (OK): -- ENDPOINT: http://localhost:8080/topicos


```json
{
    "content": [
        {
            "titulo": "Estou com problemas",
            "mensagem": "Não consigo enviar a atividade",
            "status": "NAO_RESPONDIDO",
            "autorId": "Árlisson Diôgo",
            "cursoId": "Computação",
            "dataCriacao": "2026-01-16T21:04:15.82003"
        }
    ]
```
--> detalhar: ENDPOINT: http://localhost:8080/topicos/{id}


```json
{
  "id": 2,
  "titulo": "Estou com problemas",
  "mensagem": "Não consigo enviar a atividade",
  "autorId": "Árlisson Diôgo",
  "cursoId": "Computação"
}
```