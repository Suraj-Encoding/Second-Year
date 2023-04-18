; # Assignment-3 -> Count in array  
; # Name: Suraj Dalvi - A44
; # Write ALP to count the number of positive and
;   negative numbers from the array

; # data section
section .data
nline db 10,10
nline_len equ $-nline
ano db 10, "Positive or Negative numbers from 64-bit array: ",10
ano_len equ $-ano
arr64 dq -21H,5H,-33H,-20H,62H
n equ 5
pmsg db 10,"The number of positive elements in array: "
pmsg_len equ $-pmsg
nmsg db 10,10,"The number of negative elements in array: "
nmsg_len equ $-nmsg

; # bss section
section .bss
p_count resq 1
n_count resq 1
char_ans resb 16

; # macro for print
%macro Print 2
mov rax,1
mov rdi,1
mov rsi,%1
mov rdx,%2
syscall
%endmacro

; # macro for read
%macro Read 2
mov rax,0
mov rdi,0
mov rsi,%1
mov rdx,%3
syscall
%endmacro

; # macro for exit
%macro Exit 0
mov rax,60
mov rdi,0
syscall
%endmacro

; # text section
section .text
global _start
_start:
Print ano,ano_len
mov rsi,arr64
mov rcx,n
mov rbx,0
mov rdx,0

; # Labels

next_num:
mov rax,[rsi] 
Rol rax,1
jc negative

positive:
inc rbx
jmp next

negative:
inc rdx

next:
add rsi,8
dec rcx
jnz next_num

mov [p_count],rbx
mov [n_count],rdx

Print pmsg,pmsg_len
mov rax,[p_count]
call disp64_proc

Print nmsg,nmsg_len
mov rax,[n_count]
call disp64_proc

Print nline,nline_len
Exit


disp64_proc:
mov rbx,16
mov rcx,2
mov rsi,char_ans + 1

cnt:
mov rdx,0
div rbx
cmp dl,09H
jbe add30
add dl,07H

add30:
add dl,30H
mov [rsi],dl
dec rsi

dec rcx
jnz cnt

Print char_ans,2
ret