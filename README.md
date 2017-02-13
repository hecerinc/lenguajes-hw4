# HW4 - Lenguajes

## Grammar

<stmt> → <expression>EOI
<expression> → <func> | <factor>
<func> → FUNCTION(<param> PARAMETER_SEP <param>)
<param> → <func> | <factor>
<factor> → VARIABLE | INTEGER | DOUBLE
