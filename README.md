# RouterPatchCheck
Java program that loads data from a csv file containing a list of routers and retrieves only the routers that ought to be patched:

The routers that need to be patched are selected based on a number of criteria:
- The router has not already been patched.
- The current version of the router OS is 12 or above.
- There are no other routers that share the same IP address.
- There are no other routers that share the same HostName.


The program can be run through the command line after compilation. It takes one command line argument - the csv file name (or path + name).

To compile: javac routerPatchCheck.java
To run: java routerPatchCheck [filename]

The program outputs the list of routers that need patching onto the command line. 
