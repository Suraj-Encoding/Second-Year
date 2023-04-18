; # Assignment-1 -> Read and Display Array 
; # Name: Suraj Dalvi - A44
; # Write ALP to accept five 64-bit Hexadecimal numbers from the user and 
;   store them in an array and display the accepted numbers

; # data section
section .data
msg1 db 10,13,"Enter 5 64 bit numbers: "
len1 equ $-msg1
msg2 db 10,13,"Entered 5 64 bit numbers: "
len2 equ $-msg2

; # bss section
section .bss
array resd 200
counter resb 1

; # text section
section .text
global _start
_start:

; # display
mov Rax,1
mov Rdi,1
mov Rsi,msg1
mov Rdx,len1
syscall

; # accept
mov byte[counter],05
mov rbx,00

; # Loop for read
loop1:
mov rax,0
mov rdi,0
mov rsi,array
add rsi,rbx
mov rdx,17
syscall
add rsi,rbx
mov rdx,17
syscall
add rbx,17
dec byte[counter]
JNZ loop1

; # display
mov Rax,1
mov Rdi,1
mov Rsi,msg2
mov Rdx,len2
syscall

; # display
mov byte[counter],05
mov rbx,00

; # Loop for write
loop2:
mov rax,1
mov rdi,1
mov rsi,array
add rsi,rbx
mov rdx,17
syscall
add rbx,17
dec byte[counter]
JNZ loop2