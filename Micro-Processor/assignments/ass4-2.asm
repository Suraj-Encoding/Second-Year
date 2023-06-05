; 1st section
section .data

   topic db 10,"# Assignment-4 (Part-2) : HEX TO BCD  #",10
   tlen equ $-topic
   
   hmsg db 10,"Enter 4 Digit Hex Number: "
   hlen equ $-hmsg
   
   bmsg db 10,"Equivalent BCD Number: "
   blen equ $-bmsg
   
   emsg db 10,"Please Enter the valid Hex Number!"
   elen equ $-emsg
   
   nline db 10
   
   
;-----------------------------------------------------------------------------

; 2nd section
section .bss
buf resb 5
ans resb 1

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
  call Hex_BCD
  
  ; exit from the program
  print nline,1
  exit 
   

;-----------------------------------------------------------------------------

Hex_BCD:

print hmsg,hlen
call accept

; actual logic
mov ax,bx
mov bx,10

xor bp,bp

label:
xor dx,dx
div bx

push dx
inc bp

cmp ax,0 
jne label

; display BCD number
print bmsg,blen
label1:
pop dx
add dl,30h
mov [ans],dl

print ans,1 
dec bp
jnz label1

ret

;-----------------------------------------------------------------------------

accept:

;read one hrx number 
read buf,4 

mov rsi,buf
mov rcx,4
xor bx,bx

back: 
shl bx,4
mov al,[rsi]

; check for valid hex number

; 0-9
cmp al,'0'
jb error
cmp al,'9'
jbe sub30

; A-F
cmp al,'A'
jb error
cmp al,'F'
jbe sub37

; a-f
cmp al,'a'
jb error
cmp al,'f'
jbe sub57

; sub label
sub57:
  sub al,20h
sub37: 
  sub al,7h
sub30:
  sub al,30h
  
  
add bx,ax
inc rsi
dec rcx
jnz back

ret

;error msg
error:
print emsg,elen

