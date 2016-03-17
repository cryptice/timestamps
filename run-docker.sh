#!/usr/bin/env bash

SERVICES='timestamps-application'

build() {
        for service in $SERVICES
        do
            cd $service
            docker_file=src/deployment/Dockerfile
            echo "Building image from Docker file $docker_file"
            docker build -t $service:$VERSION -f $docker_file .
            cd ..
        done

}

start() {
        docker run -d -p 8950:8950 --name timestamps-application timestamps-application:latest
}

stop() {
    for service in $SERVICES
    do
        docker stop $service
    done
}

remove() {
    for service in $SERVICES
    do
        docker rm $service
    done
}

if [ -n "$2" ];
then
    echo "Using version: '$2'"
    VERSION=$2;
else
    echo "Using latest version"
    VERSION=latest;
fi

case "$1" in
    build)
        build
        ;;

    start)
        start
        ;;

    stop)
        stop
        ;;

    restart)
        stop
        remove
        start
        ;;

    *)
        echo "USAGE: run-docker build|start|stop|restart [VERSION]"
esac
