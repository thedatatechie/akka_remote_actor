### To Compile
use `sbt clean assembly` to comile the code

### To submit job
# Submit the MainServer on the server (docker cluster)
`java -cp AkkaRemoteActors-assembly-1.1.jar com.user.remote.MainServer`
# Submit the MainClient on the client 
`java -cp AkkaRemoteActors-assembly-1.1.jar com.user.remote.MainClient`
