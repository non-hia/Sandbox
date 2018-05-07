import numpy as np
import matplotlib.pyplot as plt

print("テスト")

def f(x):
    return 2 * x + 1

x = np.linspace(-3, 3, 10)

plt.plot(x, f(x), color='red')
plt.grid(True)
plt.savefig('png/test.png')

