# Juego de Combate de Personajes 🧛🐺🏹

## Índice
1. [Flujo de usuario](#flujo-de-usuario)
2. [Funciones de administrador](#funciones-de-administrador-)
3. [Características de personajes](#características-de-personajes)
4. [Sistema de combate](#sistema-de-combate)
5. [Pruebas con JUnit](#pruebas-con-junit-)
6. [Autores](#autores)

---

## Flujo de usuario

### 1. Pantalla de bienvenida
Los nuevos jugadores pueden **registrarse**, mientras que los existentes pueden **iniciar sesión**. También existe la opción de cerrar el juego.

![Pantalla de Bienvenida](https://github.com/user-attachments/assets/2598afe0-d883-4942-81a7-a6f6e457461c)

### 2. Registro de usuario
Para registrarse se requiere:
- Nombre real
- Nick único (identificador en el juego)
- Contraseña segura
  
![Pantalla de registro](https://github.com/user-attachments/assets/fed4929d-bc64-4c24-b93f-82e672b17de2)

### 3. Inicio de sesión
Los usuarios existentes ingresan sus credenciales. En caso de error se muestra notificación.

![Pantalla inicio sesión](https://github.com/user-attachments/assets/2116156c-9e59-4dc8-a8d5-47caac5d38d6)

### 4. Menú principal de jugador
Opciones disponibles:
- 🤑 Consultar oro
- ⚔️ Gestionar armas/armaduras
- 🏆 Desafiar jugadores
- 🔔 Ver notificaciones
- 📜 Historial de combates
- 🏅 Ranking
- 🧙 Crear personaje
- 🚮 Eliminar personaje/cuenta

![Menú usuario](https://github.com/user-attachments/assets/7c9ce718-e8e9-4518-bae0-2f8e9c7b1a3a)

### 5. Consultar oro
Los jugadores pueden ver su cantidad de oro actual en un pop-up.

![Consulta oro](https://github.com/user-attachments/assets/8e6cba3b-1c69-4da9-91f4-074deaf218a8)


### 6. Gestión de personaje
#### Creación de personaje
Selección entre:
- Vampiro
- Licántropo
- Cazador

![Creacion de personaje](https://github.com/user-attachments/assets/b7d0ba41-3b91-4ea7-b065-d74d2800eaac)

#### Equipamiento
- Las armas/armaduras seleccionadas se muestran en **verde**
- Límite de 2 armas (1 si es de dos manos)
  
![arma elegida](https://github.com/user-attachments/assets/cdb35981-a985-4e48-886a-fa162a9f1249)
![Armadura elegida](https://github.com/user-attachments/assets/0b561643-56a5-422d-9e26-765a2baefe71)

### 7. Sistema de desafíos
- Selección de oponente de la lista
- Apuesta de oro
- Se añade el desafio a la lista de desafios del admin para que sea validado
  
![Desafio](https://github.com/user-attachments/assets/610f4a9d-18cb-4a37-8ecc-edab42a511d7)

### 8. Historial y ranking
Detalle completo de cada combate:
- Rondas jugadas
- Daño infligido/recibido
- Modificadores aplicados
  
![Historial](https://github.com/user-attachments/assets/3d181368-7791-49df-ba7a-ea9f55201dac)

Top 10 jugadores por victorias

![Ranking](https://github.com/user-attachments/assets/b9afffec-dac3-43d1-b1ef-2cd53898a39a)


### 9. Notificaciones
Los jugadores reciben notificaciones cuando son desafiados o cuando un desafío es aceptado/rechazado. 

![Pantalla de notificaciones](https://github.com/user-attachments/assets/5f16979e-dfd4-40bb-8285-9bea8525b2db)

No pueden realizar ninguna acción hasta que revisen las notificaciones pendientes.

![Pantalla de aviso de que tienes notificaciones](https://github.com/user-attachments/assets/26e3363f-e9f7-48f1-aa29-9b0dcd7721a7)


---
## Funciones de administrador 👨💼

### Panel de control
Funcionalidades exclusivas:
1. Validar desafíos pendientes
2. Banear/desbanear usuarios
3. Editar personajes
4. Gestionar equipamiento
5. Modificar esbirros

![Pantalla admin](https://github.com/user-attachments/assets/763ce35b-25ca-469a-9bc2-112e81aed5b2)

### Gestión de desafíos
- Añadir modificadores globales y aceptar el desafío para que sea notificado al usuario desafiado
  
![Validación de desafios](https://github.com/user-attachments/assets/496655ac-087e-4e7d-9a25-017839cb4f59)


### Gestión de baneo y desbaneo de usuarios
![Banear usuarios](https://github.com/user-attachments/assets/793d5971-df26-4f57-acf9-ae04fefefb3b)

### Edición de personajes
Lo primero es elegir uno de los personajes a editar

![Edicion de personajes](https://github.com/user-attachments/assets/d91b31a7-90b1-4b17-9307-cb813e18cb41)

Una vez elegido puedes elegir entre editar modificadores, editar equipamiento y gestionar los esbirros

![edicion vampiros](https://github.com/user-attachments/assets/981d1653-95bc-4446-bb7f-b91845b32960)

Editar modificadores: Decidir qué modificadores son debilidades, fortalezas o neutrales.

![edicion de fortalezas y debilidades](https://github.com/user-attachments/assets/a930a916-2dc7-4b05-8f33-32ae772ee00f)

Editar equipamiento: Seleccionar qué armas y armaduras están disponibles para el personaje de todas las que hay en el juego.

![Edicion de armas](https://github.com/user-attachments/assets/e77cb0f5-b7bd-47f4-a1b3-f16da765f003)

Gestión de esbirros: Añadir o eliminar esbirros

![edicion de esbirros](https://github.com/user-attachments/assets/e28c0e4c-67be-4e46-8176-93268b7559e5)

Incluso editar los esbirros y asignar esbirros a otros esbirros (en el caso de demonios).

![gestion de esbirros](https://github.com/user-attachments/assets/686bafe8-7447-4394-beb3-1a7bd4296e6a)

---

## Características de personajes

### Vampiro 🧛
- **Poder**: 5
- **Habilidad**: Drenaje de vida (2% por golpe)
- **Esbirros iniciales**: 2 Demonios

### Licántropo 🐺
- **Poder**: 4
- **Habilidad**: Rabia acumulativa (+1% daño por ronda)
- **Esbirros iniciales**: 1 Ghoul

### Cazador 🏹
- **Poder**: 3
- **Habilidad**: Precisión crítica (15% de golpe doble)
- **Esbirros iniciales**: 3 Humanos

---

## Sistema de combate

### Mecánica de esbirros
- **Demonios**: Pueden tener sub-esbirros ilimitados
- **Ghouls**: Aumentan daño en 10% por nivel de dependencia
- **Humanos**: 50% de probabilidad de bloquear ataques

### Modificadores de combate
Los administradores pueden configurar:
- Fortalezas (+20% efectividad)
- Debilidades (-30% resistencia)
- Neutrales (sin efecto)

---

## Pruebas con JUnit 🔬
En esta sección, se detallan las pruebas unitarias realizadas con JUnit para garantizar la calidad y el correcto funcionamiento del código. Las pruebas cubren una amplia gama de funcionalidades, desde la creación de personajes hasta la gestión de combates y usuarios. A continuación, se presenta un resumen de las pruebas más relevantes:

### Pruebas de Creación de Personajes
VampiroTest: Verifica la correcta inicialización y modificación de atributos específicos de los vampiros, como la cantidad de sangre y la edad.

LicantropoTest: Evalúa el manejo de la rabia en los licántropos, asegurando que los valores se establecen y obtienen correctamente.

CazadorTest: Comprueba la gestión de la voluntad en los cazadores, un atributo clave para su funcionamiento en el juego.

### Pruebas de Gestión de Usuarios
UsuarioTest: Abarca una amplia gama de funcionalidades relacionadas con los usuarios, incluyendo la gestión de oro, notificaciones, y el historial de combates.

RegistroTest: Verifica el proceso de registro de nuevos usuarios, tanto jugadores como administradores, asegurando que los datos se almacenan correctamente.

### Pruebas de Combate y Desafíos
CombateTest: Evalúa el sistema de combate, asegurando que los resultados de los enfrentamientos se calculan correctamente y que los ajustes de oro se realizan de manera precisa.

DesafioTest: Comprueba la creación y gestión de desafíos, incluyendo la adición de fortalezas y debilidades, y la correcta actualización del estado del desafío.

### Pruebas de Esbirros y Equipamiento
EsbirroTest: Verifica la correcta inicialización y modificación de los esbirros, incluyendo su salud y nombre.

EquipoTest: Evalúa la gestión de armas y armaduras, asegurando que los atributos como el ataque y la defensa se manejan correctamente.

### Pruebas de Almacenamiento y Persistencia
AlmacenTest: Comprueba la correcta gestión de los datos persistentes, incluyendo la carga y actualización de usuarios, personajes, y desafíos.

## Autores

| Nombre          | GitHub                                  |
|-----------------|-----------------------------------------|
| Tarek Elshami Ahmed        | [@TarekElshami](https://github.com/TarekElshami)  |
| Álvaro Serrano Rodrigo         | [@AlvaroS3rrano](https://github.com/AlvaroS3rrano)    |
| Izan Ruiz Ballesteros         | [@Etheko](https://github.com/Etheko)     |
| Blas Vita Ramos         | [@Blasetvrtumi](https://github.com/Blasetvrtumi)     |
