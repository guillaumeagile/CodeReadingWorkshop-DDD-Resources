%define STDOUT 1
EXIT  equ 1
WRITE equ 4 

;************************************************************

section .data
szHello: db "Bonjour le monde.",10,0
szMessFinPgm: db "Fin normale du programme.",10,0

;************************************************************

section .bss
;************************************************************

section .text
global  main               ; déclaration de main en global
main:

    mov eax,szHello        ; 
    call afficherMess

    mov eax,szMessFinPgm   ; 
    call afficherMess
                           ; 
    mov eax,EXIT           ; 
    mov ebx,0              ; 
    int 0x80               ; 
;************************************************************

afficherMess:
    push eax
    push ebx
    push ecx
    push edx
    mov ecx,eax         ; 
    mov edx,0           ; 
.A1:                    ; 
    cmp byte [eax,edx],0
    je .A2
    add edx,1
    jmp .A1
.A2:
    mov eax,WRITE       ; 
    mov ebx,STDOUT      ; 
    int 0x80
    pop edx
    pop ecx
    pop ebx
    pop eax
    ret                 ; retour programme principal