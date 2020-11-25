# Sobre o projeto
Projeto de estudo do curso de Solid Java da Alura

# SOLID
S - Single Responsibility <br>
O - Open/Closed Principle<br>
L - Liskov Substitution <br>
I - Interface Segregation <br>
D - Dependency Inversion <br>

## Single Responsibility - Coesão e Acoplamento
### Como verificar se o seu código é coeso? Se atente aos sinais :
- A classe tende a crescer infinitamente? <br>
- A classe tem uma única responsabilidade? <br>

### Todo acoplamento é problemático?
Não, quando o acoplamento é estável, quando o acoplamente tende a não sofrer muitas alteraçoes é um sinal de "bom acoplamento".
Por exemplo : A interface List do java. A Oracle não pode alterar List por qualquer motivo, pois alterando List muitas mudanças precisarão ser feitas em todas as suas implementações. List tende a mudar pouco, tende a ser uma interface estável. Sendo estável a chance de propagar um erro para a classe que a utiliza é muito menor. Precisamos nos acoplar com classes/ interfaces/ módulos estáveis. 

### Design pattern Observer
No exemplo do cap2 foi utilizado o pattern observer para diminuir o acoplamento

## Open Closed Pinciple (OCP) - Princípio do aberto e fechado
Classes precisam ser abertas para extensão, ou seja, tem que conseguir mudar o comportamento dela de maneira fácil, e ela precisa ser fechada para alteração, não é para irmos nela o tempo inteiro para mexermos em um if a mais ou alguma coisa do tipo. 

No cap. 3 tínhamos o problema que poderíamos ter diversas tabelas de preço 
e serviços de entrega, e para resolver os problemas e evitar diversos controles com ifs,
nós criamos uma abstração para as tabelas de preço e outra para os serviços de entrega.<br>

Agora, para alterar o comportamento da calculadora, basta passarmos uma implementação diferente no seu construtor. Com isso abrimos a app para extensão sem precisar de grandes alerações

### Dependency Inversion Principle (DIP) - Princípio da inversão de dependência
- A ideia é que classes sempre passem a depender de classes mais estáveis do que ela própria.
- Depender sempre de abstrações, nunca depender de implementações

## Liskov Substitution
## Interface Segregation
## Dependency Inversion