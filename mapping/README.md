# Aufgabe: Mapping

Der `BookingControllerTest` prüft folgendes Verhalten:
 - rufe `BookingController#list` auf und prüfe, ob 5 Einträge aufsteigender Ids mit Inhalt zurückgegeben werden
 - rufe `BookingController#details(2002L)` auf und prüfe, ob ein Objekt mit Inhalt zurückgegeben wird
 - rufe `BookingController#details(6006L)` auf und prüfe, ob eine Exception mit der Nachricht "not found" geworfen wird

## Akzeptanzkritieren:
 - `Booking` wird korrekt zu `BookingDto` gemappt (Siehe `BookingController#list` und `BookingController#details`) und vom Controller ausgegeben
 - Die Collection von `BookingBlockDto` in `BookingDto` ist nach dem `sortIndex` in `BookingBlockDto` 
 - Falls ein `Booking` per ID nicht gefunden werden kann, soll eine `IllegalStateException` mit Nachricht "not found" geworfen werden (Siehe `BookingController#details`)
 - Der `BookingControllerTest` muss erfolgreich sein

## Bedingungen:
 - Entities und DTOs können mit Interfaces/Properties erweitert werden
 - Bestehende Felder von Models und DTOs können nicht modifiziert werden
 - Die Klasse `BookingControllerTest` darf nicht modifiziert werden
 - Bestehende Klassen dürfen nicht zwischen Paketen verschoben und die Paketstruktur nicht verändert werden
 - Ansonsten können beliebige Maven-Dependencies hinzugefügt werden
 - Erlaubte Programmiersprachen: Java und Kotlin

---

# Task: Mapping

`BookingControllerTest` checks for following behaviour:
 - call `BookingController#list` and check for 5 entries with content and IDs of ascending order being returned
 - call `BookingController#details(2002L)` and check for an object with content
 - call `BookingController#details(6006L)` and check for an exception with message "not found" being thrown

## Acceptence criteria:
 - `Booking` is correctly mapped to `BookingDto` (see `BookingController#list` and `BookingController#details`) and returned by the controller
 - Collection of `BookingBlockDto` in `BookingDto` is sorted by `sortIndex` in `BookingBlockDto` 
 - If a `Booking` cannot be found by id, an `IllegalStateException` with message "not found" is to be thrown (see `BookingController#details`)
 - `BookingControllerTest` must be successful

## Conditions:
 - Entities and DTOs may be extended with Interfaces/Properties
 - Existing fields of entities and DTOs may not be modified
 - Class `BookingControllerTest` may not be modified
 - Existing classes must not be moved and package structure must not be modified
 - Any maven dependency may be added
 - Permitted programming languages: Java and Kotlin
