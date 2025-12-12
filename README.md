# Cena de los Filósofos - Práctica Multihilo

## Descripción
Implementación en Java del problema clásico de la Cena de los Filósofos utilizando el patrón **Monitor** para gestionar la concurrencia y evitar interbloqueos (deadlock).

## Estructura del Proyecto
* **src/main/java**: Código fuente de la aplicación.
  * `CenaFilosofos.java`: Clase principal (Main).
  * `MonitorFilosofos.java`: Monitor de sincronización.
  * `Filosofo.java`: Hilos de ejecución.
* **src/test/java**: Pruebas unitarias con JUnit.
* **doc/**: Memoria técnica en PDF.

## Ejecución
Para ejecutar la simulación:
1. Abrir `src/main/java/cena/CenaFilosofos.java`.
2. Ejecutar como Java Application.

## Pruebas
Para verificar la lógica de sincronización:
1. Abrir `src/test/java/cena/MonitorTest.java`.
2. Ejecutar como JUnit Test.

## Autor
Jose Antonio Serrano Santos