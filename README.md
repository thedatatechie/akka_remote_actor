## To Compile
use `sbt clean assembly` to comile the code

## To start the Docker instance

## To submit the job
### Start the MainServer on the server (docker cluster)
`java -cp AkkaRemoteActors-assembly-1.1.jar com.user.remote.MainServer`
### Start the MainClient on the client 
`java -cp AkkaRemoteActors-assembly-1.1.jar com.user.remote.MainClient`
