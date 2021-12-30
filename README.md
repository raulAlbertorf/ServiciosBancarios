# ServiciosBancarios
API REST para busqueda de servicios bancarios Banamex

Pasos para usar el API
1.- Carga Base de datos con Servicios Bancarios Banamex
    - POST
      - http://localhost:8082/servicio/carga/servicios
   
2.- Ejecutar la busqueda del Servicio Bancario necesitado con alguno de los servicios expuestos
  
    - GET
      - Buscar por un lugar (Colonia, Avenida, Localidad, Direccion en Español, Direccion en Ingles)
        http://localhost:8082/servicio/buscar?lugar=Av. Ejercito Nacional
