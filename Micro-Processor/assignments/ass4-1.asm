; 1st section
section .data

   topic db 10,"# Assignment-4 (Part-1) : BCD TO HEX  #",10
   tlen equ $-topic
   
   bmsg db 10,"Enter 5 Digit BCD Number: "
   blen equ $-bmsg
   
   hmsg db 10,"Equivalent 4 Digit Hex Number: "
   hlen equ $-hmsg
   
   nline db 10
   
   
;-----------------------------------------------------------------------------

; 2nd section
section .bss
buf resb 6
char_ans resb 4
ans resw 1  ;1w = 2b = 16bits

;-----------------------------------------------------------------------------

; print macro 
%macro print 2 
    mov rax, 1     
    mov rdi, 1     
    mov rsi, %1  
    mov rdx, %2   
    syscall
%endmacro 

;-----------------------------------------------------------------------------

; read macro 
%macro read 2 
    mov rax, 0     
    mov rdi, 0     
    mov rsi, %1  
    mov rdx, %2   
    syscall
%endmacro 

;-----------------------------------------------------------------------------

; exit macro
%macro exit 0 
    mov rax, 60    
    mov rdi, 0     
    syscall 
%endmacro

;-----------------------------------------------------------------------------
    
; 3rd section
section .text
    global _start 
    
_start:
  
  ; display topic name
  print topic,tlen
  
  ; call procedure
  call BCD_HEX
  
  ; exit from the program
  print nline,1
  exit 
   

;-----------------------------------------------------------------------------

BCD_HEX:

;Read BCD number
print bmsg,blen
read buf,6   ;5 digit + 1 enter key

mov rsi,buf
xor rax,rax  ;rax=0
mov rbp,5
mov rbx,10

; Formula : ax * bx + cl
next:
xor cx,cx  ;cx=0
mul bx ; ax = ax*bx
mov cl,[rsi]
sub cl,30h
add ax,cx

inc rsi
dec rbp
jnz next

mov [ans],ax
print hmsg,hlen
mov ax,[ans]
call display
ret

;-----------------------------------------------------------------------------


; display procedure
display: 
   mov rbx,16  
   mov rcx,4   
   mov rsi, char_ans+3 
   
   next_digit:
   mov rdx,0 
   div rbx 
    
   cmp dl,09h
   jbe add30
   add dl,07h
   
   add30: 
   add dl,30h
   
   mov [rsi],dl
   dec rsi
   dec rcx
   jnz next_digit
  
   print char_ans,4
   ret 

;-----------------------------------------------------------------------------
