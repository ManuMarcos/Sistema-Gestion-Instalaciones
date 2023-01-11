# Sistema de Gestion de Instalaciones


**Empresa de Instalación de Aire Acondicionado**

El equipo de analistas ha finalizado el relevamiento para la confección de un sistema de gestión de servicios de instalación de equipos de aire acondicionado.

**Se solicita al equipo de diseñadores que diseñe e implemente el sistema relevado**.  A continuación, se detalla el relevamiento y los requerimientos obtenidos por el equipo.

La compañía de instalación de AC posee un equipo de técnicos de servicios, un Call Center, un área administrativa y un área de sistemas que opera todos los sistemas con permisos de Administrador.

La compañía cuenta con un stock de equipos de aire acondicionado: Evaporadoras, Condensadoras, Kits de instalación _(con caños, aislantes y válvulas de conexión apropiados para los equipos a instalar)_ que utiliza para realizar las instalaciones.

La compañía distribuye el trabajo en cuatro equipos de trabajo distintos. Cada equipo tiene un **perfil de acceso** y actividades definidos. La información obtenida para cada perfil es la siguiente:

- **Operador de Call Center**: los operadores programan las instalaciones que realizarán los técnicos a los clientes que se comunican al Call Center. En caso de que el cliente no exista, el Call Center lo da de alta. Las instalaciones se pactan en días y horarios donde tanto el técnico como el cliente tienen disponibilidad de agenda. Una instalación sólo puede ser pactada si existe el stock necesario para llevarla adelante.

- **Técnico**: ejecuta las instalaciones planificadas por el Call Center, en el día y hora seleccionados. Las instalaciones asignadas a cada técnico serán visibles desde la aplicación al ingresar con dicho perfil. Cada técnico podrá ver las instalaciones que le han sido asignadas e ingresar en las mismas para gestionarlas. Para registrar el trabajo hecho en una instalación, deberá poder indicar la hora de inicio y de finalización de esta y los elementos utilizados. Los técnicos trabajarán en un único turno diario _(mañana o tarde)._

- **Administrativo**: factura al cliente las instalaciones realizadas, una vez que éstas están finalizadas correctamente. Emitirá la correspondiente factura y la enviará al cliente en formato PDF, a la dirección de correo electrónico indicada por éste al momento de crearlo. De ser necesario, puede ajustar valores de la instalación realizada antes de imprimir la factura.
Además, revisa los listados de facturas emitidas para controlar el resultado de la venta y confirmar los márgenes.

- **Administrador del sistema**: Realiza el ABM de técnicos de los artículos de stock _(con sus correspondientes cantidades y costos de compra)_, y configura el costo de las horas de trabajo para cada técnico, según su tipo: Junior, Semi-Senior, Senior. Realiza además la configuración de todos los parámetros adicionales necesarios para el correcto funcionamiento del sistema. El administrador también ajusta los valores de stock existente para cada artículo y su costo, ya que la gestión de compras se realiza en un sistema separado que no afecta este desarrollo.

La dinámica de funcionamiento de la compañía requiere que:

El acceso al sistema se realice dependiendo del usuario que ingresa: Técnico, Administrativo, Call-Center, o administrador del sistema. El perfil de cada uno determinará las funciones habilitadas y los menús que verá.

Los clientes llaman y solicitan las instalaciones. Son identificados en el sistema con su CUIT/CUIL el que se ingresa al crear nuevos clientes. Éstas serán agendadas por técnico, según su horario de trabajo (o turno) y disponibilidad, siendo:

- _Turno Mañana_: 08:00hs a 14:00hs _(de lunes a sábados)_
- _Turno Tarde:_ 14:00hs a 20:00hs _(de lunes a viernes)_

En un mismo día se podrán visitar múltiples clientes dentro del horario de trabajo de los técnicos asignados.

Cada instalación será identificada con un contador único correlativo y requerirá sólo un técnico. Adicionalmente, cada instalación se realizará siempre a un único cliente, en un día y horario pactados.

De cada instalación se controlarán los siguientes conceptos:

- _Tiempo trabajado_: incluye el tiempo trabajado por cada técnico. El tiempo trabajado se calculará como diferencia entre la hora de inicio y de finalización de la instalación, ingresadas en la aplicación. Al total de tiempo, se lo multiplicará por el costo/hora de cada técnico.

 - _Equipos_: incluye los equipos utilizados durante la instalación. Los equipos deberán estar en stock al momento de realizar el agendamiento. Si no hay equipos, no se podrá realizar la reserva.El sistema deberá informar de esta necesidad.

- _Otros Costos_: incluye conceptos adicionales incurridos para la realización de la instalación. Las opciones elegibles son: Soportes para instalación en pared, Seguro para trabajos en altura (si los hay) y Costo del Viaje (hasta el domicilio del cliente).

- _Gastos_: los gastos incluyen sólo el almuerzo del técnico, pero no forman parte del costo de la instalación. El almuerzo será de cantidad 1 y su valor máximo será un valor fijo.

Las instalaciones tendrán los siguientes estados: Programada, En curso, Cancelada, Finalizada.

Los técnicos sólo pueden ser agendados en los días y horarios donde no posean instalaciones previas ya programadas.

Las instalaciones requerirán:

**Requerida:**
- una Evaporadora
- una Condensadora
- un Kit de Instalación
- Costo de viaje
- 1 hora de trabajo _(mínimo)_

**Opcional:**
- Seguro de trabajo en altura
- Soporte para pared
- Almuerzo

Entre cada instalación, los técnicos tendrán 30 minutos disponibles para viajes y tareas administrativas.

El costo de viaje es fijo y se asigna a cada instalación.

Si el técnico tuvo que almorzar durante la ejecución de una instalación, el tiempo de almuerzo (30 minutos) no se considerará como tiempo trabajado, sin embargo, el valor del almuerzo será cubierto por la empresa como Otros Gastos.

Al finalizar cada instalación, el técnico deberá indicar el tiempo trabajado (hora de inicio y fin), los materiales utilizados y los costos y gastos adicionales que pueda tener. Adicionalmente, indicará si tuvo tiempo de almuerzo y finalizará la instalación.

Con lo informado por el técnico, se deberá facturar al cliente la instalación, indicando los materiales utilizados, el tiempo trabajado y un IVA del 21%.

El sistema deberá permitir listar las facturas emitidas con su número, el total de precio de cada concepto y su precio total. Si la factura es tipo A, el IVA deberá aparecer discriminado. Sino, será incluido en el total de la factura.

El valor del precio será confirmado al momento de la reserva de la visita, considerando un margen del 65% sobre el costo base general de la instalación.

El sistema deberá permitir listar las instalaciones asignadas y su detalle (día, hora, cliente, técnicos, etc.), dependiendo del estado que se seleccione para listar.

**NOTA: Los puntos que no son marcados como requerimiento se dejan a criterio del equipo de diseñadores, quienes elegirán cómo resolver cada situación no contemplada en el relevamiento previo.**

 

----------


 >Todas las funcionalidades mencionadas deben ser desarrolladas. Sólo se indican las funcionalidades obligatorias en cada perfil, pero pueden agregarse todas las que sean necesarias para garantizar el correcto funcionamiento del sistema.
>El ajuste del stock lo realiza el Administrador del sistema
>El costo de viaje es ajustado por el Administrador del Sistema
