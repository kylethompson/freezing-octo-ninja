#/bin/bash

function outputBuildComment {
 echo "************************************"
 echo ""
 echo " " $1
 echo ""
 echo "************************************"
}

outputBuildComment "Packaging capDBADO library"
./sbt "project capDBDAO" clean package

outputBuildComment "Creating web front end distributable"
./sbt "project webFrontEnd" clean dist

outputBuildComment "Building dropwizard service"
outputBuildComment "Copying latest library files into service lib folder"
	[ -d ./services/lib/ ] || mkdir ./services/lib/
	cp ./libraries/capDBDAO/target/scala-2.10/capdbdao* ./services/lib/ -v
outputBuildComment "Assembling dropwizard service"
	(cd ./services && exec ./sbt assembly)


