#  Sistema de Cadastro de Ninjas

Este projeto é uma aplicação de estudo desenvolvida em Java com Spring Boot para gerenciar o cadastro de ninjas e suas missões. O sistema permite realizar operações CRUD (Create, Read, Update, Delete) tanto para ninjas quanto para missões.

## 📋 Funcionalidades

- **Gestão de Ninjas**: Criar, listar, visualizar por ID, atualizar e deletar ninjas
- **Gestão de Missões**: Criar e listar missões (com funcionalidades de update e delete em desenvolvimento)
- **Relacionamento**: Sistema de relacionamento entre ninjas e missões (um ninja pode ter uma missão, uma missão pode ter vários ninjas)

## 🛠️ Tecnologias e Conceitos Java Utilizados

### **Core Java**
- **Orientação a Objetos**: Classes, objetos, encapsulamento com getters/setters
- **Collections Framework**: `List<T>` para manipulação de coleções
- **Stream API**: Uso de `stream()`, `map()` e `collect()` para transformação de dados
- **Optional**: Tratamento seguro de valores que podem ser nulos
- **Method References**: Uso de `::` para referência a métodos

### **Spring Framework**
- **Spring Boot**: Framework principal para criação da aplicação
- **Spring Web MVC**: 
  - `@RestController` - Controladores REST
  - `@RequestMapping` - Mapeamento de URLs
  - `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping` - Mapeamento HTTP
  - `@PathVariable` - Captura de variáveis da URL
  - `@RequestBody` - Binding de JSON para objetos Java
  - `ResponseEntity<T>` - Controle de respostas HTTP
- **Spring Data JPA**:
  - `JpaRepository<T, ID>` - Repositórios com operações CRUD automáticas
  - Consultas derivadas de nomes de métodos
- **Dependency Injection**:
  - `@Service` - Camada de serviço
  - `@Component` - Componentes gerenciados pelo Spring
  - Injeção por construtor

### **JPA/Hibernate**
- **Mapeamento Objeto-Relacional**:
  - `@Entity` - Entidades JPA
  - `@Table` - Configuração de tabelas
  - `@Id` e `@GeneratedValue` - Chaves primárias auto-incrementais
  - `@Column` - Mapeamento de colunas com restrições
- **Relacionamentos**:
  - `@OneToMany` - Relacionamento um-para-muitos (Missão → Ninjas)
  - `@ManyToOne` - Relacionamento muitos-para-um (Ninja → Missão)
  - `@JoinColumn` - Configuração de foreign keys
  - `mappedBy` - Mapeamento bidirecional

### **Lombok**
- `@Data` - Geração automática de getters, setters, toString, equals e hashCode
- `@NoArgsConstructor` - Construtor sem parâmetros
- `@AllArgsConstructor` - Construtor com todos os parâmetros

### **Jackson (JSON)**
- `@JsonIgnore` - Evita serialização circular em relacionamentos bidirecionais
- Serialização/deserialização automática de objetos Java para JSON

### **Flyway**
- **Database Migration**: Controle de versão do banco de dados
- Scripts SQL para evolução do schema

## 🏗️ Arquitetura e Padrões

### **Arquitetura em Camadas**
- **Controller Layer**: Endpoints REST para comunicação HTTP
- **Service Layer**: Lógica de negócio e orquestração
- **Repository Layer**: Acesso a dados com Spring Data JPA
- **Model Layer**: Entidades JPA representando tabelas do banco

### **Padrões de Design**
- **DTO (Data Transfer Object)**: Objetos para transferência de dados entre camadas
- **Mapper Pattern**: Conversão entre DTOs e entidades
- **Repository Pattern**: Abstração do acesso a dados
- **Dependency Injection**: Inversão de controle e injeção de dependências

### **Separação de Responsabilidades**
- **Controllers**: Apenas recebem requisições e retornam respostas
- **Services**: Contêm a lógica de negócio
- **Repositories**: Operações de banco de dados
- **DTOs**: Contratos de API
- **Models**: Representação das entidades de banco

## 🗃️ Estrutura do Banco de Dados

### Tabelas:
- **tb_cadastro**: Armazena dados dos ninjas
- **tb_missoes**: Armazena dados das missões

### Relacionamento:
- Um ninja pode estar associado a uma missão (ManyToOne)
- Uma missão pode ter vários ninjas associados (OneToMany)

## 🚀 Endpoints da API

### Ninjas:
- `POST /ninjas/criar` - Criar novo ninja
- `GET /ninjas/listar` - Listar todos os ninjas
- `GET /ninjas/listar/{id}` - Buscar ninja por ID
- `PUT /ninjas/alterar/{id}` - Atualizar ninja
- `DELETE /ninjas/deletar/{id}` - Deletar ninja

### Missões:
- `POST /missoes/criar` - Criar nova missão
- `GET /missoes/listar` - Listar todas as missões
- `PUT /missoes/alterar` - Atualizar missão (em desenvolvimento)
- `DELETE /missoes/deletar` - Deletar missão (em desenvolvimento)

## 🔧 Configuração

O projeto utiliza H2 Database em memória para desenvolvimento e está configurado para usar variáveis de ambiente para conexão com banco de dados.

### Principais configurações:
- **Database**: H2 (desenvolvimento)
- **JPA/Hibernate**: DDL auto-update habilitado
- **Flyway**: Migrations habilitadas
- **Console H2**: Habilitado para debug

## 📚 Conceitos de Estudo Demonstrados

Este projeto exemplifica diversos conceitos fundamentais do desenvolvimento Java enterprise:

1. **REST API Design** com Spring Boot
2. **Mapeamento Objeto-Relacional** com JPA/Hibernate
3. **Injeção de Dependências** com Spring
4. **Padrão DTO** para transferência de dados
5. **Stream API** para processamento funcional
6. **Tratamento de erros** com ResponseEntity
7. **Relacionamentos bidirecionais** em JPA
8. **Migration de banco** com Flyway
9. **Arquitetura em camadas** bem definida
10. **Boas práticas** de organização de código

## 🎯 Status do Projeto

- ✅ CRUD completo de Ninjas
- ✅ Criação e listagem de Missões
- 🚧 Atualização e deleção de Missões (em desenvolvimento)
- ✅ Relacionamento entre Ninjas e Missões

---

*Projeto desenvolvido para fins educacionais, demonstrando conceitos fundamentais do ecossistema Spring e desenvolvimento de APIs REST em Java.*
