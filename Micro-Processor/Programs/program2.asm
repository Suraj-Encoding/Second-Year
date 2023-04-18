; # Assignment-2 -> String Length
; # Name: Suraj Dalvi - A44
; # Write ALP to accept a string and to display its length

; # data section
section .data
   msg db 10,10, "Enter the string: "
   len equ $-msg
   smsg db 10,10, "The string length is: "
   slen equ $-smsg

; # bss section
section .bss
    string resb 50
    length equ $-string
    count resb 1
    ans resb 2

; # macro for print
%macro print 2
   mov rax,1
   mov rdi,1
   mov rsi,%1 
   mov rdx,%2 
   syscall
%endmacro

; # macro for read
%macro read 2
   mov rax,0
   mov rdi,0
   mov rsi,%1 
   mov rdx,%2 
   syscall
%endmacro

; # macro for exit
%macro exit 0
     mov rax,60
     mov rdi,0
     syscall
%endmacro

; # text section
section .text
    global _start

_start:
    print msg,len
    read string, length
    mov [count], rax

    print smsg,slen
    mov rax, [count] 
    call display
    exit

; # display label
 display:
   mov rbx,10
   mov rcx,2
   mov rsi,ans+1 
   
; # count label
 cnt:
    mov rdx,0 
    div rbx  
    cmp dl,09h
    jbe add30
    add dl,07h
    
; # add label
 add30:
     add dl,30h
     mov [rsi],dl
     dec rsi 
     dec rcx 
     jnz cnt
     print ans,2  
     ret
     








