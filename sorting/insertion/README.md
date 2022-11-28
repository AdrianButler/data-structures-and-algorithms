# Blog Notes: Insertion Sort

## Step Through

To guide me as I step through I will be following this psuedocode example:
```psuedo
 InsertionSort(int[] arr)

    FOR i = 1 to arr.length

      int j <-- i - 1
      int temp <-- arr[i]

      WHILE j >= 0 AND temp < arr[j]
        arr[j + 1] <-- arr[j]
        j <-- j - 1

      arr[j + 1] <-- temp
```

To step through I will be using the insertion sort I will be using this input array: `[8,4,23,42,16,15]`

i = 1  
j = 0  
temp = 4 (second index of array)

both conditions are true for while loop
arr[1] = arr[0] - arr = [8, 8, 23, 42, 16, 15]
j = -1
arr[0] = 4 (j + 1 = temp) | arr = [4, 8, 23, 42, 16, 15]

j < 0 so the loop breaks
-----

i = 2
j = 1
temp = 23 (arr[i])

j is >= 0 but temp is not < 8 so loop never activates
----- arr = [4, 8, 23, 42, 16, 15]

i = 3
j = 2
temp = 42 (arr[i)

j is >= 0 but temp is not < 23 so loop never activates
---- arr = [4, 8, 23, 42, 16, 15]

i = 4
j = 3
temp = 16 (arr[i)

both conditions for loop are true
arr[4] = arr[3] - [4, 8, 23, 42, 42, 15]
j = 2
arr[3] = 16 - [4, 8, 23, 16, 42, 15]

both conditions for loop are true
arr[3] = arr[2] - [4, 8, 23, 23, 42, 15]
j = 1
arr[2] = 16 - [4, 8, 16, 23, 42, 15]

j is >= 0 but temp is not less that 8
----

i = 5
j = 4
temp = 15 (arr[i)

both conditions for loop are true
arr[5] = arr[4] - [4, 8, 16, 23, 42, 42]
j = 3
arr[4] = 15 - [4, 8, 16, 23, 15, 42]

both conditions are true
arr[4] = arr[3] - [4, 8, 16, 23, 23, 42]
j = 2
arr[3] = temp - [4, 8, 16, 15, 23, 42]

both conditions are true
arr[3] = arr[2] - [4, 8, 16, 16, 23, 42]
j = 1
arr[2] = temp - [4, 8, 15, 16, 23, 42]

at this point the loop will continute for a few more iterations but the array is sorted so nothing else will happen

