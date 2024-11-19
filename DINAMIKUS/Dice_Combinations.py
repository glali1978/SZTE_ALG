MOD = 10**9 + 7
n = int(input().strip())
tabla = [0] * (n + 1)
tabla[0] = 1  # Alapeset: nincs dobás szükséges az összeg 0 eléréséhez
ablakosszeg = tabla[0]  # kezdeti érték
for i in range(1, n + 1):
    tabla[i] = ablakosszeg % MOD  # Az aktuális összeg az ablak összegéből származik
    # Ablakosszeg frissítés
    if i < 6:
        ablakosszeg += tabla[i]
    else:
         ablakosszeg = (ablakosszeg + tabla[i] - tabla[i - 6]) % MOD

print(tabla[n] % MOD)