# Algorithms
Repository of short algorithms 
# Knapsack Problem 1/0 Dynamic Programming Solution
Description of the problem: We have n items each with some cost wi and a limit W for the total cost. Each item has a value vi. We want to select items to get the highest possible value V while they are below the limit of W.

Formal description: given two tuples of positive numbers [v1,...,vn] and [w1,...,wn] and W > 0, we look for a subset A of files with maximized sum of V that fits into space W.

Dynamic programming solution:

1.) Decompose the problem into smaller problems: construct a 2D array V[0...n, 0...W] where entry V[i,w] stores the maximum computing time of any subset of files A with size at most w. The entry V[n, W] contains the max computing time of files that fit into storage - the solution.

2.) Bottom up computing V[i,w] using iteration
Bottom: V[0,w] = 0
Computing: create a 2D array using V[i,w] = max([i-1,w], Vi + V[i-1,w-Wi]) for every cell
There are two choices for file i: leave or take the file. We can only take the file if Wi <= w, then we add Vi of computing time but spend Wi bytes of storage.
