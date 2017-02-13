# HW4 - Lenguajes

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

