; 1st section
section .data
   
   ; block variables
   sblock db 10h,20h,30h,40h,50h,60h,70h    ;source block
   dblock times 7 db 0h  ; destination block
   
   ; message variables
   smsg db 10,"Source Block: "
   smsg_len equ $-smsg
   
   dmsg db 10,"Destination Block: "
   dmsg_len equ $-dmsg
   
   ; extra variables
   space db " "
   nline db 10
   
   before db 10,"# Before Trasnfer:"
   blen equ $-before
   
   after db 10,"# After Transfer: "
   alen equ $-after
   
   topic db 10,"# Assignment-6 : Non-Overlapped Block Transfer #",10
   tlen equ $-topic
   
   
;-----------------------------------------------------------------------------

; 2nd section
section .bss
char_ans resb 2

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
  
  ; display block before transfer
  print before,blen 
  
  print smsg,smsg_len
  mov rsi,sblock
  call block_display
  
  print dmsg,dmsg_len
  mov rsi,dblock
  call block_display
   
  ; call block transfer procedure
  call block_transfer
  
  ; display block after transfer
  print nline,1
  print after,alen
  
  print smsg,smsg_len
  mov rsi,sblock
  call block_display
  
  print dmsg,dmsg_len
  mov rsi,dblock
  call block_display
  
  ; exit from the program
  print nline,1
  exit 
   
;-----------------------------------------------------------------------------

; block transfer procedure
block_transfer:

mov rsi,sblock
mov rdi,dblock
mov rcx,7

back:

; # without string instruction
; mov al,[rsi]
; mov [rdi],al

; inc rsi
; inc rdi 

; dec rcx
; jnz back
; ret

; # with string instruction (movs)
CLD ; Inc rsi and rdi
rep movsb
ret

;Note:
;   1. cld: used to move in forward direction
;   2. rep: It repeats movsb and decrement the rcx until it becomes zero
;   3. movsb: contain transfer 



;-----------------------------------------------------------------------------

; block display procedure
block_display:
mov rbp,7

next_num:
mov al,[rsi]
push rsi

call display
print space,1 ; print one spcce

pop rsi
inc rsi
dec rbp 
jnz next_num
ret

;-----------------------------------------------------------------------------

; display procedure
display: 
   mov rbx,16  
   mov rcx,2   
   mov rsi, char_ans+1 
   
   next_digit:
   mov rdx,0 
   ;xor rdx,rdx  --> means rdx = 0
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
  
   print char_ans,2
   ret 

;-----------------------------------------------------------------------------





