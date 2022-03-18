# new feature
# Tags: optional

Feature: Eliminar la informacion del usuario
  Yo como usuario
  Quiero poder eliminar mi informacion
  Para no aparecer en la base de datos de la página

  Scenario: Eliminar la informacion del usuario
    Given El usuario esta en la pagina para eliminar su informacion
    When el usuario realiza la peticion de eliminacion de datos con el id 2
    Then el usuario debera ver un codigo de respuesta de eliminacion exitosa