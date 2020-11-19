# Aufgabe: Testen

Dieses Projekt enthält die Geschäftslogik einer Buchungsverwaltung. Eine `Booking` bezieht sich stets auf eine `seatId`
und definiert einen Zeitraum mittels `start` und `end`. Mittels `Booking#blocks` kann überprüft werden, ob sich zwei
Buchungen für denselben Sitz überschneiden.

`BookingService#validate` überprüft eine eingehende Buchung auf ihre strukturelle Gültigkeit.

`BookingRepository` definiert als Schnittstelle eine Methode zum Abgleich auf bestehende Buchungen, die sich mit dem
Argument überschneiden können.

Mittels Unit-Tests `BookingTest` und `BookingServiceTest` sollen Richtigkeit und Robustheit der Implementierung
sichergestellt werden.

## Akzeptanzkritieren:
 - `BookingTest` und `BookingServiceTest` wurden implementiert
 - `BookingTest` und `BookingServiceTest` zeigen eine überzeugende Zahl an Testfällen. Bedenke Randfälle.
 - `BookingTest` prüft `Booking#blocks` mit verschiedenen Buchungen
 - `BookingServiceTest` prüft `BookingService#validate` mit verschiedenen Buchungen und Szenarien
 - `BookingTest` und `BookingServiceTest` müssen erfolgreich sein

## Bedingungen:
 - `Booking`, `BookingService` und `BookingRepository` können nicht modifiziert werden
 - bestehende Klassen dürfen nicht zwischen Paketen verschoben und die Paketstruktur nicht verändert werden
 - Ansonsten können beliebige Maven-Dependencies hinzugefügt werden
 - Erlaubte Programmiersprachen: Java und Kotlin

---

# Task: Testing

This project contains business logic for a booking management solution. A `Booking` always refers to a `seatId` and
defines a timespan using `start` and `end`. Intersections between bookings for the same seat can be checked using
`Booking#blocks`.

`BookingService#validate` checks an incoming booking for structural validity.

`BookingRepository` defines an interface for checking for existing bookings that might intersect with  given argument.

Unit tests `BookingTest` and `BookingServiceTest` are supposed to show validity and robustness of our implementation.

## Acceptence criteria:
 - `BookingTest` and `BookingServiceTest` are implemented
 - `BookingTest` and `BookingServiceTest` show a convincing amount of test cases. Consider edge cases.
 - `BookingTest` checks `Booking#blocks` with various bookings
 - `BookingServiceTest` checks `BookingService#validate` with various bookings and scenarios
 - `BookingTest` and `BookingServiceTest` must be successful

## Conditions:
 - `Booking`, `BookingService` and `BookingRepository` may not be modified
 - Existing classes must not be moved and package structure must not be modified
 - Any maven dependency may be added
 - Permitted programming languages: Java and Kotlin
