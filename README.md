# SE1Uebung2

## Zu Aufgabe 2 FA2 

Mit einer Exception wird klar signalisiert, dass etwas Unerwartetes passiert ist bzw. passieren könnte. Dies führt zu einer besseren Trennung zwischen dem normalen Code und den Ausnahmefällen die auftreten können. Bei einer Rückgabe von einem belieben Rückgabewert (z.B null, true, false, 0, n) ist der Kontext nicht so offensichtlich, wodurch der Code schwerer zu verstehen ist. Außerdem können Exceptions detaillierte Fehlermeldungen liefern und das FehlerHandling geschieht sowieso schon durch Java mit Exceptions, wodurch das eigene Handling mit Exception zu einer besseren Konsitenz des Codes führt.

In meiner Methode ist der Rückgabewert true/false. Dieser kommt durch die remove-Methode der Collection Klasse.
