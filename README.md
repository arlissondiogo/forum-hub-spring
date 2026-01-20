# Fórum Hub API
<p align="center">
  <img src="src/main/assets/Badge-Spring.png" alt="Badge Literalura" width="150">
</p>
API REST desenvolvida com Spring Boot para gerenciamento de tópicos de um fórum, com autenticação e autorização via JWT.

---

## 📌 Funcionalidades

- ✅ Autenticação de usuários via JWT
- ✅ Cadastro de tópicos
- ✅ Listagem paginada de tópicos ativos
- ✅ Detalhamento de tópico por ID
- ✅ Atualização de tópico
- ✅ Exclusão (inativação) de tópico
- ✅ Proteção de rotas com Spring Security

---

## 🔐 Autenticação e Segurança

A API utiliza **JWT (JSON Web Token)** para autenticação e controle de acesso às rotas protegidas.

### 🔹 Login

Endpoint público para autenticação do usuário que retorna um token JWT válido por tempo configurável.

**Endpoint:**
```http
POST /login
```

**Exemplo de requisição:**
```json
{
  "login": "usuario",
  "senha": "123456"
}
```

**Exemplo de resposta:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

**Utilizando o token:**

O token deve ser enviado nas requisições protegidas através do header:
```
Authorization: Bearer <token>
```

---

## 📂 Endpoints Principais

### 🔸 Tópicos

Todos os endpoints de tópicos requerem autenticação via token JWT.

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/topicos` | Cadastrar novo tópico |
| `GET` | `/topicos` | Listar tópicos ativos (paginado) |
| `GET` | `/topicos/{id}` | Detalhar tópico por ID |
| `PUT` | `/topicos/{id}` | Atualizar tópico |
| `DELETE` | `/topicos/{id}` | Excluir (inativar) tópico |

---

## 🗂 Estrutura do Projeto

```
com.forum_hub
 ├── controller
 │   ├── LoginController
 │   └── TopicoController
 │
 ├── domain
 │   ├── topico
 │   │   ├── Topico
 │   │   ├── TopicoRepository
 │   │   ├── DadosCadastroTopico
 │   │   ├── DadosAtualizacaoTopico
 │   │   ├── DadosDetalhamentoTopico
 │   │   └── DadosListagemTopicos
 │   │
 │   └── usuario
 │       ├── Usuario
 │       └── UsuarioRepository
 │
 ├── infra
 │   └── security
 │       ├── SecurityConfigurations
 │       ├── SecurityFilter
 │       ├── TokenService
 │       ├── AutenticacaoService
 │       ├── DadosAutenticacao
 │       └── DadosTokenJWT
 │
 └── ApiProjectApplication
```

---

## 🛢 Banco de Dados

O projeto utiliza **Flyway** para versionamento do banco de dados. As migrações estão localizadas em:

```
src/main/resources/db/migration
```

**Migrações incluídas:**
- Criação da tabela de tópicos
- Alterações estruturais
- Criação da tabela de usuários

---

## ⚙️ Configuração e Execução

### Pré-requisitos
- Java 17+
- Maven
- Banco de dados (MySQL)

### Passos para execução

1. **Clone o repositório**
```bash
git clone <https://github.com/arlissondiogo/forum-hub-spring.git>
cd forum-hub-spring
```

2. **Configure as variáveis de ambiente do banco de dados**

Edite o arquivo `application.properties` **ou** configure variáveis de ambiente:

### application.properties
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/forum_hub
spring.datasource.username=${MYSQL_USER}
spring.datasource.password=${MYSQL_PASSWORD}

jwt.secret=${JWT_SECRET}
jwt.expiration=2
```

3.  **Inicie a aplicação**
```bash
mvn spring-boot:run
```

4. **Realize o login para obter o token JWT**

Faça uma requisição POST para `/login` com suas credenciais.

5. **Utilize o token para acessar os endpoints protegidos**

Adicione o token no header `Authorization: Bearer <token>` nas próximas requisições.

---

## 🧪 Observações

- Apenas tópicos **ativos** são listados por padrão
- O tempo de expiração do token é de 2 horas mas configurável via `application.properties`
- Todos os endpoints de tópicos requerem autenticação

---

## 🛠 Tecnologias Utilizadas

- **Spring Boot** - Framework principal
- **Spring Security** - Segurança e autenticação
- **JWT** - Autenticação via token
- **Flyway** - Versionamento de banco de dados
- **JPA/Hibernate** - Persistência de dados
- **Maven** - Gerenciamento de dependências

---

## 📝 Licença

Este projeto está sob a licença MIT.