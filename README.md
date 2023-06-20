# Projeto CRUD com Banco de Dados (MySQL) - README

Seja bem-vindo(a) ao projeto CRUD com integração ao banco de dados MySQL! Neste projeto, fiz minha primeira tentativa de criar um sistema que permite realizar operações de criação, leitura, atualização e exclusão de registros, utilizando o padrão de arquitetura MVC (Model-View-Controller).

## Sobre o Projeto

O objetivo principal do projeto era construir um sistema capaz de gerenciar informações de alunos e professores em um ambiente acadêmico. Para isso, desenvolvemos manualmente todos os métodos de conexão com o banco de dados e os métodos de CRUD para as entidades Aluno e Professor.

## Estrutura das Classes

### Classe Aluno

A classe `Aluno` é responsável por representar os dados de um aluno em nosso sistema. Ela possui os seguintes atributos:

- `id`: um identificador único para o aluno.
- `nome`: o nome completo do aluno.
- `ra`: o Registro Acadêmico do aluno.
- `rg`: o Registro Geral do aluno.

### Classe Professor

A classe `Professor` é responsável por representar os dados de um professor em nosso sistema. Ela possui os seguintes atributos:

- `id`: um identificador único para o professor.
- `nome`: o nome completo do professor.
- `rgf`: o Registro Geral de Funcionário do professor.
- `rg`: o Registro Geral do professor.

## Telas de Interação com o Usuário

Para proporcionar uma experiência amigável, desenvolvemos as telas de interação com o usuário utilizando a biblioteca Swing. Com essa abordagem, os usuários podem visualizar e manipular os dados por meio de uma interface gráfica intuitiva.

Embora não tenhamos fornecido detalhes específicos sobre as telas em questão, elas foram projetadas levando em consideração a utilização das classes Aluno e Professor mencionadas anteriormente. Dessa forma, é possível exibir e editar os dados dessas entidades na interface do usuário.

## Configuração do Banco de Dados

É importante ressaltar que nosso sistema requer o uso de um servidor MySQL devidamente configurado em seu ambiente de desenvolvimento. Certifique-se de ter o servidor MySQL instalado e execute as seguintes etapas:

1. Crie um banco de dados no servidor MySQL.
2. Crie as tabelas correspondente.. para armazenar os registros de alunos e professores. 
3. `baixe o drive JDBC do mysql v8.0.31`

A estrutura da tabela `aluno` pode ser definida da seguinte forma:

```sql
CREATE TABLE aluno (
    id INT PRIMARY KEY,
    nome VARCHAR(100),
    ra VARCHAR(20),
    rg VARCHAR(20)
);
```

A estrutura da tabela `professor` pode ser definida da seguinte forma:

```sql
CREATE TABLE professor (
    id INT PRIMARY KEY,
    nome VARCHAR(100),
    rgf VARCHAR(20),
    rg VARCHAR(20)
);
```

4. Não se esqueça de ajustar as configurações de conexão com o banco de dados no código-fonte. Verifique a classe responsável pela conexão (`conectarDAO`) e faça as alterações necessárias, como nome do servidor, nome do banco de dados, usuário e senha.

## Considerações Finais

Foi um prazer criar este projeto de CRUD com integração ao banco de dados MySQL. Através dele consegui solidos conhecimento em POO e como é o funcionamento do da arquitetura MVC.

## Autor do Projeto
[Yuri Mathaus](https://github.com/yurimcf)
