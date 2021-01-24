# Avaliação 02 Objetos, Estado e Comportamento

_Classroom assignment_ <https://classroom.github.com/a/5i45mndR> 👈 clique neste link para clonar e ter sua cópia deste repositório.

## Modelar e implementar respeitando os princípios básicos de Orientação a Objetos

**Assuntos:** Abstrações, Classes, Objetos, Construtores, Validade, Atributos, Estado, Comportamento, Comandos e Consultas, Excepcionalidades, Especificações.

**NÃO ALTERE OS CASOS DE TESTE SEM PRÉVIA AUTORIZAÇÃO DO PROFESSOR.**

### Implementar Máquina D'água

Considere um máquina de água sofisticada. Ela é abastecida com uma Bombona de _20L_ e sempre que isso é feito um botão _abastecer água_ é pressionado, efetuando o _reset_ do contador para _20L_ (ou _20000mL_) disponíveis. A máquina também armazena internamente os copos descartáveis, de _200mL_ e _300mL_, com um repositório de 100 unidades para cada. Feito os abastecimentos, os usuários servem-se de água pressionando os botões que servem _200mL_ ou _300mL_. A máquina automaticamente saca um copo e o enche de água. A máquina mostra no painel a quantidade de água e copos disponíveis. Quando um botão _servir_ é pressionado e não há água ou copo, naturalmente o pedido não é atendido.

Dada esta especificação nosso analista projetou a seguinte interação conforme os Casos de Teste a seguir:

```java
MaquinaAgua maq = new MaquinaAgua();
System.out.println(maq.agua() == 0); // mL
System.out.println(maq.copos200() == 0);
System.out.println(maq.copos300() == 0);

maq.servirCopo200(); // não efetua, pois não há copo nem água

System.out.println(maq.agua() == 0); // mL
System.out.println(maq.copos200() == 0); // unidades
System.out.println(maq.copos300() == 0); // unidades

maq.abastecerAgua(); // inicializa 20000mL
System.out.println(maq.agua() == 20000); // mL

maq.abastecerAgua(); // mantém consistente
System.out.println(maq.agua() == 20000); // mL

maq.servirCopo200(); // não efetua, sem copo
System.out.println(maq.agua() == 20000); // mL

System.out.println(maq.copos200() == 0);
maq.abastecerCopo200(); // agora a máquina possui 100 copos de 200
System.out.println(maq.copos200() == 100);

maq.servirCopo200(); // -200
maq.servirCopo200(); // -200
maq.servirCopo200(); // -200
maq.servirCopo200(); // -200
maq.servirCopo200(); // -200, isto é, -1000ml e 5 copos de 200

System.out.println(maq.agua() == 19000);
System.out.println(maq.copos300() == 0);
System.out.println(maq.copos200() == 95);
maq.abastecerCopo200(); // agora a máquina possui 100 copos de 200 novamente
System.out.println(maq.copos200() == 100);

maq.servirCopo200(); // -200ml e 1 copo de 200
System.out.println(maq.agua() == 18800);
System.out.println(maq.copos200() == 99);

System.out.println(maq.copos300() == 0);
maq.servirCopo300(); // não efetua, não há copo 300
maq.abastecerCopo300(); // agora a máquina possui 100 copos de 300
System.out.println(maq.copos300() == 100);
maq.servirCopo300(); // agora efetua
System.out.println(maq.agua() == 18500);
System.out.println(maq.copos200() == 99);
System.out.println(maq.copos300() == 99);

// servir 50 copos de 300 = -15000ml
for (int i = 0; i < 50; i++) maq.servirCopo300();

System.out.println(maq.agua() == 3500);
System.out.println(maq.copos200() == 99);
System.out.println(maq.copos300() == 49);

// servir 17 copos de 200 = 3400ml
for (int i = 0; i < 17; i++) maq.servirCopo200();

System.out.println(maq.agua() == 100);
System.out.println(maq.copos200() == 82);
System.out.println(maq.copos300() == 49);

// não há água para atender o pedido
maq.servirCopo300();
System.out.println(maq.agua() == 100);
System.out.println(maq.copos200() == 82);
System.out.println(maq.copos300() == 49);

// não há água para atender o pedido
maq.servirCopo200();
System.out.println(maq.agua() == 100);
System.out.println(maq.copos200() == 82);
System.out.println(maq.copos300() == 49);

maq.abastecerAgua(); // inicializa 20000mL
System.out.println(maq.agua() == 20000);
System.out.println(maq.copos200() == 82);
System.out.println(maq.copos300() == 49);

// servir os 49 copos de 300 restantes = 14700ml
while (maq.copos300() > 0) maq.servirCopo300();

System.out.println(maq.agua() == 5300);
System.out.println(maq.copos200() == 82);
System.out.println(maq.copos300() == 0);

// não há copo para atender o pedido
maq.servirCopo300();
System.out.println(maq.agua() == 5300);
System.out.println(maq.copos200() == 82);
System.out.println(maq.copos300() == 0);

maq.servirCopo200(); // de 200 ok
maq.servirCopo200(); // de 200 ok

System.out.println(maq.agua() == 4900);
System.out.println(maq.copos200() == 80);
System.out.println(maq.copos300() == 0);

maq.abastecerCopo300(); // 100 copos de 300
System.out.println(maq.agua() == 4900);
System.out.println(maq.copos200() == 80);
System.out.println(maq.copos300() == 100);

// servir 3 copos de 300
maq.servirCopo300(); maq.servirCopo300(); maq.servirCopo300();

System.out.println(maq.agua() == 4000);
System.out.println(maq.copos200() == 80);
System.out.println(maq.copos300() == 97);
```

