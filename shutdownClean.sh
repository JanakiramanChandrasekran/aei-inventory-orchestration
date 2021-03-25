#!/bin/bash

# Removing the github clone's
rm -rf aei-inventory-orchestration/

docker-compose down

# Clean up Docker Images
docker rmi -f aei-product-inventory-api:0.0.1-SNAPSHOT
docker rmi -f aei-state-event-consumer:0.0.1-SNAPSHOT
