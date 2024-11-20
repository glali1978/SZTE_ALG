MOD = 10 ** 9 + 7
import sys
sys.setrecursionlimit(10**6)  # Állítsuk a maximális rekurziós mélységet magasabb értékre
# Memorization tároló az eredményekhez
memo = {}

def kiszamitas(n):
    # Alapeset: Az összeg 0 elérésének egyetlen módja van (nem dobunk semmit)
    if n == 0:
        return 1
    # Ha a szám kisebb, mint 0, nincs lehetséges megoldás
    if n < 0:
        return 0
    # Ha az eredmény már ki van számolva, térjünk vissza a tárolt értékkel
    if n in memo:
        return memo[n]

    # Számítsuk ki az n-hez vezető összes lehetőséget az utolsó legfeljebb 6 lépés alapján
    memo[n] = 0
    for i in range(1, 7):
        memo[n] += kiszamitas(n - i)
        memo[n] %= MOD  # Tartsuk a számokat a MOD tartományon belül

    return memo[n]

# Bemenet
n = int(input().strip())
print(kiszamitas(n))