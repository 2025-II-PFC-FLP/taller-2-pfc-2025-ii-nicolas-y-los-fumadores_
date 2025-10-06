# Taller 2: Funciones de Alto Orden - Conjuntos Difusos

## Fundamentos de Programación Funcional y Concurrente

---

## 👥 Integrantes del Grupo

| Nombre Completo       | Código  | Rol            |           Correo Electrónico               |
|-----------------------|---------|----------------|--------------------------------------------|               
| Pablo Nicolas         | 2459440 | Líder          | pablo.nicolas.marin@correounivalle.edu.co  |
| Kevin Rico            | 2411024 | Colaborador    | Kevin.rico@correounivalle.edu.co           |
| Daniel Hoyos          | 2459736 | Colaborador    | daniel.antonio.hoyos@correo.univalle.edu.co|

---

## 📋 Descripción del Proyecto

Este proyecto implementa operaciones sobre **conjuntos difusos** utilizando programación funcional en Scala. Los conjuntos difusos son una generalización de los conjuntos clásicos donde cada elemento tiene un grado de pertenencia entre 0 y 1, en lugar de simplemente pertenecer o no al conjunto.

### Conceptos Clave

- **Conjunto Difuso**: Representado como una función `Int => Double` que mapea elementos a su grado de pertenencia en el intervalo [0, 1]
- **Función Característica**: Función que determina el grado de pertenencia de un elemento al conjunto
- **Operaciones**: Complemento, unión, intersección, inclusión e igualdad sobre conjuntos difusos

---

## 🗂️ Estructura del Proyecto

```
taller/
├── src/
│   └── main/
│       └── scala/
│           └── taller/
│               ├── BigNumber.scala          # Conjunto difuso de números grandes
│               ├── BuscarLista.scala        # Operaciones complemento, unión, intersección
│               └── InclucionIgualdad.scala  # Operaciones de inclusión e igualdad
├── test/
│   └── scala/
│       └── taller/
│           ├── BigNumberTest.scala
│           ├── ConjDifusoOpsTest.java
│           └── TestInclusionIgualdad.scala
└── docs/
    ├── informe-proceso.md
    └── informe-correccion.md
```

---

## 🔧 Funciones Implementadas

### 1. **BigNumber.scala**
Implementa la función `grande(d: Int, e: Int): ConjDifuso` que crea un conjunto difuso de números grandes usando la fórmula:

$$f(n) = \left(\frac{n}{n+d}\right)^e$$

- Usa recursión de cola para calcular la potencia
- Retorna 0.0 para números negativos o cero

### 2. **BuscarLista.scala**
Implementa operaciones básicas sobre conjuntos difusos:

- **`complemento(c: ConjDifuso): ConjDifuso`**: Retorna el complemento del conjunto
  $$f_{\neg S}(x) = 1 - f_S(x)$$

- **`union(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso`**: Retorna la unión de dos conjuntos
  $$f_{S_1 \cup S_2}(x) = \max(f_{S_1}(x), f_{S_2}(x))$$

- **`interseccion(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso`**: Retorna la intersección de dos conjuntos
  $$f_{S_1 \cap S_2}(x) = \min(f_{S_1}(x), f_{S_2}(x))$$

### 3. **InclucionIgualdad.scala**
Implementa relaciones entre conjuntos difusos:

- **`inclusion(cd1: ConjDifuso, cd2: ConjDifuso): Boolean`**: Verifica si $S_1 \subseteq S_2$
  - Usa recursión de cola
  - Itera sobre el intervalo [0, 1000]
  - Retorna `true` si $\forall s \in U: f_{S_1}(s) \leq f_{S_2}(s)$

- **`igualdad(cd1: ConjDifuso, cd2: ConjDifuso): Boolean`**: Verifica si $S_1 = S_2$
  - Implementado como inclusión mutua: $S_1 \subseteq S_2 \land S_2 \subseteq S_1$

---

## 🧪 Pruebas Unitarias

Cada funcionalidad cuenta con pruebas organizadas en tres categorías:

### **Pruebas Triviales**
- Casos básicos y obvios
- Validación de condiciones mínimas

### **Pruebas de Comportamiento**
- Propiedades matemáticas (transitividad, simetría, monotonía)
- Validación de reglas de conjuntos difusos

### **Pruebas Específicas**
- Casos con valores conocidos
- Validación de cálculos precisos
- Casos límite

---

## 🚀 Ejecución

### Compilar el proyecto
```bash
sbt compile
```

### Ejecutar las pruebas
```bash
sbt test
```

### Ejecutar pruebas específicas
```bash
sbt "testOnly taller.BigNumberTest"
sbt "testOnly taller.InclusionIgualdadTest"
```

---

## 📚 Principios de Programación Funcional Aplicados

✅ **Sin variables mutables**: Solo se usan `val` y parámetros inmutables  
✅ **Sin ciclos iterativos**: Se usa recursión en lugar de `for` o `while`  
✅ **Sin `return`**: Las funciones retornan el resultado de la última expresión  
✅ **Funciones de alto orden**: Se usan funciones que reciben y retornan otras funciones  
✅ **Recursión de cola**: Optimización mediante `@tailrec`  
✅ **TAD (Tipo Abstracto de Datos)**: Los conjuntos difusos se implementan como tipo funcional

---

## 📖 Referencias

- Zadeh, L. A. (1965). "Fuzzy sets". Information and Control, 8(3), 338-353.
- Documentación oficial de Scala: [https://docs.scala-lang.org](https://docs.scala-lang.org)
- Material del curso: Fundamentos de Programación Funcional y Concurrente

---



## 📝 Notas Adicionales

- Todos los commits fueron realizados por los integrantes del grupo
- La documentación está en formato Markdown en la carpeta `docs/`
- Se siguieron todas las convenciones de programación funcional
- Los diagramas de flujo están en formato Mermaid

---

**Universidad del Valle**  
**Escuela de Ingeniería de Sistemas y Computación**  
**Septiembre de 2025**
