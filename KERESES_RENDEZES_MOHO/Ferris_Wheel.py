# Bemenet
# 4 10
# 7 2 3 9
n_x = input().strip().split()
n = int(n_x[0])
x = int(n_x[1])
sulyok = list(map(int, input().strip().split()))
#
#
# Lépés 1:
sulyok.sort() # Rendezni a súlyokat
#
# Két mutató inicializálás
i = 0  # Kezd mutató
j = n - 1  # Vég mutató
gondolak = 0  # Számláló gondolák

# Lépés 2: Ameddig a Kezd mutató kevesebb vagy egyenlő mint a Vég mutató
while i <= j:
    # Ha a legkönnyebbek és a legnehezebbek megoszthatnak egy Gondolák
    if sulyok[i] + sulyok[j] <= x:
        i += 1  # Kezdő mutató növelése
    # Akár párosítva, akár nem, a legnehezebb gyermeket egy Gondolához rendelik.
    j -= 1  # Vég pointer csökkentése
    gondolak += 1  # Gondolák számának emelése

print(gondolak)