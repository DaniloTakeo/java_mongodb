# Projeto Java + MongoDB

Este é um projeto de estudo que demonstra a persistência de dados usando Java com MongoDB, sem utilizar frameworks como Spring. A proposta é aplicar boas práticas de separação em camadas, uso de DTOs e mapeamento entre entidades e objetos de transferência de dados.

## 🚀 Tecnologias Utilizadas

- Java 17+
- MongoDB (Driver oficial)
- Maven
- Docker (para subir o banco de dados)

## 📦 Objetivos

- Praticar persistência de dados com MongoDB puro (driver oficial).
- Implementar uma estrutura de projeto orientada ao domínio.
- Adotar DTOs e mapeamento manual (sem frameworks de injeção).
- Evoluir o projeto com testes e/ou API REST futuramente.

## 🐳 Subindo o MongoDB com Docker

```bash
docker run -d \
  --name mongo \
  -p 27017:27017 \
  -e MONGO_INITDB_ROOT_USERNAME=admin \
  -e MONGO_INITDB_ROOT_PASSWORD=admin \
  mongo
```

### 💡 O projeto se conecta à instância MongoDB local usando mongodb://admin:admin@localhost:27017.

---

## ▶️ Executando o projeto

- Clone este repositório:
```bash
git clone git@github.com:DaniloTakeo/java_mongodb.git
cd java_mongodb/mongodb
```

- Compile o projeto com Maven:

```bash
mvn clean install
```

- Execute a aplicação:

```bash
mvn exec:java -Dexec.mainClass="mongodb.App"
```

---

## 🧱 Estrutura básica

- domain: Entidades principais do domínio
- dto: Objetos de transferência de dados
- mapper: Conversores entre entidade e DTO
- repository: Persistência com MongoDB driver
- service: Lógica de negócio

--- 

## 🔧 Próximas etapas

- Adicionar testes unitários com JUnit
- Implementar validações nos DTOs
- Criar uma API REST (com ou sem framework)

---

## 👨‍💻 Autor
Danilo Takeo Kanizawa
