Ride Share Project Information
    - This program creates a road with 32 stations, each located one mile apart. There are a certain 
      number of cars, each with their unique start and end destinations, that can travel either 
      left or right along the road, picking up and dropping off passengers as they go.
    - The program moves each car a total of 100 times.
    - Each time a car carries a passenger one mile, the car earns $1, and the total revenue is 
      calculated at the end of the program. 

Average revenue results after moving cars 100 times:
    - Different average revenues from simulations with 20 cars and 50 passengers:
        1.067
        0.975
        1.331
        1.459
        1.153
        1.197
        1.256
        1.563
    - Different average revenues from simulatons with 10 cars and 40 passengers:
        1.376
        1.647
        1.664
        1.938
        1.671
        1.920
        1.733
        2.254
    - Overall, the scenario with 10 cars and 40 passengers generally produces a higher average 
      revenue per car, though the two scenarios are very close.


Challenges
    - By far the most difficult aspect of the project for me was moving cars between stations 
      each time they moved. At first, I was unknowingly causing double referencing errors because
      I was storing each Car object in two different arrays. However, even after solving this issue,
      I had many more problems to fix before finally getting the program to work. 