### Máquina D'água Configurável

A máquina de água a seguir é idêntica a anterior, porém permite configurar sua capacidade e lança exceções para operações inválidas.

```java
MaquinaAguaConfiguravel maquinaCustom = new MaquinaAguaConfiguravel(10000, 30, 20);

System.out.println(maquinaCustom.capacidadeAgua == 10000); // mL
System.out.println(maquinaCustom.capacidadeCopos200 == 30);
System.out.println(maquinaCustom.capacidadeCopos300 == 20);

// As três linhas a seguinte não devem compilar pois estes atributos devem ser imutáveis:
maquinaCustom.capacidadeAgua = 100000;
maquinaCustom.capacidadeCopos200 = 300;
maquinaCustom.capacidadeCopos300 = 200;

// Checando armazenamento
System.out.println(maquinaCustom.agua() == 0); // mL
System.out.println(maquinaCustom.copos200() == 0);
System.out.println(maquinaCustom.copos300() == 0);

maquinaCustom.abastecerAgua();
maquinaCustom.abastecerCopo200();
maquinaCustom.abastecerCopo300();
System.out.println(maquinaCustom.agua() == 10000);
System.out.println(maquinaCustom.copos200() == 30);
System.out.println(maquinaCustom.copos300() == 20);

maquinaCustom.servirCopo200(); // -200
maquinaCustom.servirCopo200(); // -200
maquinaCustom.servirCopo200(); // -200
maquinaCustom.servirCopo200(); // -200
maquinaCustom.servirCopo200(); // -200

System.out.println(maq.agua() == 9000);

MaquinaAguaConfiguravel maquininha = new MaquinaAguaConfiguravel(1000, 6, 3);

System.out.println(maquininha.capacidadeAgua == 1000); // mL
System.out.println(maquininha.capacidadeCopos200 == 6);
System.out.println(maquininha.capacidadeCopos300 == 3);
maquininha.abastecerAgua();
maquininha.abastecerCopo200();
maquininha.abastecerCopo300();
System.out.println(maquininha.agua() == 1000);
System.out.println(maquininha.copos200() == 6);
System.out.println(maquininha.copos300() == 3);

maquininha.servirCopo200(); // -200
maquininha.servirCopo200(); // -200
maquininha.servirCopo200(); // -200
maquininha.servirCopo200(); // -200
maquininha.servirCopo200(); // -200

System.out.println(maquininha.agua() == 0);
System.out.println(maquininha.copos200() == 1);
System.out.println(maquininha.copos300() == 3);

try {
  maquininha.servirCopo200(); // deve lançar exceção
  System.out.println(false); // esta linha não deve ser executada
} catch (Exception e) {
  System.err.println("true " + e.getMessage()); // Não há água
}

maquininha.abastecerAgua();
System.out.println(maquininha.agua() == 1000);
System.out.println(maquininha.copos200() == 1);
System.out.println(maquininha.copos300() == 3);

maquininha.servirCopo200(); // -200
System.out.println(maquininha.agua() == 800);
System.out.println(maquininha.copos200() == 0);

try {
  maquininha.servirCopo200(); // deve lançar exceção
  System.out.println(false); // esta linha não deve ser executada
} catch (Exception e) {
  System.err.println("true " + e.getMessage()); // Não há copos de 200mL
}


// Máquinas inválidas devem lançar exceção

try {
  MaquinaAguaConfiguravel maqinvalida = new MaquinaAguaConfiguravel(1000, 0, 3);
  System.out.println(false); // esta linha não deve ser executada
} catch (Exception e) {
  System.err.println("true " + e.getMessage()); // Copos de 200mL deve ser positivo
}

try {
  MaquinaAguaConfiguravel maqinvalida = new MaquinaAguaConfiguravel(1000, 10, 0);
  System.out.println(false); // esta linha não deve ser executada
} catch (Exception e) {
  System.err.println("true " + e.getMessage()); // Copos de 300mL deve ser positivo
}

try {
  MaquinaAguaConfiguravel maqinvalida = new MaquinaAguaConfiguravel(-1000, 10, 10);
  System.out.println(false); // esta linha não deve ser executada
} catch (Exception e) {
  System.err.println("true " + e.getMessage()); // Quantidade água deve ser positivo
}

// Máquina de 500 litros!
MaquinaAguaConfiguravel maquinao = new MaquinaAguaConfiguravel(500000, 3000, 2000);
maquinao.abastecerAgua();
maquinao.abastecerCopo300();
// Esvaziando a máquina
try { // servindo enquanto houver água
  maquinao.servirCopo300();
} catch (Exception e) {
  System.err.println("true: acabou a água");
}
System.out.println(maquinao.agua() == 200);
System.out.println(maquinao.copos300() == 334);

```

