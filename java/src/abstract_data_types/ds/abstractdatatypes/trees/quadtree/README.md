## Quad Tree

Quadtrees are trees used to efficiently store data of points on a two-dimensional space. In this tree, each node has at most four children.
We can construct a quadtree from a two-dimensional area using the following steps:

* Divide the current two dimensional space into four boxes.
* If a box contains one or more points in it, create a child object, storing in it the two dimensional space of the box
* If a box does not contain any points, do not create a child for it
* Recurse for each of the children.

Quadtrees are used in image compression, where each node contains the average colour of each of its children. The deeper you traverse in the tree, the more the detail of the image.
Quadtrees are also used in searching for nodes in a two-dimensional area. For instance, if you wanted to find the closest point to given coordinates, you can do it using quadtrees.

## Insert Function

The insert functions is used to insert a node into an existing Quad Tree. This function first checks whether the given node is within the boundaries of the current quad. If it is not, then we immediately cease the insertion. If it is within the boundaries, we select the appropriate child to contain this node based on its location.
This function is O(Log N) where N is the size of distance.

## Search Function

The search function is used to locate a node in the given quad. It can also be modified to return the closest node to the given point. This function is implemented by taking the given point, comparing with the boundaries of the child quads and recursing.
This function is O(Log N) where N is size of distance.

@see https://www.geeksforgeeks.org/quad-tree/