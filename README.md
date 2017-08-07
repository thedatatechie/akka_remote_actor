## To Compile
use `sbt clean assembly` to comile the code

## To start the Docker instance
Run the following commands in the project folder with the Dockerfile.

`docker build -t centos:new .`

`docker run -v host_folder:/data -p 2552:2552 -p 2553:2553 -p 2554:2554 -it centos:new`

## To submit the job
### Start the MainServer on the server (docker cluster)
Do the following on the server (docker cluster).

`cd /data` then

`java -cp AkkaRemoteActors-assembly-1.1.jar com.user.remote.MainServer`
### Start the MainClient on the client
Do this on the client i.e. host.

`java -cp AkkaRemoteActors-assembly-1.1.jar com.user.remote.MainClient`
