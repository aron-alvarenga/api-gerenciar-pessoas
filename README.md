# Gerenciar Pessoas
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white) ![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black) ![Insomnia](https://img.shields.io/badge/Insomnia-black?style=for-the-badge&logo=insomnia&logoColor=5849BE)

Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:
- Criar uma pessoa
- Editar uma pessoa
- Consultar uma pessoa
- Listar pessoas
- Criar endereço para pessoa
- Listar endereços da pessoa
- Poder informar qual endereço é o principal da pessoa

## Qualidade de código

1. Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

	Para a implementação de uma nova funcionalidade, garantindo a qualidade de software, é necessário seguir os métodos da Engenharia de Software. Tais como, a definição do ciclo de vida de desenvolvimento, análise de requisitos (Funcionais e não funcionais), levantamento dos casos de uso e requisitos de teste. A partir destas análises é possível ter uma visão mais nítida do que (e como) deverá ser implementado e como poderá ser testado.

2. Em qual etapa da implementação você considera a qualidade de software?

	Considero a qualidade de software importante em todas as etapas da implementação. Tanto para garantir a possibilidade de teste e manutenção do código, quanto para garantir uma boa experiência ao usuário final.

## Ferramentas e Tecnologias

- IntelliJ - IDE;
- Java v. 11.0.12 - Linguagem de programação;
- Spring Boot v. 2.7.7 - Framework para desenvolvimento Back-End;
- Lombok - Biblioteca Java para redução de código boilerplate e aumento de produtividade;
- Spring Web - Para criar aplicações web, incluindo RESTful, usando Spring MVC e Apache TomCat como container Web padrão;
- Spring Data JPA - Framework para acesso a dados com mapeamento objeto-relacional (ORM);
- H2 - SGBD;
- Apache Maven - Gerenciamento de dependências e build;
- Insomnia - Plataforma para teste de endpoints da API.

## Configurações Banco de Dados

<table>
    <tr><td>Nome do Banco de Dados</td><td>pessoas_db</td></tr>
    <tr><td>Driver Class</td><td>org.h2.Driver</td></tr>
    <tr><td>JDBC URL</td><td>jdbc:h2:mem:pessoasdb</td></tr>
    <tr><td>User Name</td><td>sa</td></tr>
    <tr><td>Password</td><td>123</td></tr>
    <tr><td>Server Port</td><td>8081</td></tr>
    <tr><td>Console Path</td><td>localhost:8081/h2-console</td></tr>
    <tr><td>Tabelas</td><td>tb_pessoa e tb_endereco</td></tr>
</table>

## API

### Adicionar Pessoa:
- Verbo HTTP: POST
- Endpoint: <code>localhost:8081/pessoa</code>
- Exemplo de Requisição:
```
{
	"pessoa": {
		"nome": "Beltrano",
		"dataNascimento": "19/04/1996",
		"enderecos": [
			{
				"logradouro": "Rua Principal",
				"cep": "72154389",
				"numero": 123,
				"cidade": "Maracaju",
				"enderecoPrincipal":true
			}
		]
	}
}
```

### Editar Pessoa:
- Verbo HTTP: POST
- Endpoint: <code>localhost:8081/pessoa</code>
- Exemplo de Requisição:
```
{
	"pessoa": {
	        "id": 1,
		"nome": "Beltrano de Souza",
		"dataNascimento": "19/04/1996",
		"enderecos": [
			{
				"logradouro": "Rua Principal",
				"cep": "72154389",
				"numero": 123,
				"cidade": "Maracaju",
				"enderecoPrincipal":true
			}
		]
	}
}
```

### Consultar uma Pessoa pelo ID:
- Verbo HTTP: GET
- Endpoint: <code>localhost:8081/pessoa/{id da pessoa}</code>
- Exemplo de Resposta:
```
{
	"id": 1,
	"nome": "Beltrano de Souza",
	"dataNascimento": "19/04/1996",
	"enderecos": [
		{
			"id": 4,
			"logradouro": "Rua Principal",
			"cep": "72154389",
			"numero": 123,
			"cidade": "Maracaju",
			"enderecoPrincipal": true
		}
	]
}
```

### Listar Pessoas:
- Verbo HTTP: GET
- Endpoint: <code>localhost:8081/pessoas</code>
- Exemplo de Resposta:
```
[
	{
		"id": 1,
		"nome": "Beltrano de Souza",
		"dataNascimento": "19/04/1996",
		"enderecos": [
			{
				"id": 2,
				"logradouro": "Rua Principal",
				"cep": "72154389",
				"numero": 123,
				"cidade": "Maracaju",
				"enderecoPrincipal": true
			}
		]
	},
	{
		"id": 2,
		"nome": "Fulano",
		"dataNascimento": "05/11/1999",
		"enderecos": []
	}
]
```

### Criar Endereço para Pessoa:
- Verbo HTTP: PUT
- Endpoint: <code>localhost:8081/endereco</code>
- Exemplo de Requisição:
```
{
	"pessoa": {
		"nome": "Fulano",
		"id": 2,
		"dataNascimento": "05/11/1999",
		"enderecos": [
			{
				"logradouro": "Avenida Rio Grande",
				"cep": "79888145",
				"numero": 678,
				"cidade": "Campo Grande",
				"enderecoPrincipal": true
			},
			{
				"logradouro": "Avenida Caballero",
				"cep": "79778145",
				"numero": 678,
				"cidade": "Navirai",
				"enderecoPrincipal": false
			}
		]
	}
}
```

### Listar Endereços da Pessoa:
- Verbo HTTP: GET
- Endpoint: <code>localhost:8081/pessoa/{id da pessoa}/enderecos</code>
- Exemplo de Resposta:
```
[
	{
		"id": 3,
		"logradouro": "Avenida Rio Grande",
		"cep": "79888145",
		"numero": 678,
		"cidade": "Campo Grande",
		"enderecoPrincipal": true
	},
	{
		"id": 4,
		"logradouro": "Avenida Caballero",
		"cep": "79778145",
		"numero": 678,
		"cidade": "Navirai"
	}
]
```

### Listar Endereço Principal da Pessoa:
- Verbo HTTP: GET
- Endpoint: <code>localhost:8081/pessoa/{id da pessoa}/enderecos/principal</code>
- Exemplo de Resposta:
```
[
	{
		"id": 3,
		"logradouro": "Avenida Rio Grande",
		"cep": "79888145",
		"numero": 678,
		"cidade": "Campo Grande",
		"enderecoPrincipal": true
	}
]
```

