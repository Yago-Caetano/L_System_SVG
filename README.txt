Projeto: N1 2B

Desafio: L-Systems
Codificação em Java

Gramática da linguagem:

Σ   ☞ Alfabeto da linguagem
n   ☞ Passos, etapas
ω   ☞ Axioma, condição inicial
pX  ☞ Regras de produção

Σ: D,+,-
n: 9
ω: +D-D
P: D -> +D
P: + -> -D+

Explicação:

D = Desenha a linha na tela
+ = Rotaciona o cursor de desenho no sentido horário com o passo de 90º
- = Rotaciona o cursor de desenho no sentido anti-horario com o passo de 90º