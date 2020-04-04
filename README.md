<h1>Disk Simulation Program</h1>

This program is homework assignment #3 for CSCI 4500.

<h2>Usage</h2>

```disk-simulation.jar [algorithm] [queue depth] [file]```

<h4>Allowed Parameters</h4>

Algorithm: SSTF, CSCAN, SCAN, FIFO

Queue Depth: Any integer

File: Abosolute path to file. Each line in the file must be a cylinder request represented by an integer. 

<h4>Examples</h4>

```disk-simulation.jar sstf 10 /Users/me/Desktop/requests.txt```

Starts a new simulation using the SSTF algorithm with a queue depth of 10 using the requests.txt file.
