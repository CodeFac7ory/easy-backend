# Aufgabe: Modulabhängigkeit

Dieses Maven-Projekt besteht aus den drei Submodulen `booking`, `notification` und `application`.

 - Das `notification`-Modul ist vom `booking`-Modul abhängig
 - Das `application` ist von beiden andere abhängig und dient als Hauptmodul

Der `BookingTest` ruft `BookingService#create(Booking)` auf und prüft, ob die Methoden `MailSender#send(Booking)` und `PushSender#send(Booking)` mit dem gleichen Parameter aufgerufen wurden.

## Akzeptanzkritieren:
 - Nachdem eine `Booking` erstellt wird, müssen `MailSender#send(Booking)` und `PushSender#send(Booking)` ausgeführt werden
 - Der `BookingTest` muss erfolgreich sein

## Bedingungen:
 - Die Klasse `Booking` und die Methode `BookingTest#itCreatesBooking` dürfen nicht modifiziert werden
 - Die bestehenden Klassen dürfen nicht zwischen den Modulen verschoben werden
 - Die Abhängigkeiten zwischen den Modulen dürfen nicht angepasst werden
 - Ansonsten können beliebige Maven-Dependencies hinzugefügt werden
 - Erlaubte Programmiersprachen: Java und Kotlin

---

# Task: Module Dependencies

This Maven project consists of three sub modules `booking`, `notification` and `application`.

 - module `notification` depends on `booking`
 - module `application` depends on the other two serves as main module

`BookingTest` calls `BookingService#create(Booking)` and checks if methods `MailSender#send(Booking)` and `PushSender#send(Booking)` are called with the same parameter.

## Acceptence criteria:
 - After a `Booking` has been created `MailSender#send(Booking)` and `PushSender#send(Booking)` are to be invoked
 - `BookingTest` must be successful

## Conditions:
 - Class `Booking` and method `BookingTest#itCreatesBooking` must not be modified
 - Existing classes must not be moved across modules
 - Dependencies between modules must not be modified
 - Any maven dependency may be added
 - Permitted programming languages: Java and Kotlin
