# new feature
# Tags: optional

Feature: Actualizar la informacion del usuario
  Yo como usuario
  Quiero poder modificar mi informacion
  Para mantenerla actualizada en la pagina

  Scenario: Actualizar la informacion del usuario
    Given El usuario esta en la pagina para actualizar su informacion con el nombre "morpheus" y el trabajo "zion resident"
    When el usuario realiza la peticion de actualizacion de datos con el id 2
    Then el usuario debera ver un codigo de respuesta exitoso y su informacion completa actualizada