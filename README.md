//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========/
# Sistema de Gerenciamento de RPG

## Iniciar o projeto pelo intelliJ IDEA

## Execultar o projeto pelo POSTMAN ##

## Funcionalidades
• Cadastrar Personagem: Selecionar a opção POST no menu, e na URL preencha com http://localhost:8080/personagens, após inserir o corpo da requisição abaixo. Obs: No campo "classe" favor preencher o nomes (GUERREIRO, MAGO, ARQUEIRO, LADINO ou BARDO) todas as letras em maiúsculas.
    {
        "nome": "Lucas",
        "nomeAventureiro": "Player 01",
        "classe": "ARQUEIRO", 
        "nivel": 3,
        "forca": 4,
        "defesa": 6
    }

• Listar Personagem: Selecione a opção GET no menu, e na URL preencha com http://localhost:8080/personagens. Como é uma requisição GET, não é necessário configurar o corpo(Body).

• Buscar Personagem por Identificador: Selecione a opção GET no menu, e na URL preencha com http://localhost:8080/personagens/1 (substitua 1 pelo id do personagem cadastrado). Como é uma requisição GET, não é necessário configurar o corpo(Body).

• Atualizar Nome de Guerreiro por Identificador: Selecione a opção get e selecione PUT no menu, e na URL preencha com localhost:8080/personagens/1/nome-aventureiro. Configurar o corpo(Body) no postman, escolha o formato raw e selecione JSON no menu e assim insira o novo nome do aventureiro como uma string JSON. EX: NovoNomeAventureiro (Não precisa colocar " no inicio e no fim do novo nome).

• Remover Personagem: Selecione a opção DELETE no menu, e na URL preencha com http://localhost:8080/personagens/1 conforme foi feito o cadastro do personagem. Não é necessário configurar o corpo(Body).

• Cadastrar Item Mágico: Selecionar a opção POST no menu, e na URL preencha com http://localhost:8080/ItensMagicos, após inserir o corpo da requisição abaixo. Obs: No campo "tipo" favor preencher o nomes (ARMA, ARMADURA e AMULETO) todas as letras em maiúsculas.
    {
        "nome": "Espada Poderosa",
        "tipo": "ARMA",
        "forca": 10,
        "defesa": 0
    }

• Listar Itens Mágicos: Selecione a opção GET no menu, e na URL preencha com http://localhost:8080/ItensMagicos. Como é uma requisição GET, não é necessário configurar o corpo(Body).

• Buscar Item Mágico por Identificador: Selecione a opção GET no menu, e na URL preencha com http://localhost:8080/ItensMagicos/1 (substitua 1 pelo id do item cadastrado). Como é uma requisição GET, não é necessário configurar o corpo(Body).

• Adicionar Item Mágico ao Personagem: Selecionar a opção POST no menu, e na URL preencha com http://localhost:8080/personagens/{idPersonagem}/itens-magicos/{idItem}, OBS: (O idPersonagem e idItem precisam exister para fazer o adicionamento do item). Não é necessário configurar o corpo(Body).

• Buscar Amuleto do Personagem: Para fazer o teste desta funcionalidade precisa criar um personagem e criar um ItemMagico com tipo AMULETO e atribuí-lo a o personagem com isso configure o postman ao método GET, e na URL preencha com http://localhost:8080/personagens/{idPersonagem}/amuleto, OBS: (O idPersonagem precisam exister para fazer a busca do Amuleto). 
//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========/

## Regras
- Personagens têm 10 pontos para distribuir entre força e defesa.
- Força e defesa dos itens mágicos são somados aos atributos do personagem.
- Apenas um amuleto por personagem.
- Armas têm defesa 0, armaduras têm força 0.
//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========/

## Tecnologias
- Java 11
- Spring Boot
- JPA/Hibernate
- Banco H2 (em memória)
- Postman
//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========//==========/
