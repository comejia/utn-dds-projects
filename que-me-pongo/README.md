# Que Me Pongo

Requerimientos [Primera Iteración](/src/main/resources/que_me_pongo_primera_iteracion.pdf):
* Como usuarie de QuéMePongo, quiero poder cargar prendas válidas para generar atuendos con ellas (general).

* Como usuarie de QuéMePongo, quiero especificar qué tipo de prenda estoy cargando (zapatos, camisa de mangas cortas, pantalón, etc).
* Como usuarie de QuéMePongo, quiero identificar a qué categoría pertenece una prenda (parte superior, calzado, parte inferior, accesorios).
* Como usuarie de QuéMePongo, quiero poder indicar de qué tela o material está hecha una prenda
* Como usuarie de QuéMePongo, quiero poder indicar un color principal para mis prendas
* Como usuarie de QuéMePongo, quiero poder indicar, si existe, un color secundario para mis prendas.
* Como usuarie de QuéMePongo, quiero evitar que haya prendas sin tipo, tela, categoría o color primario`
* Como usuarie de QuéMePongo, quiero evitar que haya prendas cuya categoría no se condiga con su tipo. (Ej, una remera no puede ser calzado).

---
Requerimientos [Segunda Iteración](/src/main/resources/que_me_pongo_segunda_iteracion.pdf):
* Como usuarie de QuéMePongo, quiero especificar qué trama tiene la tela de una prenda (lisa, rayada, con lunares, a cuadros o un estampado).
* Como usuarie de QuéMePongo, quiero crear una prenda especificando primero de qué tipo es.
* Como usuarie de QuéMePongo, quiero crear una prenda especificando en segundo lugar los aspectos relacionados a su material (colores, material, trama, etc) para evitar elegir materiales inconsistentes con el tipo de prenda.
* Como usuarie de QuéMePongo, quiero guardar un borrador de la la última prenda que empecé a cargar para continuar después.
* Como usuarie de QuéMePongo, quiero poder no indicar ninguna trama para una tela, y que por defecto ésta sea lisa.
* Como usuarie de QuéMePongo, quiero poder guardar una prenda solamente si esta es válida.

Bonus:
* Como usuario QueMePongo, quiero poder recibir sugerencias de uniformes armados. 
* Como usuario QueMePongo, quiero que un uniforme siempre conste de una prenda superior, una inferior y un calzado 
* Como administrador de QueMePongo, quiero poder configurar diferentes uniformes para distintas instituciones (Ej: para el colegio San Juan debe ser una chomba verde de piqué, un pantalón de acetato gris y zapatillas blancas, mientras que para el Instituto Johnson siempre será una camisa blanca, pantalón de vestir negro y zapatos negros)

Requerimientos [Cuarta Iteración](/src/main/resources/que_me_pongo_cuarta_iteracion.pdf):
* Como usuarie de QuéMePongo, quiero poder conocer las condiciones climáticas de Buenos Aires en un momento dado para obtener sugerencias acordes.
* Como usuarie de QuéMePongo, quiero poder recibir sugerencias de atuendos que tengan una prenda para cada categoría, aunque a futuro podrán tener más (Ej.: Una remera, un pantalón, zapatos y un gorro).
* Como usuarie de QuéMePongo, quiero que al generar una sugerencia las prendas sean acordes a la temperatura actual sabiendo que para cada prenda habrá una temperatura hasta la cual es adecuada. (Ej.: “Remera de mangas largas” no es apta a más de 20°C)
* Como administradore de QuéMePongo, quiero poder configurar fácilmente diferentes servicios de obtención del clima para ajustarme a las cambiantes condiciones económicas.
* Como stakeholder de QuéMePongo, quiero poder asegurar la calidad de mi aplicación sin incurrir en costos innecesarios.

Requerimientos [Quinta Iteración](/src/main/resources/que_me_pongo_quinta_iteracion.pdf):
* Como usuarie de QuéMePongo, quiero poder manejar varios guardarropas para separar mis prendas según diversos criterios (ropa de viaje, ropa de entrecasa, etc).
* Como usuarie de QuéMePongo, quiero poder crear guardarropas compartidos con otros usuaries (ej, ropa que comparto con mi hermane).
* Como usuarie de QuéMePongo, quiero que otro usuario me proponga tentativamente agregar una prenda al guardarropas.
* Como usuarie de QuéMePongo, quiero que otro usuario me proponga tentativamente quitar una prenda del guardarropas.
* Como usuarie de QuéMePongo, necesito ver todas las propuestas de modificación (agregar o quitar prendas) del guardarropas y poder aceptarlas o rechazarlas.
* Como usuarie de QuéMePongo, quiero poder deshacer las propuestas de modificación que haya aceptado.
