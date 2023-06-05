; 1st section
section .data

; Take one array
array dq -1h, 22h, 33h, -44h, 20h  ; dq means define 64 bits
n equ 5

; topic msg
topic db 10,"# Assignment-3 : Counting #",10
len equ $-topic

; newline
nline db 10
nlen equ $-nline


; msg for positive number
pmsg db 10,"Positive numbers count: "
pmsg_len equ $-pmsg

; msg for negative number
nmsg db 10,"Negative numbers count: "
nmsg_len equ $-nmsg

; 2nd section
section .bss
pos_count resq 1    ; resq 1  or  resb 8
neg_count resq 1
char_ans resb 2


; print macro 
%macro print 2 
    mov rax, 1     
    mov rdi, 1     
    mov rsi, %1  
    mov rdx, %2   
    syscall
%endmacro 

; exit macro
%macro exit 0 
    mov rax, 60    
    mov rdi, 0     
    syscall 
%endmacro
   
    
; 3rd section
section .text
    global _start 
    
_start:

; point rsi to the first index of an array
mov rsi,array
; set rcx as 5 (as n=5)
mov rcx,n 

; Two register for count of + and - numbers
; as rax is used for shifting purpose
mov rbx,0 ; +ve count
mov rbx,0 ; -ve count

back:
;Take array data into 'rax'
mov rax,[rsi]
shl rax,1
jc negative  
;carry generated means -ve else +ve as  1 --> -ve and 0 --> +ve

positive:
inc rbx
jmp next

negative:
inc rdx

next:
add rsi,8
dec rcx
jnz back


;store count into defined variables
mov [pos_count],rbx
mov [neg_count],rdx

;display topic msg
print topic,len

;display the +ve numbers count
print pmsg, pmsg_len
mov rax,[pos_count]
call display


;display the -ve numbers count
print nmsg, nmsg_len
mov rax,[neg_count]
call display

; Exit from the program
print nline,nlen
exit


; display procedure
display: 
   mov rbx,16   
   mov rcx,1  
   mov rsi, char_ans 
   
   label:
   mov rdx, 0
   div rbx 
    
   cmp dl,09h
   jbe add30
   add dl,07h
   
   add30: 
   add dl,30h
   
   mov [rsi],dl
   dec rsi
   dec rcx
   jnz label
  
   print char_ans, 2
   ret 


;Note: 
;      1. 1 word = 2 byte
;      2. quad word = 4 word = 8 byte = 64 bits
;      3. 1 byte = 8 bits
;      4. b --> byte    and  q --> quad






