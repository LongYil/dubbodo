#!/bin/sh

docker build -t bootconsumer:v1.0.0 .

docker tag bootconsumer:v1.0.0 10.10.102.113:8443/library/bootconsumer:v1.0.0

docker push 10.10.102.113:8443/library/bootconsumer:v1.0.0