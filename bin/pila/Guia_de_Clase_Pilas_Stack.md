# Guía de Clase – Pilas (Stack)

## Estructuras de Datos

### Objetivo de la clase

Al finalizar la clase, el estudiante podrá:

- Comprender qué es una pila.
- Explicar el principio **LIFO (Last In, First Out)**.
- Identificar el **tope (top)** de una pila.
- Utilizar `push`, `pop`, `peek` e `isEmpty`.
- Simular manualmente el comportamiento de una pila.
- Implementar una pila utilizando nodos en Java.
- Analizar la complejidad básica de sus operaciones.
- Identificar aplicaciones prácticas de las pilas.

---

# 1. Introducción: ¿Qué es una pila?

Pensemos en una situación cotidiana: una pila de platos.

```text
       ┌─────────┐
       │  Plato  │ ← último en colocar
       ├─────────┤
       │  Plato  │
       ├─────────┤
       │  Plato  │
       ├─────────┤
       │  Plato  │ ← primero en colocar
       └─────────┘
```

Si necesitamos retirar un plato, debemos sacar primero el que está arriba.

Una pila de datos funciona de manera similar.

## Definición

Una **pila (Stack)** es una estructura de datos lineal en la que los elementos se agregan y eliminan por uno de sus extremos, denominado **tope (top)**.

La pila trabaja bajo el principio:

## LIFO

**Last In, First Out**

> El último elemento que entra es el primero que sale.

Ejemplo:

```text
Entrada:  10 → 20 → 30
Salida:   30 → 20 → 10
```

---

# 2. El tope (TOP)

El **tope** es el elemento que se encuentra disponible para ser retirado.

```text
       TOP
        ↓
      ┌────┐
      │ 30 │
      ├────┤
      │ 20 │
      ├────┤
      │ 10 │
      └────┘
```

Las operaciones principales de una pila se realizan sobre el `top`.

---

# 3. Operaciones fundamentales

| Operación | Descripción |
|---|---|
| `push()` | Agrega un elemento al tope |
| `pop()` | Retira y devuelve el elemento del tope |
| `peek()` | Consulta el elemento del tope sin retirarlo |
| `isEmpty()` | Indica si la pila está vacía |

## 3.1 Push

```java
push(30);
```

Antes:

```text
TOP
 ↓
20
 ↓
10
```

Después:

```text
TOP
 ↓
30
 ↓
20
 ↓
10
```

## 3.2 Pop

```java
pop();
```

Antes:

```text
TOP
 ↓
30
 ↓
20
 ↓
10
```

Sale `30`.

Después:

```text
TOP
 ↓
20
 ↓
10
```

## 3.3 Peek

```java
peek();
```

Devuelve el elemento del tope, pero **no lo elimina**.

```text
TOP
 ↓
30
 ↓
20
 ↓
10

peek() → 30
```

La pila permanece igual.

### Diferencia

```text
pop()  → consulta + elimina
peek() → consulta sin eliminar
```

## 3.4 IsEmpty

```java
isEmpty();
```

Devuelve:

```text
true  → la pila está vacía
false → la pila contiene elementos
```

---

# 4. Simulación manual

Antes de programar, siga el estado de la pila.

### Paso 1

```text
push(10)
```

```text
TOP
 ↓
10
```

### Paso 2

```text
push(20)
```

```text
TOP
 ↓
20
 ↓
10
```

### Paso 3

```text
push(30)
```

```text
TOP
 ↓
30
 ↓
20
 ↓
10
```

### Paso 4

```text
pop()
```

Sale:

```text
30
```

Queda:

```text
TOP
 ↓
20
 ↓
10
```

### Paso 5

```text
push(40)
```

```text
TOP
 ↓
40
 ↓
20
 ↓
10
```

### Paso 6

```text
peek()
```

Resultado:

```text
40
```

La estructura no cambia.

---

# 5. ¿Qué NO permite hacer una pila?

Una pila no debe tratarse como una lista donde podemos acceder libremente a cualquier posición.

Si tenemos:

```text
TOP
 ↓
30
 ↓
20
 ↓
10
```

No son operaciones fundamentales de una pila:

```java
get(2);
remove(20);
insertarDebajo(10);
```

La regla fundamental es:

> **Los elementos entran y salen por el tope.**

---

# 6. Implementación utilizando nodos

Ya conocemos las listas enlazadas y los nodos. Podemos reutilizar esa idea.

Un nodo contiene:

```text
┌───────────────┐
│     data      │
├───────────────┤
│     next      │
└───────────────┘
```

La pila tendrá una referencia llamada `top`.

