n = int(input())
if n % 3 == 0:
    expo = n // 3
    print( 3 ** expo)
elif n % 3 == 1:
    expo = n // 3 - 1
    print(4 * 3 ** expo)
else:
    expo = n // 3 - 1
    print( 2 * 3 ** expo)
