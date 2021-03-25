#!/bin/bash

echo "Cleaning Up ......................................."

chmod 777 shutdownClean.sh

# Clean up the repo
./shutdownClean.sh

sleep 5m


# Build & generate docker of API
cd  aei-product-inventory-api/

# Docker Build
mvn install docker:build

echo ".............................................................................."

echo "Build is successful for API .................................................."

echo ".............................................................................."

# Build & generate docker of consumer
cd  ../aei-state-event-consumer/

# Docker Build
mvn install docker:build

echo ".............................................................................."

echo "Build is successful for state consumer ......................................."

echo ".............................................................................."

cd ../

# Docker Compose Up
docker-compose up


echo "Running basic tests ......................................."

chmod 777 tests.sh

# triggering the test
./tests.sh

echo "Tests are completed, stopping the server"

chmod 777 shutdownClean.sh

# Clean up the repo
./shutdownClean.sh