```text
       top
        ↓
     ┌──────┐
     │  30  │
     └──┬───┘
        ↓
     ┌──────┐
     │  20  │
     └──┬───┘
        ↓
     ┌──────┐
     │  10  │
     └──┬───┘
        ↓
       null
```

La diferencia con una lista general es que la pila impone una regla:

> **Solo trabajaremos con el nodo que está en `top`.**

---

# 7. Clase MyStack

Utilizaremos el `Node` trabajado anteriormente.

```java
public class MyStack {

    private Node top;

    public MyStack() {
        top = null;
    }
}
```

El atributo:

```java
private Node top;
```

representa el elemento que está actualmente en la cima de la pila.

---

# 8. Implementación de push()

El procedimiento es:

1. Crear un nodo.
2. Guardar el dato.
3. Hacer que el nuevo nodo apunte al antiguo `top`.
4. Convertir el nuevo nodo en el nuevo `top`.

```java
public void push(Object data) {

    Node nuevo = new Node();

    nuevo.setData(data);
    nuevo.setNext(top);

    top = nuevo;
}
```

## ¿Qué ocurre internamente?

Antes:

```text
top
 ↓
20
 ↓
10
```

Ejecutamos:

```java
push(30);
```

Primero:

```text
nuevo
 ↓
30
```

Después:

```text
nuevo.next = top
```

Resultado:

```text
nuevo
 ↓
30 ─────→ 20 ─────→ 10
```

Finalmente:

```java
top = nuevo;
```

Resultado:

```text
top
 ↓
30
 ↓
20
 ↓
10
```

---

# 9. Implementación de pop()

Para retirar el elemento superior:

1. Comprobar si la pila está vacía.
2. Guardar el dato del `top`.
3. Mover `top` al siguiente nodo.
4. Devolver el dato retirado.

```java
public Object pop() {

    if (top == null) {
        return null;
    }

    Object data = top.getData();

    top = top.getNext();

    return data;
}
```

## ¿Qué ocurre internamente?

Antes:

```text
top
 ↓
30
 ↓
20
 ↓
10
```

Guardamos:

```java
Object data = top.getData();
```

Ahora:

```text
data = 30
```

Después:

```java
top = top.getNext();
```

Resultado:

```text
top
 ↓
20
 ↓
10
```

Finalmente:

```java
return data;
```

Devuelve `30`.

---

# 10. Implementación de peek()

```java
public Object peek() {

    if (top == null) {
        return null;
    }

    return top.getData();
}
```

A diferencia de `pop()`, no modifica `top`.

---

# 11. Implementación de isEmpty()

```java
public boolean isEmpty() {
    return top == null;
}
```

---

# 12. MyStack completa

```java
public class MyStack {

    private Node top;

    public MyStack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Object data) {

        Node nuevo = new Node();

        nuevo.setData(data);
        nuevo.setNext(top);

        top = nuevo;
    }

    public Object pop() {

        if (top == null) {
            return null;
        }

        Object data = top.getData();

        top = top.getNext();

        return data;
    }

    public Object peek() {

        if (top == null) {
            return null;
        }

        return top.getData();
    }
}
```

---

# 13. Prueba desde main

```java
public class Main {

    public static void main(String[] args) {

        MyStack pila = new MyStack();

        pila.push(10);
        pila.push(20);
        pila.push(30);

        System.out.println("Elemento superior: " + pila.peek());

        System.out.println("Sale: " + pila.pop());
        System.out.println("Sale: " + pila.pop());
        System.out.println("Sale: " + pila.pop());
    }
}
```

Resultado:

```text
Elemento superior: 30
Sale: 30
Sale: 20
Sale: 10
```

---

# 14. Ejercicio 1 – Invertir números

Desarrolle un programa que:

1. Solicite tres números al usuario.
2. Almacene los números en una pila.
3. Retire los números utilizando `pop()`.
4. Muestre los números en el orden inverso al que fueron ingresados.

### Ejemplo

Entrada:

```text
Número 1: 10
Número 2: 20
Número 3: 30
```

Salida:

```text
Orden inverso:
30
20
10
```

### Pregunta

¿Por qué una pila permite invertir fácilmente el orden de los datos?

---

# 15. Ejercicio 2 – Historial de acciones

Simule un sistema que registre acciones realizadas por un usuario.

Ejemplo:

```text
"Escribió Hola"
"Escribió Hola mundo"
"Escribió Hola mundo!!!"
```

Cada acción debe almacenarse en una pila.

Cuando el usuario seleccione **Deshacer**, se debe retirar la última acción realizada.

