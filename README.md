# Parcial-3
Ultimo Parcial
# Sistema de Gestión — Clínica VidasPlus

Proyecto final del curso de **Estructuras de Datos** implementado en Java puro. Simula el sistema de gestión de pacientes del área de urgencias de la Clínica VidasPlus de Yopal, usando estructuras lineales y no lineales implementadas desde cero (sin `ArrayList` ni `LinkedList` de la API estándar).

---

## Módulos

### Módulo A — Cola de Urgencias
Implementa una **Cola FIFO** sobre una lista enlazada simple para gestionar el turno de atención de pacientes. `enqueue()` y `dequeue()` operan en **O(1)**.

### Módulo B — Historial Clínico con Pila
Implementa una **Pila LIFO** sobre nodos enlazados para almacenar el historial de diagnósticos de cada paciente. El diagnóstico más reciente se consulta primero. `push()`, `pop()` y `peek()` operan en **O(1)**.

### Módulo C — Árbol BST de Médicos
Implementa un **Árbol Binario de Búsqueda** para el directorio de médicos, ordenado por código. Incluye inserción, búsqueda, eliminación (hoja, un hijo, dos hijos), recorridos in-orden / pre-orden / post-orden y cálculo de altura. Complejidad **O(log n)** promedio, **O(n)** peor caso.

### Integración — SistemaClinico
Conecta los tres módulos en un flujo completo de atención: registro → atención → diagnóstico → consulta BST → eliminación.

---

## Estructura del proyecto

```
Ultimo Parcial/
├── src/main/java/clinica/
│   ├── modulo_a/
│   │   ├── Paciente.java
│   │   ├── NodoPaciente.java
│   │   ├── ColaPacientes.java
│   │   └── MainModuloA.java
│   ├── modulo_b/
│   │   ├── Diagnostico.java
│   │   ├── NodoDiagnostico.java
│   │   ├── PilaHistorial.java
│   │   └── MainModuloB.java
│   ├── modulo_c/
│   │   ├── Medico.java
│   │   ├── NodoMedico.java
│   │   ├── BST_Medicos.java
│   │   └── MainModuloC.java
│   └── integracion/
│       └── SistemaClinico.java
├── README.md
└── README.txt
```

---

## Compilación y ejecución

**Requisitos:** JDK 8 o superior.

Desde la raíz del proyecto:

```bash
# 1. Crear carpeta de salida
mkdir out

# 2. Compilar en orden (respetar dependencias entre paquetes)
javac -d out src/main/java/clinica/modulo_a/*.java
javac -d out -cp out src/main/java/clinica/modulo_b/*.java
javac -d out -cp out src/main/java/clinica/modulo_c/*.java
javac -d out -cp out src/main/java/clinica/integracion/*.java
```

```bash
# 3. Ejecutar cada módulo individualmente
java -cp out clinica.modulo_a.MainModuloA
java -cp out clinica.modulo_b.MainModuloB
java -cp out clinica.modulo_c.MainModuloC

# 4. Ejecutar la integración completa
java -cp out clinica.integracion.SistemaClinico
```

---

## Análisis de complejidad

| Operación | Complejidad |
|-----------|-------------|
| `ColaPacientes.enqueue()` | O(1) |
| `ColaPacientes.dequeue()` | O(1) |
| `PilaHistorial.push()` | O(1) |
| `PilaHistorial.pop()` | O(1) |
| `BST_Medicos.insertar()` | O(log n) promedio / O(n) peor caso |
| `BST_Medicos.buscar()` | O(log n) promedio / O(n) peor caso |
| `BST_Medicos.altura()` | O(n) |

> El peor caso del BST ocurre cuando los códigos se insertan en orden estrictamente ascendente o descendente, degenerando el árbol en una lista enlazada. Para producción se recomendaría un árbol AVL o Rojo-Negro.

---

## Autor

**Juan Rivera**  
Ingeniería de Sistemas — Estructuras de Datos
