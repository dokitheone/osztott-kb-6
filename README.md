Készítsd el egy szerver-kliens alkalmazás szerver oldalát sockettel!
Indíts el egy szerver socketet az 12345 porton! A fájl neve legyen TippServer.java. A szerver, amikor elindult, sorsoljon egy számot 1 és 100 között, majd írja ki. A kliensek feladata az, hogy kitalálják mi ez a szám. Minden csatlakozó kliensnek indíts egy külön szálat. A kliensek átküldenek egy számot a szervernek szövegként. Ha a szerver által tárolt szám kisebb, mint a kliens tippje, akkor küldje vissza azt az üzenetet, hogy "Kisebb", ha nagyobb, akkor azt, hogy "Nagyobb". Ha pedig a két szám egyenlő, akkor az "Eltalaltad" üzenetet küldje vissza és fejeződjön be a szál futása. Ha szerverhez 10 mp-ig nem csatlakozik kliens, akkor álljon le a szerver és írja ki a képernyőre, hogy leállt. Ehhez használd
a setSoTimeout() metódust. A leállásnál ne írjon ki hibaüzenetet.

A kliens (TippKliens.javaView in a new window) működése: Elindít 5 darab klienst, akik csatlakoznak a szerverhez. Addig küldik a tippjeiket a szervernek, míg ki nem találták azt a számot, amit a szerver tárol. Minden tipp után a szervertől kapott üzenet szerint szűkítik az intervallumot, ahonnan a tippet sorsolják. Ha eltalálták, befejeződik az adott kliens futása.

Megoldásként egyetlen java forrásfájlt tölts fel!
