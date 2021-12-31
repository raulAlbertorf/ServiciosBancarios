# ServiciosBancarios
API REST para busqueda de servicios bancarios Banamex

## Importar espacio de trabajo en Postman (Cargado en este repositorio Github): 

       ServiciosBancarios/postman/ServiciosBancarios.postman_collection.json

## Pasos para usar el API

### 1.- Carga Base de datos con Servicios Bancarios Banamex
       
    - POST
      - http://localhost:8082/servicio/carga/servicios
      
### 2.- Consultar los Servicios Bancarios disponibles al momento

    - GET
      - http://localhost:8082/servicio/listar
              
        Al 30/12/2021 se tienen los siguientes servicios disponibles:
             [
                  "100 - Sucursal",
                  "110 - Sucursal Digital",
                  "300 - ATM",
                  "400 - Sucursal Automatica",
                  "500 - Banca Patrimonial",
                  "600 - AFORE",
                  "800 - Banca Privada",
                  "900 - Ejecutivo Priority",
                  "950 - Espacio Priority"
              ]
          
   
   
### 2.- Ejecutar la busqueda del Servicio Bancario necesitado con alguno de los servicios expuestos
  
    - GET
      - Buscar por un lugar (Colonia, Avenida, Localidad, Direccion en Español, Direccion en Ingles)
        http://localhost:8082/servicio/buscar?lugar=Av. Ejercito Nacional
        
      - Buscar por servicio disponible
        http://localhost:8082/servicio/buscar/servicio?servicio=ATM
       
      - Buscar por lugar (Colonia, Avenida, Localidad, Direccion en Español, Direccion en Ingles), codigo postal y estado 
        http://localhost:8082/servicio/buscar/lugar/codigoPostal/estado?lugar=Papagayo&codigoPostal=82011&estado=Sinaloa
       
      - Buscar por lugar (Colonia, Avenida, Localidad, Direccion en Español, Direccion en Ingles), codigo postal, estado y servicio
        http://localhost:8082/servicio/buscar/lugar/codigoPostal/estado/servicio?lugar=Papagayo&codigoPostal=82010&estado=Sinaloa&servicio=ATM
        
        
