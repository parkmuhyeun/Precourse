# ๐ ๋ผ์ด๋ธ๋ฌ๋ฆฌ ๋ถ์

---

## Console ๋ถ์

### readLine()
- ์ฌ์ฉ์์ ์๋ ฅ์ ๋ฐ๋ ๋ฉ์๋

### getInstance()
- ์ ์ญ๋ณ์๋ก ์ ์ธ๋ ์๋ Scanner ๋ฐํ
- null์ด๊ฑฐ๋ ๋ซํ์์ ๋๋ ์๋ก์ด Scanner ์์ฑ

### isClosed()
- scanner์ sourceClosed ๋ณ์ ๋ฐํ
>sourceClosed : ์์์ด ์ข๋ฃ๋์๋์ง ํ์ธ ๋ณ์(Boolean is true if source is done)
- getDeclaredField()
    - Java Reflection์ ์ฌ์ฉํ๋ฉด ํน์  ์ธ์คํด์ค์ ๋ฉค๋ฒ๋ณ์, ๋ฉ์๋ ๋ฑ์ ์ ๊ทผ ํ  ์ ์๋ค.
    - private์ธ ๋ฉค๋ฒ๋ณ์์ ์ ๊ทผํ๊ธฐ ์ํด์ getDeclaredFields ์ฌ์ฉ
- setAccessible()
    - getDeclaredField ๋ฉ์๋๋ก ๋ฉค๋ฒ๋ณ์ ์ ๋ณด์๋ ์ ๊ทผ ๊ฐ๋ฅํ๋ ๊ฐ์๋ ์ ๊ทผ์ด ๋ถ๊ฐ๋ฅํ๋ค.
    - private ๋ฉค๋ฒ ๋ณ์ ๊ฐ์ read/write ํ๊ธฐ ์ํด์๋ setAcccesible์ ํตํด ์ ๊ทผ์ ํ์ฉ ํด์ค์ผ ๋๋ค.


## Randoms ๋ถ์

>ThreadLocalRandom : ์๋ฐ7์์ ์ถ๊ฐ๋ ๊ธฐ๋ฅ์ผ๋ก ์ค๋ ๋ ๋ณ๋ก ๋์ ์์ฑ์ ํ  ์ ์๋ ๋๋ค ํด๋์ค, current() ๋ผ๋ ์ ์  ๋ฉ์๋๋ฅผ ํตํด ๊ฐ์ฒด๋ฅผ ์ป๋๋ก ๋์ด ์๋ค.

### pickNumberInList()
- validateNumbers() ์ฒดํฌ ํ
-  ํ๋ผ๋ฏธํฐ๋ก ๋์ด์จ list ์ค ์์ ๋๋ค ๊ฐ ๋ฐํ

### pickNumberInRange()
- validateRange() ์ฒดํฌ ํ
- startInClusive๋ถํฐ endInclusive ์ฌ์ด ์ซ์ ์ค ๋๋ค ์ซ์ ๋ฐํ

### pickUniqueNumbersInRange()
- validateRange() ์ฒดํฌ
- validateCount() ์ฒดํฌ ํ
- list์ startInclusive๋ถํฐ endInclusive ๊น์ง ์ซ์๋ฅผ ์ถ๊ฐํด shuffle() ํ ๋ค subList()๋ฅผ ์ด์ฉํด count ์๋งํผ ๋ฐํ
- ์ค๋ณต๋์ง ์๋ ํ๋์ ๋ฆฌ์คํธ์์ ๋ชจ๋  ์๋ฅผ ๋ฐํํ๊ธฐ ๋๋ฌธ์ ๋ฐํ๋ ์ซ์๋ ๋ชจ๋ uniqueํ๋ค.

### shuffle()
- ํ๋ผ๋ฏธํฐ๋ก ๋์ด์จ list ๋ด์ ์ซ์ ์๊ธฐ

### validateNumbers()
- ํ๋ผ๋ฏธํฐ๋ก ๋์ด์จ list๊ฐ ๋น์์ผ๋ฉด IllegalArgumentException ๋ฐ์

### validateRange()
- startInclusive๊ฐ endInclusive๋ณด๋ค ์์ผ๋ฉด IllegalArgumentException ๋ฐ์
- endInclusive๊ฐ Integer ์ต๋๊ฐ๊ณผ ๊ฐ์ ๊ฒฝ์ฐ IllegalArgumentException ๋ฐ์
- ์ ์ฒด ๋ฒ์๊ฐ Integer ์ต๋๊ฐ์ด ๋์ด ๊ฐ๋ ๊ฒฝ์ฐ IllegalArgumentException ๋ฐ์

### validateCount()
- count๊ฐ 0๋ณด๋ค ์๊ฑฐ๋ ์ ์ฒด ๊ฐ์ ๋ณด๋ค ํฌ๋ฉด IllegalArgumentException ๋ฐ์