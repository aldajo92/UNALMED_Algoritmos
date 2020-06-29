line = input().split(" ")
n = int(line[0])
k = int(line[1])
values = []
for i in range(int(line[0])):
    values.append(int(input()))

values.sort()
print("{} {}".format(values[int((k-1)/n)], values[(k-1)%n]))