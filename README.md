# Encrypt_Challange

**Descrição:**
Este é um projeto desenvolvido com o intuito de estudo, focado em criptografia e descriptografia de dados sensíveis usando Java e Spring. A API foi construída seguindo o modelo MVC (Model-View-Controller) e oferece endpoints para manipulação de dados de usuários com segurança, criptografando informações antes de salvá-las no banco de dados e permitindo a descriptografia quando necessário.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Jasypt (Java Simplified Encryption)**
- **Spring Data JPA**
- **XAMPP** (ou qualquer outro host que preferir)
- **Lombok**

## Funcionalidades

- Criação de usuários com dados sensíveis criptografados.
- Recuperação de usuários com dados descriptografados.
- Atualização e deleção de usuários.
- Testes utilizando uma coleção do Postman.

## Estrutura do Projeto

- **`com.grecco.encryption.config`**: Contém a configuração do bean de criptografia.
- **`com.grecco.encryption.service`**: Contém os serviços responsáveis pela lógica de criptografia e manipulação de usuários.
- **`com.grecco.encryption.controller`**: Contém os controladores que expõem os endpoints da API.
- **`com.grecco.encryption.model`**: Contém as entidades e DTOs usados pelo sistema.
- **`com.grecco.encryption.repository`**: Contém a interface para acesso ao banco de dados.

## Como Executar o Projeto

### Pré-requisitos:

- **JDK 21**
- **Maven**
- **Postman** (opcional, para testes)

### Passos:

1. Clone o repositório:

    ```bash
    git clone https://github.com/seu-usuario/encrypt_challange.git
    cd encrypt_challange
    ```

2. Compile e execute o projeto:

    - Com Maven:
      ```bash
      mvn clean install
      mvn spring-boot:run
      ```

    - Com Gradle:
      ```bash
      gradle build
      gradle bootRun
      ```

3. Acesse a API:
   - A API estará disponível em `http://localhost:8080`.

### Testando com Postman:

- Importar a coleção do Postman disponível no repositório (`Encrypt_Challange.postman_collection.json`).
- Acesse os diferentes endpoints para testar a criação, recuperação, atualização e deleção de usuários.

## Endpoints Disponíveis

- **`POST /user/save`**: Salva um novo usuário com dados criptografados.
- **`GET /user/{id}`**: Recupera um usuário por ID com dados descriptografados.
- **`PUT /user/update/{id}`**: Atualiza um usuário existente.
- **`DELETE /user/delete/{id}`**: Deleta um usuário por ID.

## Configuração de Criptografia

O projeto utiliza o **Jasypt** para criptografia e descriptografia de dados. A configuração do algoritmo e a senha de criptografia estão definidas no arquivo de configuração `EncryptionConfig`.

### Exemplo de Configuração:

```java
@Bean
public StringEncryptor stringEncryptor() {
    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    encryptor.setPassword("your-secret-password");
    encryptor.setAlgorithm("PBEWithMD5AndDES");
    return encryptor;
}
```

## Licença

Este projeto é licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
