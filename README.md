# Sobre o projeto
Projeto de estudo do curso de Solid Java da Alura

# SOLID
S - Single Responsibility <br>
O - Open/Closed Principle <br>
L - Liskov Substitutive Principle <br>
I - Interface Segregation Principle<br>
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

### Encapsulamento 
- Sinal que uma classe está mal encapsulada, perceba que ela sabe demais do comportamento de uma outra classe
```java
NotaFiscal nf = new NotaFiscal();
double valor;

if (nf.getValorSemImposto() > 10000){
    valor = 0.06 * nf.getValor();
} else {
    valor = 0.12 * nf.getValor();
}
```
Como resolver essa situação : 
```java
NotaFiscal nf = new NotaFiscal();
double valor = nf.calcularValorImposto();
```
A regra está escondida dentro da NotaFiscal, caso seja preciso alterar alguma coisa nessa regra, será feito somente na classe NotaFiscal e esse comportamento se espalhará para todo o sistema. 
Esse é o princípio do "Tell, do not ask". Diga o que fazer, não pergunte em diversas partes do sistema com ifs

- Como descobrir se um código está bem encapsulado. Se faça 2 perguntas : 
<br>1- O quê o método faz?<br> R: Sabemos o que o método faz pelo seu nome
<br>2- Como ele faz?<br> R:Não sabemos qual sua implementação, ela está escondia, está encapsulada.<br>

O que ganhamos escondendo a implementação?<br>
R: Trocando o comportamento da implementação, os clientes não serão afetados. Precisamos realizar a alteração em um único ponto do sistema

- Seguir a Lei de Demeter, que diz que devemos evitar sequenciamento de gets, pois dessa forma nós também acabamos quebrando o encapsulamento, por exemplo :
```java
fatura.getCliente().marcarComoInadimplente();
```
Se a classe cliente mudar, se ela não tiver mais esse método marcarComoInadimplente, o código vai quebrar em todo lugar que usa um cliente e em todo lugar que usa uma fatura que usa um cliente ao mesmo tempo, que usa um cliente de maneira indireta.
<br>
A ideia é resolvermos essa situação dentro da própria fatura. 
```java
fatura.marcarClienteComoInadimplente();
```
- Precisamos tomar cuidado com getters/ setters. Nem sempre devemos deixar a modificação de alguns atributos abertas para todo o sistema. Exemplo: se uma fatura está paga ou não e as listas de pagamentos de uma fatura. São informações critícas do ponto de vista do negócio que precisam ter um cuidado especial.
Dentro deste assunto, tomar cuidado com as listas. Pois só com o get nós conseguimos alterar o valor do atributo 
```java
fatura.getPagamentos().add(pagamento);
```

Como resolver: <br>
```java
public List<Pagamento> getPagamentos(){
    return Collections.unmodifiableList(this.pagamentos);
}
```
Desta forma, caso alguém tente incluir   um pagamento na fatura via o getPagamentos será lançada uma exceção

## Liskov Substitutive Principle
Por que fazer bom uso da herança é difícil? <br>
R: Porque para se fazer bom uso de herança, o desenvolvedor deve pensar em cada método que a classe filha herdou e sobrescreveu, e lembrar que as pré-condições não podem ser apertadas, e as pós-condições não podem serem afrouxadas.
Isso não é tão simples, e requer muito raciocínio do desenvolvedor, sempre que for reescrever um comportamento.
<br>
Qual a alternativa para se reaproveitar comportamento, sem fazer uso de herança?<br>
R: Você pode fazer uso de composição para reaproveitar comportamentos. Diferente da herança, ao compor um objeto, você não precisa se preocupar com as pré e pós condições.
No entanto, ao fazer uso de herança, você ganha o uso de polimorfismo. Quando bem usada, a herança também é uma excelente opção. 

## Interface Segregation Principle (ISP)
Afirma que nenhum cliente deve ser forçado a depender de métodos que não utilize. ISP divide interfaces que são muito grandes em menores e mais específicas, para que os clientes só necessitem saber sobre os métodos que são de interesse para eles.

Quais são as vantagens de fazer com que classes dependam apenas de métodos que precisam?<br>
R: Novamente, é propagação de mudanças. Se a interface mudar, a mudança tende a ser propagada em menos pontos.

## Dependency Inversion Principle (DIP)
- Ideia de sempre depender de classes/ módulos mais estáveis
- Dependa de abstrações e não de implementações
- A própria abstração depender de outras abstrações


