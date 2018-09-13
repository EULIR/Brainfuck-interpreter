# Brianfuck Interpreter
This is a Brainfuck interpreter written in Java.  
## What is *Brainfuck* 
> Brainfuck is an esoteric programming language created in 1993 by Urban Müller, and notable for its extreme minimalism.  
> The language consists of only eight simple commands and an instruction pointer. While it is fully Turing complete, it is not intended for practical use, but to challenge and amuse programmers. Brainfuck simply requires one to break commands into microscopic steps.  
> The language's name is a reference to the slang term brainfuck, which refers to things so complicated or unusual that they exceed the limits of one's understanding.  
   
   --from [Wikipedia](https://en.wikipedia.org/wiki/Brainfuck)
   
## What does *Brainfuck* look like
A HelloWorld program looks like this, consisting of only eight types of commands.
```brainfuck
++++++++++[>+++>+++++++>++++++++>++++++++++>+++++++++++<<<<<-]>>++.>>+.+++++++..>+.<<<<++.>>+++++++.>>.+++.<.--------.<<<+.
```

## Grammar of *Brainfuck*
|Character|Meaning| 
|:------:|:------:|
|`>`|increment the data pointer (to point to the next cell to the right).|
|`<`|decrement the data pointer (to point to the next cell to the left).|
|`+`|increment (increase by one) the byte at the data pointer.|
|`-`|decrement (decrease by one) the byte at the data pointer.|
|`.`|output the byte at the data pointer.|
|`,`|accept one byte of input, storing its value in the byte at the data pointer.|
|`[`|if the byte at the data pointer is zero, then instead of moving the instruction pointer forward to the next command, jump it forward to the command after the matching `]` command.|
|`]`|if the byte at the data pointer is nonzero, then instead of moving the instruction pointer forward to the next command, jump it back to the command after the matching `[` command.|  

## Features of this interpreter
- Infinite cells support
- Syntax errors detect
- Native Brainfuck grammar interpretation

## Sample syntax errors and corresponding reports in the interpreter
- Index out of bound  
Index out of bound exception would only occur when in the index of cells comes to -1, with no maximum limit would be made.
    - code example
    ```brainfuck
    ++<<.
    ```
    - error report
    ```
    IndexOutOfBoundError: Index out of bound: -1
    ```
- Unclosed left or right bracket  
Brainfuck syntax would only allow left brackets and right brackets that appear in pairs.  
Following the Java convention, the index number reported in the Error information starts from 0.  
    - code example
    ```brainfuck
    ++[+[++[>>+<
    ```
    - error report
    ```
    Unclosed [ in line 1 index 2
    Unclosed [ in line 1 index 4
    Unclosed [ in line 1 index 7
    MissBracketError: Error information has been listed above
    ```
    - code example
    ```brainfuck
    ++]
    ][]
    ```
    - error report
    ```
    Unclosed ] in line 1 index 2
    Unclosed ] in line 2 index 0
    MissBracketError: Error information has been listed above
    ```