### Implementar Forno

Considere um Forno sofisticado de controle via app Android/iOS. É possível ligar, desligar, ajustar temperatura e outros detalhes. Os modelos variam segundo seu volume, tensão, potência e dimensões (na forma largura, altura e profundidade em `cm`). Então, implemente conforme especificação a seguir.

Casos de Teste:
```java
Forno f = new Forno(45, 220, 1700, 66, 40, 54);
System.out.println(f.volume == 45);
System.out.println(f.tensao == 220);
System.out.println(f.potencia == 1700);
System.out.println(f.largura == 66);
System.out.println(f.altura == 40);
System.out.println(f.profundidade == 54);
// todos esses atributos devem ser constantes, as atribuções a seguir não podem compilar,
// verifique se estão protegidas e então comente estas linhas:
f.volume = 450;
f.tensao = 2200;
f.potencia = 17000;
f.altura = 400;
f.largura = 660;
f.profundidade = 540;

// Novo Forno
Forno forno = new Forno(84, 220, 1860, 61, 58, 58);
System.out.println(forno.volume = 84);
System.out.println(forno.tensao = 220);
System.out.println(forno.potencia = 1860);
System.out.println(forno.altura = 58);
System.out.println(forno.largura = 61);
System.out.println(forno.profundidade = 58);

// métodos para consulta
System.out.println(forno.temperatura()); // 0 (de 50 a 300)
System.out.println(forno.ligado()); // false
// os atributos temperatura e ligado devem ser inacessíveis (privados)
// não deve compilar, verifique e depois comente as seguintes linhas
System.out.println(forno.temperatura);
System.out.println(forno.ligado);
//
System.out.println(forno.ligado() == false);
forno.aumentarTemperatura(); // liga e vai para 50
System.out.println(forno.ligado() == true);
System.out.println(forno.temperatura() == 50); // 50
forno.aumentarTemperatura();
System.out.println(forno.temperatura() == 100); // 100
forno.aumentarTemperatura();
System.out.println(forno.temperatura() == 150); // 150
forno.aumentarTemperatura();
System.out.println(forno.temperatura() == 200); // 200
forno.aumentarTemperatura();
System.out.println(forno.temperatura() == 220); // 220
forno.aumentarTemperatura();
System.out.println(forno.temperatura() == 250); // 250
forno.aumentarTemperatura();
System.out.println(forno.temperatura() == 300); // 300

forno.aumentarTemperatura(); // está no máximo
System.out.println(forno.temperatura() == 300); // 300
System.out.println(forno.ligado() == true);
// reduzindo
forno.diminuirTemperatura();
forno.diminuirTemperatura();
forno.diminuirTemperatura();
System.out.println(forno.temperatura() == 200); // 200
// desligando direto
forno.desligar();
System.out.println(forno.ligado() == false);
System.out.println(forno.temperatura() == 0);
// já está desligado
forno.diminuirTemperatura();
System.out.println(forno.ligado() == false);
System.out.println(forno.temperatura() == 0);

// timer de 1 a 120 minutos
forno.setTimer(15); // minutos
forno.aumentarTemperatura();
forno.aumentarTemperatura();
forno.aumentarTemperatura();
System.out.println(forno.ligado() == true);
System.out.println(forno.temperatura() == 150);
System.out.println(forno.tempoRestante() == 15);
forno.tick(); // tick do timer (baixa 1min)
System.out.println(forno.tempoRestante() == 14);
forno.tick(); forno.tick(); forno.tick(); forno.tick();
System.out.println(forno.tempoRestante() == 10);
System.out.println(forno.ligado() == true);
System.out.println(forno.temperatura() == 150);
forno.tick(); forno.tick(); forno.tick(); forno.tick(); forno.tick();
forno.tick(); forno.tick(); forno.tick(); forno.tick(); forno.tick();
System.out.println(forno.tempoRestante() == 0);
System.out.println(forno.ligado() == false);
System.out.println(forno.temperatura() == 0);
// novo timer
forno.setTimer(120);
forno.aumentarTemperatura(); forno.aumentarTemperatura();
System.out.println(forno.ligado() == true);
System.out.println(forno.temperatura() == 100);
System.out.println(forno.tempoRestante() == 120);

while (forno.ligado()) forno.tick(); // tic tac até desligar

System.out.println(forno.tempoRestante() == 0);
System.out.println(forno.ligado() == false);
System.out.println(forno.temperatura() == 0);
```

### Modelar e implementar TV

Considere um aparelho de televisão. Cada uma têm um fabricante, modelo, tamanho e resolução. Além disso, a operação da TV é bem simples, deve permitir aumentar e baixar o volume, numa escala de 0 a 100%, e mudar o canal, suportando apenas a faixa UHF, de 2 a 69.

Dada essa especificação, modele, projete e implemente uma classe `TV`, que atenda às características mencionadas, respeitando a imutabilidade e os métodos comandos e consultas que representem as operações descritas. Escreva pelo menos 20 Casos de Teste, para situações comuns e excepcionais.

Desafio: implementar o _mudo_, _ir para canal_ e _voltar canal_ (não obrigatório).

### Especificar um Objeto

Escreva uma especificação textual descrevendo as características e operações de um objeto. Pode ser físico, tangível, como a TV e Caneta, ou não, como a Conta Corrente, Fração. Após, faça a especificação operacional escrevendo os casos de teste.

**Não é para implementar, só especificar (escrever os casos de teste).**

Espera-se alguns (mais de um) atributos e métodos comando e consulta. Escreva quantos testes forem necessários para cobrir o caminho feliz e as situações excepcionais.

* * *

> _"First, solve the problem.
> Then, write the code."_
>
> -- **John Johnson**
