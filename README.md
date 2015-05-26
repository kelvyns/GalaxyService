# La Galaxia.
> <b>Version: 0.0.1</b>


-   Sistema meteorológico de la galaxia que conforman las tres civilizaciones:
Vulcanos, Ferengis y Betasoides.

> <b>Premisas:</b>

-   Para Inicializar el sistema meteorológico se supuso que los planetas parten de un dia 0 en donde todos estaban alineados con el Sol.
Debido a que manejamos ecuaciones matemáticas para los diferentes cálculos se manejo una precisión de aproximación de 1 decimal.

-   Se consideraron los siguientes estados climáticos: lluvia, sequia, optimo y nollueve. A pesar de que sabemos que cuando hay sequía obviamente no llueve, se manejo por separado para saber cuando no llueve y cuando ademas hay sequia. 
Se tomó como premisa que en esta galaxia cada año tiene exactamente 365 días, por lo cual para 10 años tendremos 3650 días más el día 0 del cual parten las galaxias. 

> <b>Adicionales:</b>

-   Para Inicializar el sistema se creó un servicio que al ejecutarlo inicializa la galaxia creando la base de datos.  Adicional este servicio permite agregar dos parametros que no son obligatorios, es decir son opcionales, los cuales son "precision=1" y "destroy=0" que se encuentran en esos valores por defecto.

-   Debido a que manejamos ecuaciones matemáticas para los diferentes cálculos se manejo una precisión de aproximación de 1 decimal, más que todo para estudiar la alineacion de los planetas que no es perfectamente igual. También se puede aproximar a 0 decimales, 2 decimales y 3 decimales, pero para 2 y 3 decimales es tan exacto que se pierden demasiados casos en que los planetas se ven alineados al ojo humano pero simplemente no da una alineacion exacta. Es por esto que se dejó en 1 por defecto la precisión.

-   Una si la galaxia está inicializada y se trata de correr de nuevo el Job de inicialización este respondera rapidamente ya que está inicializada, hay que destruirla si se desea inicializar con otra aproximación por ejemplo.
La aplicacion fue desplegada en un servidor gratuito en la nube con Pivotal Cloudfoudry (http://docs.run.pivotal.io/).
-   El proyecto fue subido a Github y compartido publicamente para que puedan clonarlo y examinarlo mas comodamente https://github.com/kelvyns/GalaxyService.


---

> <b>Servicios de la galaxia:</b>

* [http://galaxy-kelvynscomar.cfapps.io/initializeGalaxy]
> Job para inicializar la Galaxia. 

* [http://galaxy-kelvynscomar.cfapps.io/initializeGalaxy?precision=1&destroy=0]
> Parámetros opcionales:
<b>precision=X</b> (valores permitidos: 0,1,2,3) (Valor por defecto 1)
<b>destroy=Y</b> (valores permitidos: 0, 1) (1 borra la BD, 0 valor por defecto no hace nada)

* [http://galaxy-kelvynscomar.cfapps.io/periodos?tipo=lluvia]
> Consulta que cantidad de períodos que la galaxia tuvo con determinado tipo de clima. Valores permitidos <b>['sequia', 'lluvia', 'nollueve', 'optimo']</b>

* [http://galaxy-kelvynscomar.cfapps.io/clima?dia=0]
> Climas segun el dia (De 0 a 3650 dias)

* [http://galaxy-kelvynscomar.cfapps.io/diaMasLluvioso]
> El dia mas lluvioso

-----



> <b> Tecnologías utilizadas </b>
*   Java 7
*   Maven
*   Spring boot
*   JUnit
*   Mockito
*   JPA
*   H2DATABASE
*   Log4j
*   GitHub
*   Pivotal Web Services
*   STS (SpringToolSuite)



> <b>License</b>
*   MIT
*   Free Software


---

>   <b>Respondiendo a las cuestiones planteadas:</b>


*   ¿Cuántos períodos de sequía habrá?
http://galaxy-kelvynscomar.cfapps.io/periodos?tipo=sequia
							 					
*   ¿Cuántos períodos de lluvia habrá y qué día será el pico máximo de lluvia?		
http://galaxy-kelvynscomar.cfapps.io/periodos?tipo=lluvia
	http://galaxy-kelvynscomar.cfapps.io/diaMasLluvioso
				 								
*   ¿Cuántos períodos de condiciones óptimas de presión y temperatura habrá? 
http://galaxy-kelvynscomar.cfapps.io/periodos?tipo=optimo


> <b>Bonus</b>


-   Para poder utilizar el sistema como un servicio a las otras civilizaciones, los Vulcanos requieren tener una base de datos con las condiciones meteorológicas de todos los días y brindar una API REST de consulta sobre las condiciones de un día en particular.

-   1) Generar un modelo de datos con las condiciones de todos los días hasta 10 años en adelante utilizando un job para calcularlas.<b> COMPLETADO</b>
El modelo de datos fue creado, se inicializa con un servicio o un job donde se calculan las condiciones para los próximos 10 años. Luego los demás servicios van a la BD a obtener la información ya guardada.
-   2) Generar una API REST la cual devuelve en formato JSON la condición climática del día consultado. <b>COMPLETADO</b>
-   3) Hostear el modelo de datos y la API REST en un cloud computing libre (como APP Engine o Cloudfoudry) y enviar la URL para consulta <b>COMPLETADO</b>	
 
   
> <b>Desarrollador</b>
-   Kelvyns Aguilar

						 					


