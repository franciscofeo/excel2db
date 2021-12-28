
# API Excel2DB :chart_with_upwards_trend:

Uma API que tem como objetivo facilitar a carga de dados nos formatos _.xlsx_ ou _.xls_
para um banco de dados.

Nessa situação, como o foco era apenas aprender a manusear arquivos excel com Kotlin,
a planilha teste presente neste repositório com o nome _customers.xlsx_ possui apenas 4 colunas: **id**, **name**, **email** e **salary**.

Caso queira testar para outros formatos ou colunas diferente, sugiro dar uma lida na documentação do _Apache POI_. O raciocínio será o
mesmo que o utilizado aqui.

## Tecnologias Utilizadas


- [Kotlin](https://kotlinlang.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [MySQL](https://www.mysql.com/) 
- [Apache POI](https://poi.apache.org/)


## Licença

[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://github.com/tterb/atomic-design-ui/blob/master/LICENSEs)

## Rodando a Aplicação

Para iniciar, primeiro faça um clone do repositório utilizando o comando abaixo:

```bash
  git clone https://github.com/franciscofeo/Excel2DB.git
```

Após isso, vá para a pasta raiz do repositório e agora você pode iniciar a aplicação, lembre-se somente de ter o banco de dados MySQL instalado na sua máquina. Lembre-se de configurar o arquivo application.yml com a sua senha e usuário do MySQL.

Se já possuir o gradle instalado, utilize o seguinte comando:

```bash
    gradle bootRun
```

Caso contrário, você pode iniciar a partir da sua IDE de preferência.


Após esses comandos e aguardar alguns segundos, a aplicação estará funcionando na porta 8080, como padrão. Dessa forma, basta ver que foi criado um novo schema chamado _db_excelapi_ e uma tabela _customers_ no seu banco de dados MySQL.


## Utilizando a API

Criei algumas rotas para serem utilizados os métodos HTTP. Utilize **Postman** ou **Insomnia** para a manipulação das requisições.

##### - Rota raiz /customers
São permitidos os métodos GET e POST, para a listagem e cadastro de novos clientes, respectivamente.

##### - Rota /customers/update/{id}
É permitido apenas o método PUT para a atualização do cliente.

##### - Rota /customers/delete/{id}
É permitido apenas o método DELETE para a deleção do cliente.

##### - Rota /customers/{filename}
É permitido apenas o método POST para o início da carga do arquivo Excel para o Banco de Dados, atente-se ao fato de que é necessário
escrever o arquivo junto com sua extensão, por exemplo: _customers.xlsx_.

##### - Rota /customers/upload
É permitido apenas o método POST onde vai ser feito o carregamento do arquivo, utilize um dos programas citados acima para realizar essa
operação.

## FAQ

#### Posso utilizar livremente a API?

Com certeza! O uso é livre, lembre-se de apenas dar os devidos créditos.

#### Encontrei algum bug, como entro em contato?

Você pode mandar um email para franciscoangelo.feo@gmail.com ou entrar em contato aqui mesmo pela plataforma.