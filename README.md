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
- epxression()
