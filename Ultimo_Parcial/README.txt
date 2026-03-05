========================================================
  PROYECTO: Sistema de Gestión — Clínica VidasPlus
  Curso   : Estructuras de Datos
  Autor   : Juan Rivera
  Versión : 1.0
========================================================

DESCRIPCIÓN
-----------
Sistema de gestión de pacientes para el área de urgencias de la Clínica
VidasPlus de Yopal. El proyecto implementa estructuras de datos lineales y
no lineales en Java puro (sin usar ArrayList ni LinkedList de la API estándar).

Módulo A — Cola de Urgencias       (ColaPacientes sobre Lista Enlazada Simple)
Módulo B — Historial Clínico       (PilaHistorial sobre Nodos Enlazados)
Módulo C — Directorio de Médicos   (BST_Medicos, Árbol Binario de Búsqueda)
Integración — SistemaClinico.java  (Punto adicional, flujo completo)

ESTRUCTURA DE PAQUETES
----------------------
src/main/java/clinica/
  modulo_a/  → Paciente, NodoPaciente, ColaPacientes, MainModuloA
  modulo_b/  → Diagnostico, NodoDiagnostico, PilaHistorial, MainModuloB
  modulo_c/  → Medico, NodoMedico, BST_Medicos, MainModuloC
  integracion/ → SistemaClinico

COMPILAR Y EJECUTAR (desde la raíz del proyecto)
-------------------------------------------------
1. Compilar:
   javac -d out src/main/java/clinica/modulo_a/*.java
   javac -d out -cp out src/main/java/clinica/modulo_b/*.java
   javac -d out -cp out src/main/java/clinica/modulo_c/*.java
   javac -d out -cp out src/main/java/clinica/integracion/*.java

2. Ejecutar:
   java -cp out clinica.modulo_a.MainModuloA
   java -cp out clinica.modulo_b.MainModuloB
   java -cp out clinica.modulo_c.MainModuloC
   java -cp out clinica.integracion.SistemaClinico

ANÁLISIS DE COMPLEJIDAD
-----------------------
ColaPacientes.enqueue/dequeue  → O(1)
PilaHistorial.push/pop         → O(1)
BST insertar/buscar            → O(log n) promedio | O(n) peor caso
BST altura                     → O(n)
