# HW4 - Lenguajes

Author: Hector Rincon

Student ID: A01088760

Main Class: `HW4.java`


**Special notes:** The lexical analysis exepects the elements to be separated by spaces. A test file is provided `test.in`.

```
Correct: SUM ( 3 , 4 ) ;
Incorrect: SUM(3, 4);
```

## Lexical Analyzer

### Automaton

![Automata Finito](automaton.png)

## Grammar


```
<stmt> → <expression>EOI
<expression> → <func> | <factor>
<func> → FUNCTION PARENS <param> PARAMETER_SEP <param> PARENS
<param> → <func> | <factor>
<factor> → VARIABLE | INTEGER | DOUBLE
```

## Parser Implementation 

Functions: 

- statement()
- expression()
- func()
- factor()
- param()

Matches:

- VARIABLE
- FUNCTION
- PARENS
- INTEGER
- DOUBLE
- PARAMETER_SEP
- EOI