Ejemplo:

```text
Acciones:

Escribió Hola
Escribió Hola mundo
Escribió Hola mundo!!!

Deshacer

Resultado:
Se deshizo → Escribió Hola mundo!!!
```

---

# 16. Complejidad

En nuestra implementación con nodos:

| Operación | Complejidad |
|---|---:|
| `push()` | O(1) |
| `pop()` | O(1) |
| `peek()` | O(1) |
| `isEmpty()` | O(1) |

La razón es que todas trabajan directamente con `top`; no necesitamos recorrer toda la estructura.

---

# 17. Pila implementada con arreglo

Una pila también puede implementarse mediante un arreglo.

Ejemplo:

```java
private int[] datos = new int[5];
private int top = -1;
```

Representación:

```text
Índice:

   0     1     2     3     4
┌─────┬─────┬─────┬─────┬─────┐
│ 10  │ 20  │ 30  │     │     │
└─────┴─────┴─────┴─────┴─────┘
              ↑
             top
```

En esta implementación `top` representa la posición del último elemento almacenado.

Inicialmente:

```text
top = -1
```

Después de `push(10)`:

```text
top = 0
```

Después de `push(20)`:

```text
top = 1
```

---

# 18. Stack Overflow

Si el arreglo tiene capacidad limitada y ya está lleno:

```text
10
20
30
40
50
```

intentar agregar otro elemento genera una situación conocida como:

**Stack Overflow**

> Intentar insertar un elemento cuando la pila ya alcanzó su capacidad.

---

# 19. Stack Underflow

Si la pila está vacía:

```text
TOP
 ↓
null
```

y se intenta ejecutar:

```java
pop();
```

se presenta un:

**Stack Underflow**

> Intentar retirar un elemento de una pila que no contiene elementos.

En nuestra primera implementación manejamos esta situación devolviendo `null`. Posteriormente puede estudiarse el manejo mediante excepciones.

---

# 20. Aplicaciones de las pilas

Las pilas aparecen en diferentes problemas reales y algoritmos:

- Deshacer acciones (`Ctrl + Z`).
- Historial de operaciones.
- Validación de paréntesis.
- Inversión de información.
- Evaluación de expresiones.
- Procesamiento de expresiones matemáticas.
- Recursividad y pila de llamadas.
- Algunos algoritmos de búsqueda y recorrido.

La idea común es que necesitamos procesar primero el elemento más recientemente almacenado.

---

# 21. Actividad de cierre

Analice las siguientes operaciones sin ejecutar el programa:

```text
push(5)
push(10)
push(15)
pop()
push(20)
peek()
pop()
pop()
```

Complete:

| Operación | Elemento que sale | Estado de la pila |
|---|---|---|
| `push(5)` | - | |
| `push(10)` | - | |
| `push(15)` | - | |
| `pop()` | | |
| `push(20)` | - | |
| `peek()` | | |
| `pop()` | | |
| `pop()` | | |

---

# 22. Preguntas de comprobación

1. ¿Qué significa LIFO?
2. ¿Qué es el `top`?
3. ¿Qué diferencia existe entre `pop()` y `peek()`?
4. ¿Por qué `push()` agrega elementos en el tope?
5. ¿Por qué una pila no permite retirar directamente un elemento del medio?
6. ¿Qué sucede cuando hacemos `pop()` sobre una pila vacía?
7. ¿Por qué `push()` tiene complejidad O(1) en nuestra implementación?
8. ¿Cuál es la diferencia entre implementar una pila con nodos y con un arreglo?
9. ¿Qué significa Stack Overflow?
10. Mencione dos situaciones reales donde una pila sea útil.

---

# 23. Ideas clave

```text
                    PILA
                      │
                    LIFO
                      │
             ┌────────┴────────┐
             │                 │
          ENTRADA            SALIDA
             │                 │
           push               pop

                         peek → consultar
                         isEmpty → verificar
```

La idea fundamental:

> **Una pila es una estructura donde el último elemento que entra es el primero que sale. Todas las operaciones principales se realizan por el tope.**

---

# 24. Próxima clase

Se puede continuar con:

- Implementación de una pila mediante arreglos.
- Capacidad y crecimiento.
- Stack Overflow.
- Stack Underflow.
- Ejercicios de aplicación.
- Validación de paréntesis.
- Inversión de cadenas.
- Comparación entre pila con nodos y pila con arreglo.
- Uso de estructuras de pila proporcionadas por Java.

Después se puede continuar con **colas (Queue)**, introduciendo el principio:

**FIFO – First In, First Out**
